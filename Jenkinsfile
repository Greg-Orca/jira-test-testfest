pipeline {
    agent any

       parameters {
           password(name: 'PASSWORD', description: 'Encryption key')
       }

    stages {
        stage("build"){
            steps{
                sh(script: "mvn compile")
            }
        }
        stage("run tests"){
            steps{
                parallel{
                    stage('Test On Firefox') {
                        step {
                            sh(script: "mvn clean test -DPASSWORD=$PASSWORD -DUSER_NAME=$USER_NAME -DBASE_URL=$BASE_URL -DBROWSER='firefox'")
                        }
                    }
                    stage('Test on Chrome') {
                        step{
                            sh(script: "mvn clean test -DPASSWORD=$PASSWORD -DUSER_NAME=$USER_NAME -DBASE_URL=$BASE_URL -DBROWSER='chrome'")
                        }
                    }
                }
            }
            post{
                always {
                    junit '**/target/surefire-reports/TEST-*.xml'
                }
            }
        }
    }
}
