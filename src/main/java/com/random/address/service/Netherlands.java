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
public class Netherlands implements Country {
    @Override
    public Address constructAddress() {
        log.debug(() -> "construct NetherLands address");
        com.github.javafaker.Address address = new Faker(new Locale("nl")).address();
        String city = address.city();
        return Address.builder()
                .house(address.buildingNumber())
                .street(address.streetName() + " , " + address.secondaryAddress())
                .postalCode(address.zipCode())
                .city(city)
                .county(city)
                .state(ThreadLocalRandom.current().nextBoolean() ? address.state() : null)
                .country(Countries.NLD.countryName)
                .countryCode(getCountry())
                .build();
    }

    @Override
    public String getCountry() {
        return Countries.NLD.countryCode;
    }
}