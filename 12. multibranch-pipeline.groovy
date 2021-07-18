Multibranch pipeline
======================================================

pipeline 
{
    agent any
    stages 
    {
        stage('build 1st branch') 
        {
            steps 
            {
                git branch: 'feature-1' ,
                url: 'https://github.com/Ds-jedi/game-of-life'
                sh 'mvn package'
            }
       }
    }
    stage('build 1st branch') 
    {
        steps 
        {
            git branch: 'feature-2' ,
            url: 'https://github.com/Ds-jedi/game-of-life'
            sh 'mvn package'
        }
       }
    }
}