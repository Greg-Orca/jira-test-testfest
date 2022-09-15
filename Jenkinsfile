pipeline {
    agent any

    stages {
        stage("build"){
            steps{
//                 cleanWs()
                sh(script: "mvn compile")
            }
        }
        stage("run"){
            steps{
                sh(script: "mvn clean test -DUSER_NAME=$USER_NAME -DPASSWORD=$PASSWORD -DBASE_URL=$BASE_URL -DBROWSER=$BROWSER")
            }
            post {
                always {
                    junit testResults: '**/target/surefire-reports/TEST-*.xml', skipPublishingChecks: true
                    cleanWs()
                }
            }
        }
    }
}