package com.random.address.service;

import com.random.address.model.Address;
import com.random.address.util.StatesAndCodes;

/**
 * @author Bharathi Chandra Nekkalapudi
 */
public interface Country {

    /**
     * @return Address object of a respective country implemented.
     */
    Address constructAddress();

    /**
     * @return countryCode ISO 3 alpha code of implemented country.
     */
    String getCountry();

    default String getState(String stateAbbr) {
        return StatesAndCodes.stateCodeVsName.get(stateAbbr);
    }
}
