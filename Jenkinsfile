pipeline {
    agent any

        parameters {
            password(name: 'PASSWORD', description: 'Encryption key')
            string(name: 'USER_NAME')
            string(name: 'BASE_URL')
        }

    stages {
        stage("Env var"){
            sh(script: "printenv")
        }
        stage("build"){
            steps{
                sh(script: "mvn compile")
            }
        }
        stage("run"){
            steps{
                sh(script: "mvn clean test -DUSERNAME=${USER_NAME} -DPASSWORD=${PASSWORD} -DBASE_URL=${BASE_URL}")
            }
            post {
                always {
                    junit '**/target/surefire-reports/TEST-*.xml'
                }
            }
        }
    }
}