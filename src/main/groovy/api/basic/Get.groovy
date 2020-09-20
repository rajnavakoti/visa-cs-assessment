package api.basic

import io.restassured.response.ValidatableResponse
import static io.restassured.RestAssured.given

class Get {
    /***
     * Make API GET request without query params
     * @param url
     * @param headers
     * @return API response
     */
    static ValidatableResponse makeRequest(String url, Map headers){
        return given()
                .headers(headers)
                .when()
                .get(url)
                .then() }

    /***
     * Make API GET request with query params
     * @param url
     * @param headers
     * @param queryParams
     * @return API response
     */
    static ValidatableResponse makeRequestWithQueryParams(String url, Map headers, Map queryParams){
        return given()
                .headers(headers)
                .queryParams(queryParams)
                .when()
                .get(url)
                .then() }
}
