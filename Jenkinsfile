pipeline {
    agent any

        parameters {
            password(name: 'PASSWORD', description: 'Encryption key')
        }

    stages {
        stage("build"){
            steps{
            sh(script: "jenkins-plugin-cli --plugins test-results-analyzer:0.3.5")
                sh(script: "mvn compile")
            }
        }
        stage("run"){
            steps{
                sh(script: "mvn test -DUSERNAME=automation23 -DPASSWORD=$PASSWORD -DBASE_URL=https://jira-auto.codecool.metastage.net")
            }
            post {
                always {
                    junit '**/target/surefire-reports/TEST-*.xml'
                }
            }
        }
    }
}