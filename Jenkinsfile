pipeline {
  agent none
  stages {
    stage('Build and Test') {
      agent {
        docker {
          image 'maven:3.8.1-adoptopenjdk-11'
        }

      }
      post {
        always {
          junit 'target/surefire-reports/*.xml'
        }

      }
      steps {
        sh 'mvn -DskipTests -Pprod clean package'
        sh 'mvn -Pprod test'
        stash(includes: 'target/*.jar', name: 'jar')
        archiveArtifacts 'target/*.jar'
      }
    }

    stage('Deploy to Docker') {
      agent any
      steps {
        unstash 'jar'
        sh 'docker build -f Dockerfile-mysql -t stock/mysql .'
        sh 'docker build -f Dockerfile-app -t stock/app .'
        sh 'docker run --name mysql -d -p 3306:3306 stock/mysql'
        sh 'docker run --name app --link mysql:mysql -p 9000:9000 stock/app'
      }
    }

  }
}