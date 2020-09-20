package api.yaddress.v2.response

import io.qameta.allure.Step
import io.restassured.module.jsv.JsonSchemaValidator
import io.restassured.response.ValidatableResponse

/***
 * Base class for all API response classes. Class consists of schema & status code validation
 */
class Response {
    ValidatableResponse validatableResponse = null

    Response(ValidatableResponse validatableResponse) {
        this.validatableResponse = validatableResponse }

    @Step("Verify schema of the api response")
    Response verifySchema(File schemaPath) {
        this.validatableResponse
                .body(JsonSchemaValidator.matchesJsonSchema(schemaPath))
        this }

    @Step("Assert status code = {statusCode}")
    def assertStatusCode(def statusCode) {
        this.validatableResponse.assertThat().statusCode(statusCode)
        this }
}
