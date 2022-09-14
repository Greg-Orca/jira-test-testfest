pipeline {
    agent any

    stages {
        stage("build"){
            steps{
                sh(script: './gradlew build')
                sh(script: "mvn -version")
                sh(script: "mvn compile")
            }
        }
        stage("run tests"){
            steps{
                sh(script: './gradlew check')
                sh(script: 'mvn test -DUSERNAME=automation23 -DPASSWORD=$PASSWORD -DBASE_URL=$baseurl')
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