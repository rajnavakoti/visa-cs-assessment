package utils.dataProviders

import org.testng.annotations.DataProvider

/***
 * Data generator class for address
 */
class AddressDataProvider {
    @DataProvider(name="validAddress")
    static Object[][] validAddress(){
        def array = [["30 Memorial Drive","Avon MA 2322"],
                     ["250 Hartford Avenue","Bellingham MA 2019"],
                     ["250 Hartford Avenue","Bellingham MA"],
                     ["250 Hartford Avenue","Bellingham 2019"],
                     ["250 Hartford Avenue","MA 2019"],
                     ["250 Hartford Avenue","2019"],
                     ["250 Hartford","MA 2019"],
                     ["","Catskill NY 12414"]]
        return array }

    @DataProvider(name="inValidAddress")
    static Object[][] inValidAddress(){
        def array = [["11 Jungle Road","CA","2"],
                     ["250 hart Avenue","Bellingham MA 2019","3"],
                     ["555 East Main St","Northhampt MA 1060","4"],
                     ["703444 Pleasant Valley Street","Methuen MA 1844","8"],
                     ["333 Main Street","","2"],
                     ["","","2"]]
        return array }

    @DataProvider(name="singleValidAddress")
    static Object[][] singleValidAddress(){
        def array = [["161 Centereach Mall","Centereach NY 11720"]]
        return array }
}
