pipeline {
  agent any
  stages {
    stage('Maven Build Step') {
      steps {
        sh 'mvn clean package'
      }
    }
    stage('Maven Deploy Step') {
      steps {
        sh 'mvn fabric8:deploy'
      }
    }
    stage('Promote To QA / Shell Script') {
      steps {
        sh 'oc tag amsidh-project/springbootfabricopenshitdemo:latest amsidh-project/springbootfabricopenshitdemo:promoteToQA'
      }
    }
  }
}