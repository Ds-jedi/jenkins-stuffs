You can force your parallel stages to all be aborted when one of them fails, 
by adding failFast true to the stage containing the parallel. 
// here we are failing this build if the word warning is found

// easy way is , u add a script in post build step that will grep 
// the warning , and will terminate the build

pipeline {
    agent any
    environment {
        x = false                    // setting up env variable x as false
    }
    stages {
        stage('Build') {
            failFast true            // failfast will fail the build as soon as warning found
            
            parallel {
                
                stage('Building') {
                    steps {
                        
                        sh "mvn package |  tee output.log"    // consold output saved to output.log

                        sh '! grep "WARNING" output.log'      // ! means if warning is found , this grep process will be killed

                        script {
                            x = true           // if above 2 steps passed , x will be set to true
                        }
                    }
                }
                
                stage('Monitoring the logs') { // this stage will be running paralllely
                    steps {
                        script {
                            while (x != true) {                         // the moment when x becomes false
                                sh '! grep "WARNING" output.log'        // it will fail the whole script
                            }
                        }
                    }
                }
            }
        }
    }
}