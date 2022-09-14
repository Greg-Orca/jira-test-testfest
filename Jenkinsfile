pipeline {
    agent any

    stages {
        stage("build"){
            steps{
                sh(script: "mvn -version")
                sh(script: "mvn compile")
            }
        }
        stage("run tests"){
            steps{
                sh(script: 'mvn -DUSERNAME=automation23 -DPASSWORD=$PASSWORD -DBASE_URL=//jira-auto.codecool.metastage.net clean test')
            }
        }
    }
    post {
        always{
            junit testResults: '**/test-reports/*.xml', allowEmptyResults: true, skipPublishingChecks: true
//             junit allowEmptyResults: true, testResults: '**/test-results/*.xml'
        }
    }
}