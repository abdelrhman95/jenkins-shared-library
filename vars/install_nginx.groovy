def call(){
    pipeline {
        agent { label 'slave-node' }

    stages {
        stage('install nginx') {
            steps {
                sh "sudo apt-get update -y"
                sh "sudo apt-get install nginx -y"
            }
        }

        stage("start nginx") {
            steps {
                sh "sudo systemctl start nginx"
            }
        }

        stage("test nginx") {
            steps {
                sh "curl localhost"
            }
        }
    }
}
}
