pipeline {
  agent {
    node {
      label 'maven'
    }

  }
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
    stage('Promote To QA') {
      steps {
        sh 'oc tag amsidh-project/springbootfabricopenshitdemo:latest amsidh-project/springbootfabricopenshitdemo:promoteToQA'
      }
    }
  }
}