package com.random.address.model;

/**
 * enum holds country code and country name
 *
 * used in getCountry of each country implementations to return corresponding country code.
 * @author Bharathi Chandra Nekkalapudi
 */
public enum Countries {
    USA("USA", "United States of America"),
    CAN("CAN", "Canada"),
    MEX("MEX", "Mexico"),
    NLD("NLD", "Netherlands");

    public final String countryCode;
    public final String countryName;

    Countries(String countryCode, String countryName) {
        this.countryCode = countryCode;
        this.countryName = countryName;
    }

    @Override
    public String toString() {
        return this.countryName;
    }
}
