//environment Variables
executionEnvironment = System.getenv("ENV_EXECUTION") ?: "local"
environment = System.getenv("TEST_ENVIRONMENT") ?: "prod"

environments {
    prod {
        yAddressApiUrl = "http://www.yaddress.net/api"
        userKey = "XXXXXX"
        contentType = "application/json"
    }
}