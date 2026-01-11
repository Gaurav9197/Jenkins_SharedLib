def call() {
    withCredentials([string(credentialsId: 'NVD_API_KEY', variable: 'NVD_API_KEY')]) {
        dependencyCheck(
            odcInstallation: 'OWASP',
            additionalArguments: "--scan ./ --nvdApiKey=${NVD_API_KEY} --data /var/jenkins_home/dependency-check-data"
        )
    }

    dependencyCheckPublisher pattern: '**/dependency-check-report.xml'
}
