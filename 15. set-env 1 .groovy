pipeline {
    agent any

    environment {
        FOO = "bar"
    }

    stages {
        stage("Env Variables") {
            
            steps {
                echo "FOO = ${env.FOO}"
                }
            
        }
    }
}
