package api.yaddress.v2.request

import api.basic.Get
import api.yaddress.v2.YAddressEndPoints
import api.yaddress.v2.response.GetAddressResponse
import io.qameta.allure.Step
import io.restassured.response.ValidatableResponse
import org.testng.Assert
import utils.configuration.Config

/***
 * functional class on GET /Address API request
 */
class GetAddressRequest {
    static Map headers = [:]
    static ValidatableResponse response

    @Step("Get Address by Address Line1 and Address Line 2")
    static def getAddressByBothAddressLines(Map queryParams){
        headers.put("Content-Type", Config.getAPIContentType())
        println("API Endpoint: " + YAddressEndPoints.EP_ADDRESS)
        new GetAddressResponse(Get.makeRequestWithQueryParams(YAddressEndPoints.EP_ADDRESS,headers,queryParams)) }

    @Step("Get Address by Address Line1 and Address Line 2 and return response")
    static def getAddressByValidAddresses(Map queryParams){
        headers.put("Content-Type", Config.getAPIContentType())
        println("API Endpoint: " + YAddressEndPoints.EP_ADDRESS)
        response = Get.makeRequestWithQueryParams(YAddressEndPoints.EP_ADDRESS,headers,queryParams)
        return response }
}
