package yaddress.api

import api.yaddress.v2.request.GetAddressRequest
import api.yaddress.v2.response.GetAddressResponse
import io.qameta.allure.Story
import io.restassured.response.ValidatableResponse
import org.testng.annotations.Test
import utils.Groups
import utils.dataProviders.AddressDataProvider

/***
 * This test class file covers: test cases for address /GET endpoint of the API. 'Groups' in the method argument specifies the level of test (sanity, regression, ...)
 */
class GetAddressTest {
    ValidatableResponse response
    GetAddressRequest getAddressRequest = new GetAddressRequest()
    GetAddressResponse getAddressResponse = new GetAddressResponse()

    @Story("Validate Get Address Response Schema")
    @Test(dataProvider = "singleValidAddress", dataProviderClass = AddressDataProvider,groups = [Groups.sanity])
    void getAddressSchemaValidation(String validAddress1,String validAddress2){
        HashMap queryParams = [:]
        queryParams.put("AddressLine1",validAddress1)
        queryParams.put("AddressLine2",validAddress2)
        getAddressRequest.getAddressByBothAddressLines(queryParams)
                .validateGetAddressResponseSchema()
                .assertStatusCode(200) }

    @Story("Test with multiple valid addresses and verify error code and messages")
    @Test(dataProvider = "validAddress", dataProviderClass = AddressDataProvider,groups = [Groups.sanity,Groups.regression])
    void getAddressWithValidAddresses(String validAddress1,String validAddress2){
        HashMap queryParams = [:]
        queryParams.put("AddressLine1",validAddress1)
        queryParams.put("AddressLine2",validAddress2)
        response = getAddressRequest.getAddressByValidAddresses(queryParams)
        getAddressResponse.assertErrorCode(response,"0")
        getAddressResponse.assertErrorMessage(response,"") }

    @Story("Test with multiple invalid addresses and verify error codes")
    @Test(dataProvider = "inValidAddress", dataProviderClass = AddressDataProvider,groups = [Groups.sanity,Groups.regression])
    void getAddressWithInValidAddresses(String validAddress1,String validAddress2, String errorCode){
        HashMap queryParams = [:]
        queryParams.put("AddressLine1",validAddress1)
        queryParams.put("AddressLine2",validAddress2)
        response = getAddressRequest.getAddressByValidAddresses(queryParams)
        getAddressResponse.assertErrorCode(response,errorCode) }
}
