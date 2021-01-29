pipeline {
  agent {
    dockerfile {
      filename 'dockerfile'
    }

  }
  stages {
    stage('Promote To QA') {
      steps {
        sh 'oc tag amsidh-project/springbootfabricopenshitdemo:latest amsidh-project/springbootfabricopenshitdemo:promoteToQA'
      }
    }
  }
}