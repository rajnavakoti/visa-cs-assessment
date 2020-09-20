package utils.generators

import com.github.javafaker.Faker

/***
 * function calls to generate random data
 */
class RandomDataGenerator {
    static Faker faker

    static def generateRandomAddress(){
        return faker.address().streetAddress() }

    static def generateRandomState(){
        return faker.address().stateAbbr() }

    static def generateRandomStreet(){
        return faker.address().streetAddress() }

    static def generateRandomCountry(){
        return faker.address().country() }

    static def generateRandomCity(){
        return faker.address().city() }

    static def generateRandomZipcode(){
        return faker.address().zipCode() }
}
