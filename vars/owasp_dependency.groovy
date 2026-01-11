def call() {

    withCredentials([
        usernamePassword(
            credentialsId: 'NVD_API_KEY',
            usernameVariable: 'NVD_USER',
            passwordVariable: 'NVD_API_KEY'
        )
    ]) {

        dependencyCheck(
            odcInstallation: 'OWASP',
            additionalArguments: "--scan ./ --nvdApiKey=${NVD_API_KEY}"
        )
    }

    dependencyCheckPublisher pattern: '**/dependency-check-report.xml'
}
