check out and compiling  three git repositories into three sub directories in my Jenkins job. 
IF u want to checkout with creating sub directories remove  this part  sh 'mkdir -p Module1' dir("Module1")



pipeline {
    agent any
    stages 
    {
    stage('scm-1 compile') 
    {
        steps 
        {
            git branch: "master",
            url: 'https://github.com/url'
            sh 'mvn compile'
        }
    }

    stage('scm-2 compile') 
    {
        steps 
        {
            git branch: "master",
            url: 'https://bitbucket.com/url'
            sh 'mvn compile'
        }
    }
}

pipeline {
    agent any
    stages 
    {
    stage('scm-1 compile') 
    {
        steps {
            sh 'mkdir -p Module1'
            dir("Module1")
            {
                git branch: "master",
                url: 'https://github.com/url'
                sh 'mvn compile'
            }
        }
    }

    stage('scm-2 compile') 
    {
        steps {
            sh 'mkdir -p Module2'
            dir("Module2")
            {
                git branch: "master",
                url: 'https://bitbucket.com/url'
                sh 'mvn compile'

            }
        }
    }
}

