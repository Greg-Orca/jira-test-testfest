pipeline {
    agent any

    stages {
        stage("build"){
            steps{
                sh(script: "export USERNAME=automation23")
                sh(script: "export PASSWORD=$PASSWORD")
                sh(script: "export BASE_URL=$baseurl")
                sh(script: "mvn -version")
                sh(script: "mvn compile")
            }
        }
        stage("run tests"){
            steps{
                sh(script: 'mvn test ')
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