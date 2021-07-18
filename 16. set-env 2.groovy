pipeline {
    agent any

    stages {
        stage("Env Variables") {
            environment {
                NAME = "Alan"
            }

            steps {
                echo "NAME = ${env.NAME}"
            }
        }
    }
}