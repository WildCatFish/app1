pipeline {
    agent { docker 'maven:3.8.2' }

    stages {
        stage ('Compile Stage') {

            steps {
                   sh 'mvn clean compile'
            }
        }

        stage ('Testing Stage') {

            steps {
                   sh 'mvn test'
            }
        }


        stage ('Deployment Stage') {
            steps {
                   sh 'docker build -f Dockerfile-mysql -t notweibo/mysql .'
                   sh 'docker build -f Dockerfile-app -t notweibo/app .'
                   sh 'docker run --name mysql -d -p 3306:3306 stock/mysql'
                   sh 'docker run --name app --link mysql:mysql -p 9000:9000 stock/app'
            }
        }
    }
}