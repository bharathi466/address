package com.random.address.service;

import com.github.javafaker.Faker;
import com.random.address.model.Address;
import com.random.address.model.Countries;
import lombok.extern.log4j.Log4j2;
import org.springframework.stereotype.Service;

import java.util.Locale;
import java.util.concurrent.ThreadLocalRandom;

@Service
@Log4j2
public class Canada implements Country {
    /**
     * @return Address object with city and county as same since canada address dosen't have county.
     * state and sate codes are optional and will be null randomly.
     */
    @Override
    public Address constructAddress() {
        log.debug(() -> "construct Canada address");
        com.github.javafaker.Address address = new Faker(new Locale("en-CA")).address();
        String city = address.city();
        String stateAbbr = address.stateAbbr();
        return Address.builder()
                .house(address.buildingNumber())
                .street(address.streetName() + " , " + address.secondaryAddress())
                .postalCode(address.zipCode())
                .city(city)
                .county(city)
                .stateCode(ThreadLocalRandom.current().nextBoolean() ? stateAbbr : null)
                .state(ThreadLocalRandom.current().nextBoolean() ? getState(stateAbbr) : null)
                .country(Countries.CAN.countryName)
                .countryCode(getCountry())
                .build();
    }

    @Override
    public String getCountry() {
        return Countries.CAN.countryCode;
    }
}