// after stage 1 runs , stage 2 and stage 3 will run parallely
//

pipeline {
    agent any

    stages{
        
        stage('my stage 1'){
            steps {
                sh 'mvn clean package'
            }
        }
           


        stage ('my parallel build stage 2 and stage 3'){

            parallel{

                stage ('hellllooooo stage 2'){
                    steps {
                        sh "echo hello "
                    }
                }

                stage ( 'hiiii stage 3 '){
                    steps {
                        sh "echo hi "
                    }
                }
            }
        }
    }
}
/////////////////////////////////////////////////////////////////

or use this syntax tomcat_prod

stage('Tests') {
    parallel(
        'Unit Tests': {
            container('node') {
                sh("npm test --cat=unit")
            }
        },
        'API Tests': {
            container('node') {
                sh("npm test --cat=acceptance")
            }
        }
    )
}