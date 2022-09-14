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
                sh(script: "mvn clean test -DUSERNAME=automation23 -DPASSWORD=$PASSWORD -DBASE_URL=https://jira-auto.codecool.metastage.net")
            }
            post {
                always {
                    junit '**/target/surefire-reports/TEST-*.xml'
                }
            }
        }
    }
}