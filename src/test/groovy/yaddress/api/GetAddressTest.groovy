package yaddress.api

import api.basic.Get
import api.yaddress.v2.request.GetAddressRequest
import io.qameta.allure.Story
import org.testng.annotations.Test
import com.github.javafaker.Faker
import utils.dataProviders.AddressDataProvider

class GetAddressTest {
    @Story("")
    @Test()
    void getAddressUsingBothAddressLines(){
        HashMap queryParams = [:]
        queryParams.put("AddressLine1","Test")
        queryParams.put("AddressLine2","Test")
        GetAddressRequest.getAddressByBothAddressLines(queryParams)
                         .validateGetAddressResponseSchema()
                         .assertStatusCode(200)
    }

    @Story("")
    @Test(dataProvider = "validAddress", dataProviderClass = AddressDataProvider)
    void getAddressUsingBothAddressLinesX(String validAddress1,String validAddress2){
        HashMap queryParams = [:]
        queryParams.put("AddressLine1","Test")
        queryParams.put("AddressLine2","Test")
        GetAddressRequest.getAddressByBothAddressLineX(queryParams)
        Faker faker = new Faker()
        println(faker.address().country())
        println(faker.address().stateAbbr())
        println(faker.address().cityPrefix())
        println(faker.address().streetAddress(true))
        println(faker.address().zipCodeByState(faker.address().stateAbbr()))
        println(validAddress1)
    }
}
