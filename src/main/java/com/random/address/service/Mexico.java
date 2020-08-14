package com.random.address.service;

import com.github.javafaker.Faker;
import com.random.address.model.Address;
import com.random.address.model.Countries;
import com.random.address.util.StatesAndCodes;
import lombok.extern.log4j.Log4j2;
import org.springframework.stereotype.Service;

import java.util.Locale;
import java.util.concurrent.ThreadLocalRandom;

@Service
@Log4j2
public class Mexico implements Country {
    @Override
    public Address constructAddress() {
        log.debug(() -> "construct Mexico address");
        com.github.javafaker.Address address = new Faker(new Locale("es-MX")).address();
        String stateAbbr = address.stateAbbr();
        String city = address.city();
        return Address.builder()
                .house(address.buildingNumber())
                .street(address.streetName() + " , " + address.secondaryAddress())
                .postalCode(address.zipCode())
                .city(city)
                .county(city)
                .stateCode(ThreadLocalRandom.current().nextBoolean() ? stateAbbr : null)
                .state(ThreadLocalRandom.current().nextBoolean() ? getState(stateAbbr) : null)
                .country(Countries.MEX.countryName)
                .countryCode(getCountry())
                .build();
    }

    @Override
    public String getCountry() {
        return Countries.MEX.countryCode;
    }
}