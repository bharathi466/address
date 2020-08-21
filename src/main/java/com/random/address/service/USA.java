package com.random.address.service;

import com.github.javafaker.Faker;
import com.random.address.model.Address;
import com.random.address.model.Countries;
import com.random.address.util.RandomBoolean;
import lombok.extern.log4j.Log4j2;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Locale;

@Service
@Log4j2
public class USA implements Country {

    @Autowired
    RandomBoolean randomBoolean;

    @Override
    public Address constructAddress() {
        log.debug(() -> "construct usa address");
        com.github.javafaker.Address address = new Faker(new Locale("en-US")).address();
        String stateAbbr = address.stateAbbr();
        String zipCode = address.zipCodeByState(stateAbbr);
        return Address.builder()
                .house(address.buildingNumber())
                .street(address.streetName() + " , " + address.secondaryAddress())
                .postalCode(zipCode)
                .city(address.city())
                .county(address.countyByZipCode(zipCode))
                .stateCode(randomBoolean.getNextBoolean() ? stateAbbr : null)
                .state(randomBoolean.getNextBoolean() ? getState(stateAbbr) : null)
                .country(Countries.USA.countryName)
                .countryCode(getCountry())
                .build();
    }


    @Override
    public String getCountry() {
        return Countries.USA.countryCode;
    }
}
