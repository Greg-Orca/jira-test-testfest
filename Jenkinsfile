pipeline {
    agent any

    stages {
        stage("build"){
            steps{
                sh(script: "mvn compile")
            }
        }
        stage("run"){
            steps{
                sh(script: "mvn clean test -DUSERNAME=$USER_NAME -DPASSWORD=$PASSWORD -DBASE_URL=$BASE_URL -DBROWSER=$BROWSER")
            }
            post {
                always {
                    junit testResults: '**/target/surefire-reports/TEST-*.xml', skipPublishingChecks: true
                }
            }
        }
    }
}