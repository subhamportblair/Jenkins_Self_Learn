# Jenkins_Self_Learn


pipeline{
    agent any
    
    stages{
        stage('check docker'){
            steps{
                sh 'docker --version'
            }
        }
        stage('Checkout'){
            steps{
                echo 'Getting the code........'
                git branch: 'main',
                   credentialsId: 'github-creds',
                   url: 'https://github.com/subhamportblair/Jenkins_Self_Learn.git'
            }
        }
        stage ('List File'){
            steps{
                echo 'Here are the files Jenkins pulled:'
                sh 'ls -la'
            }
        }
        
        stage ('Build'){
            steps{
                echo 'Build the application......'
                sh 'mvn clean package'
            }
        }
        stage ('Test'){
            steps{
                echo 'Testing the appication......'
                sh 'mvn test'
            }
            post{
                always{
                    // publishes test results in Jenkins UI
                    junit '**/target/surefire-reports/*.xml'
                }
            }
        }
        stage ('Verify JAR'){
            steps{
                sh 'cd target && ls -la'
            }
        }
        stage ('Deploy'){
            steps{
                echo 'Deploying the application......'
                echo 'Imagine the application is getting deployed to a server'
            }
        }
    }
    post{
        success{
            echo '✅Pipeline completed sucessfully'
        }
        failure{
            echo '❌Something went wrong'
        }
    }
}
