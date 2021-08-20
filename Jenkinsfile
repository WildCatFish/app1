pipeline {
    agent { docker 'maven:3.8.2' }
    stages {
        stage('build') {
            steps {
                sh 'mvn --version'
            }
        }
    }
}