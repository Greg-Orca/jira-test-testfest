pipeline {
    agent any

        parameters {
            password(name: 'PASSWORD', description: 'Encryption key')
//             string(name: 'USER_NAME')
//             string(name: 'BASE_URL')
        }

    stages {
        stage("Env var"){
            steps{
                sh(script: "printenv")
            }
        }
        stage("build"){
            steps{
                sh(script: "mvn compile")
            }
        }
        stage("run"){
            steps{
                sh(script: "mvn clean test -DPASSWORD=$PASSWORD")
            }
            post {
                always {
                    junit '**/target/surefire-reports/TEST-*.xml'
                }
            }
        }
    }
}