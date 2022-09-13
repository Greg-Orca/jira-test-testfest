pipeline {
    agent any

    properties([
        parameters([
            password(name: 'PASSWORD', description: 'Encryption key')
        ])
    ])

    stages {
        stage("build"){
            sh(script: "mvn -version")
            sh(script: "mvn compile")
        }
        stage("run"){
            sh(script: "mvn test -DUSERNAME=automation23 -DPASSWORD=$PASSWORD -DBASE_URL='https://jira-auto.codecool.metastage.net'")
        }
    }
}