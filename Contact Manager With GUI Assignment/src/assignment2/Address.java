/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package assignment2;

/**
 *
 * @author Truong Thi Bui - 101300750
 */
public class Address {

    public String streetInfo1;
    public String streetInfo2;
    public String city;
    public String postalCode;
    public String province;
    public String country;

    public Address(String streetInfo1, String streetInfo2, String city, String postalCode, String province, String country) {
        this.streetInfo1 = streetInfo1;
        this.streetInfo2 = streetInfo2;
        this.city = city;
        this.postalCode = postalCode;
        this.province = province;
        this.country = country;
    }

    @Override
    public String toString() {
        return "Street Info 1: " + streetInfo1
                + "  |  Street Info 2: " + streetInfo2
                + "  |  City: " + city
                + "  |  Postal Code: " + postalCode
                + "  |  Province: " + province
                + "  |  Country: " + country;
    }
}
