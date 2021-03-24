node('aws1')
{
	stage('scm')
	{
        git 'https://github.com/Ds-jedi/game-of-life' 
	}
	
    stage('build')
	{     
		sh 'mvn package'  
	}
	
    stage('postbuild')
	{
    	junit 'gameoflife-web/target/surefire-reports/*.xml'
    	archiveArtifacts artifacts: 'gameoflife-web/target/*.war', followSymlinks: false
	}
}