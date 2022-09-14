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
        stage("run"){
            steps{
                sh(script: "mvn clean test -DPASSWORD=${PASSWORD} -DUSER_NAME=${USER_NAME} -DBASE_URL=${BASE_URL}")
            }
            post{
                always {
                    junit '**/target/surefire-reports/TEST-*.xml'
                }
            }
        }
    }
}
