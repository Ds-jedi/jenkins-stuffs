pipeline {
    agent any
    stages 
    {
        stage('Source')
        {
            steps 
            {
                git 'https://github.com/Ds-jedi/game-of-life'
            }
        }     
        stage('testing')
        {
            steps 
            {
                sh 'mvn test'
            }
        }
        stage('Package')
        {
            steps 
            {
                sh 'mvn package'
            }
        }

        stage('upload artifacts to s3')
        {
            steps 
            {
                sh 'python3 uploadtos3.py'
            }
        }
        
        stage('build docker image')
        {
            steps 
            {
                 sh 'cd ${WORKSPACE_PATH}'
                 sh ' docker build -t myimage:${BUILD_NUMBER} . '
            }
        }
        stage('deploy to ecs')
        {
            steps 
            {
                 sh ' ./ECS-deployment.sh '

            }
        }












    }
}

