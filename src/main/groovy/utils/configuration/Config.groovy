package utils.configuration

import static utils.configuration.PropertiesReader.getKey

class Config {
    static boolean isLocal() {
        return getKey("executionEnvironment") == 'local' }

    static boolean isProd() {
        return getKey("environment") == 'prod' }

    static boolean isJenkins() {
        return getKey("executionEnvironment") == 'jenkins' }

    static getEnvironment() {
        return getKey("environment") }

    static getYAddressAPIURL(){
        return getKey("yAddressApiUrl",getEnvironment()) }

    static getAPIContentType(){
        return getKey("contentType",getEnvironment()) }
}
