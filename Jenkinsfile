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
            parallel{
                stage('Test On Firefox') {
                    steps{
                        sh(script: "mvn clean test -DPASSWORD=$PASSWORD -DUSER_NAME=$USER_NAME -DBASE_URL=$BASE_URL -DBROWSER='firefox'")
                    }
                    post{
                        always {
                            junit '**/target/surefire-reports/TEST-*.xml'
                        }
                    }
                }
                stage('Test on Chrome') {
                    steps{
                        sh(script: "mvn clean test -DPASSWORD=$PASSWORD -DUSER_NAME=$USER_NAME -DBASE_URL=$BASE_URL -DBROWSER='chrome'")
                    }
                    post{
                        always {
                            junit '**/target/surefire-reports/TEST-*.xml'
                        }
                    }
                }
            }
        }

    }
}

