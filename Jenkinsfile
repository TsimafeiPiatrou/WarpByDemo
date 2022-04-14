pipeline {
    environment {
        driver_path = "src/test/resources/chromedriver.exe"
        valid_login = "timap446@vk.com"
        valid_password = "yVQs6DCXed2W9XV"
    }

    agent any

    tools {
        // Install the Maven version configured as "M3" and add it to the path.
        maven "M3"
    }

    stages {
        stage('Environment') {
                    steps {
                        sh 'echo "driver_path is $driver_path"'
                        sh 'echo "valid_login is $valid_login"'
                        sh 'echo "valid_password is $valid_password"'
                    }
        }

        stage('Testing') {
            steps {
                // Get some code from a GitHub repository
                git 'https://github.com/TsimafeiPiatrou/WarpByDemo.git'

                // To run Maven on a Windows agent, use
                 bat "mvn clean test -Dmaven.test.failure.ignore=true -Dmaven.compiler.source=11 -Dmaven.compiler.target=11"
            }

            post {
                // If Maven was able to run the tests, even if some of the test
                // failed, record the test results and archive the jar file.
                success {
                    junit '**/target/surefire-reports/TEST-*.xml'
                }
            }
        }
        stage('Reporting') {
            steps {
                script {
                     allure([
                             includeProperties: false,
                             jdk: '',
                             properties: [],
                             reportBuildPolicy: 'ALWAYS',
                             results: [[path: 'target/allure-results']]
                     ])
             }
         }
        }
    }
}
