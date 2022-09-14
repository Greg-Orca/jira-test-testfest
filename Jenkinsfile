pipeline {
    agent any

    stages {
        stage("build"){
            steps{
                sh(script: "jenkins-plugin-cli --plugins test-results-analyzer:0.3.5")
                sh(script "install gradle 7.5.1")
                sh(script: "mvn -version")
                sh(script: "mvn compile")
            }
        }
        stage("run tests"){
            steps{
                sh './gradlew check'
                sh(script: 'mvn test -DUSERNAME=automation23 -DPASSWORD=$PASSWORD -DBASE_URL=$baseurl')
            }
        }
    }
    post {
        always{
            junit 'build/reports/**/*.xml'
        }
    }
}