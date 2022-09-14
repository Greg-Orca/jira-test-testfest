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
                sh(script: 'mvn -DUSERNAME=automation23 -DPASSWORD=$PASSWORD -DBASE_URL=$baseurl test')
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