pipeline {
    agent any

//         parameters {
//             password(name: 'PASSWORD', description: 'Encryption key')
//         }

    stages {
        stage("build"){
            steps{
                sh(script: "mvn -version")
                sh(script: "mvn compile")
            }
        }
        stage("run"){
            steps{
                sh(script: 'export USERNAME=automation23')
                sh(script: 'export PASSWORD=$PASSWORD')
                sh(script: 'export BASE_URL=$baseurl')
                sh(script: 'mvn test')
            }
//             post {
//                 always{
//                      junit '*/target/surefire-reports/TEST-.xml'
//                 }
//             }
        }
    }
}