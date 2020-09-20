package api.yaddress.v2

import utils.configuration.Config

/***
 * YAddress API Endpoints
 */
class YAddressEndPoints {
    static String Y_ADDRESS_API_URL = Config.getYAddressAPIURL()

    public static final String EP_ADDRESS = Y_ADDRESS_API_URL + "/address"
}
