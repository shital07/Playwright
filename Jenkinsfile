pipeline {
    agent { dockerfile true }
    environment {
        ENV_VAR = "test"
    }
    parameters {
        choice(name: 'TYPE', choices: ['Regression', 'Sanity'], description: 'Pick type of testing')
    }
    stages {
        stage('Dev Checkout') {
            steps {
                git credentialsId: 'GitID',
                    url: 'https://github.com/shital07/Playwright',
                    branch: 'main'
                echo 'Git checkout is successful'
                echo "Build ID: ${env.BUILD_ID}"
                echo "Environment Variable: ${env.ENV_VAR}"
            }
        }
        stage('Checkout git') {
            steps {
                // checkout the source code from Git using credentials
                git credentialsId: 'GitID',
                    url: 'https://github.com/shital07/Playwright',
                    branch: 'main'
                echo 'Git checkout is successful'
                echo 'Testing Weebhook'
            }
        }
        stage('Run testCase') {
            when {
                expression {
                    return params.TYPE == 'Regression'
                }
            }
            steps {
                echo 'Starting Execution'
                sh "mvn clean install"
            }
        }
        stage('Publish the html report') {
            steps {
                publishHTML([allowMissing: false,
                             alwaysLinkToLastBuild: false,
                             keepAll: false,
                             reportDir: 'extent-reports',
                             reportFiles: 'index.html',
                             reportName: 'Automation Report',
                             reportTitles: '',
                             useWrapperFileDirectly: false])

                archiveArtifacts '**/*.html'
            }
        }
    }
    /*
    post {
        always {
            mail to: 'shital0711@gmail.com',
                subject: 'The Pipeline run :(',
                body: "The pipeline has finished running."
        }
        success {
            mail to: 'shital0711@gmail.com',
                subject: 'The pipeline ran successfully',
                body: "The pipeline has completed successfully."
        }
    }
    */
}
