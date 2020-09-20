package api.yaddress.v2.response

import io.qameta.allure.Step
import io.restassured.response.ValidatableResponse
import org.testng.Assert

/***
 * functional class on GET /Address API response
 */
class GetAddressResponse extends Response {
    GetAddressResponse(ValidatableResponse validatableResponse){
        super(validatableResponse) }

    @Step("Verify Get Address Response Schema")
    def validateGetAddressResponseSchema(){
        def pathToResponseSchema = "src/main/resources/schemas/v2/getAddress.json" as File
        this.verifySchema(pathToResponseSchema)
        this }

    @Step("Assert error code")
    static def assertErrorCode(ValidatableResponse response, String errorCode){
        println("Error Code: " + response.extract().response().path("ErrorCode"))
        Assert.assertTrue(response.extract().response().path("ErrorCode").toString().equalsIgnoreCase(errorCode)) }

    @Step("Assert error message")
    static def assertErrorMessage(ValidatableResponse response, String errorMessage){
        println("Error Message: " + response.extract().response().path("ErrorMessage"))
        Assert.assertTrue(response.extract().response().path("ErrorMessage").toString().equalsIgnoreCase(errorMessage)) }
}
