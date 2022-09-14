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
                sh(script: 'mvn test -DUSERNAME=automation23 -DPASSWORD=$PASSWORD -DBASE_URL=$baseurl')
            }
        }
    }
    post {
        always{
            junit '**/target/surefire-reports/TEST-*.xml'
//             junit allowEmptyResults: true, testResults: '**/test-results/*.xml'
        }
    }
}