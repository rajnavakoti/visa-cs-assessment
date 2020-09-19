package api.yaddress.v2.response

import io.qameta.allure.Step
import io.restassured.response.ValidatableResponse

class GetAddressResponse extends Response {
    GetAddressResponse(ValidatableResponse validatableResponse){
        super(validatableResponse) }

    @Step("Verify Get Address Response Schema")
    def validateGetAddressResponseSchema(){
        def pathToResponseSchema = "src/main/resources/schemas/v2/getAddress.json" as File
        this.verifySchema(pathToResponseSchema)
        this }
}
