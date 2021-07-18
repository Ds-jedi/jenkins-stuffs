needed when u need to pass some input while building the job

pipeline {
    agent any
    triggers 
    {
        upstream(upstreamProjects: 'dummy', threshold:hudson.model.Result.SUCCESS)
    }
    parameters 
    {
        string(name: 'BRANCH_FOR_BUILD', defaultValue: 'master', description: 'Enterthe branch to be built')
    }

    stages 
    {
        stage('Source')
        {
            steps 
            {
                git url: 'https://github.com/Ds-jedi/game-of-life' , 
                branch:"${params.BRANCH_FOR_BUILD}"
            }
        }
        stage('Package')
        {
            steps 
            {
                sh 'mvn package'
            }
        }
    }
}