package com.random.address.service;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.*;
@SpringBootTest
class CountriesFactoryTest {

    @Autowired
    CountriesFactory countriesFactory;

    @Test
    void findCountryForEmptyOrNull() {
        assertThat(countriesFactory.findCountry("").get(), notNullValue(Country.class));
        assertThat(countriesFactory.findCountry(null).get(), notNullValue(Country.class));
    }
    @Test
    void findCountryForImplementedCountries() {
        assertThat(countriesFactory.findCountry("CAN").get(), instanceOf(Canada.class));
        assertThat(countriesFactory.findCountry("USA").get(), instanceOf(USA.class));
        assertThat(countriesFactory.findCountry("NLD").get(), instanceOf(Netherlands.class));
        assertThat(countriesFactory.findCountry("MEX").get(), instanceOf(Mexico.class));
    }

    @Test
    void findCountryForUnImplementedCountryCode() {
        assertThat(countriesFactory.findCountry("IND").isPresent(), equalTo(false));
    }

}