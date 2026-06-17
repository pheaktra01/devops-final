pipeline {
    agent any

    triggers {
        pollSCM('H/5 * * * *') // every 5 minutes
    }

    environment {
        APP_DIR = "."
        PLAYBOOK = "ansible/deploy.yml"
    }

    stages {

        stage('Test Maven') {
            steps {
                bat 'mvn -v'
            }
        }

        stage('Checkout') {
            steps {
                git branch: 'main',
                    url: 'https://github.com/pheaktra01/devops-final.git'
            }
        }

        stage('Build') {
            steps {
                bat 'mvn clean package -DskipTests'
            }
        }

        stage('Test') {
            steps {
                bat 'mvn test'
            }
        }

        stage('Deploy with Ansible') {
            steps {
                bat "ansible-playbook -i ansible/inventory.ini ${PLAYBOOK}"
            }
        }
    }

    post {
        success {
            echo 'Build successful'
        }

        failure {
            emailext (
                to: "srengty@gmail.com, tranet513@gmail.com",
                subject: "❌ Jenkins Build Failed - ${env.JOB_NAME}",
                body: """
    Build failed in Jenkins.

    Job: ${env.JOB_NAME}
    Build Number: ${env.BUILD_NUMBER}

    Check attached console log.
    """,
                attachLog: true,
                compressLog: true
            )
        }
    }
}