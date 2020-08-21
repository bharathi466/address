package com.random.address.service;

import com.random.address.model.Address;
import com.random.address.util.RandomBoolean;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.springframework.boot.test.context.SpringBootTest;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.*;


@SpringBootTest
class NetherlandsTest {

    @InjectMocks
    Netherlands netherlands;

    @Mock
    RandomBoolean randomBoolean;

    @Test
    void getCountry() {
        assertThat("getCountry on Netherlands should return NLD",netherlands.getCountry(), equalTo("NLD"));
    }

    @Test
    void constructAddressWithNOState() {

        Mockito.when(randomBoolean.getNextBoolean()).thenReturn(false);
        Address address = netherlands.constructAddress();
        assertThat("House or Street number is mandatory can be alpha numeric and have spaces",address.getHouse(), matchesPattern("[0-9a-zA-Z-\\s]+"));
        assertThat("Street Name should is mandatory can contain street Numbers",address.getStreet(), notNullValue());
        assertThat("Postal Code for Netherlands is alpha numeric and can have space ",address.getPostalCode(), matchesPattern("[1-9][0-9]{3} [A-Z]{2}"));
        assertThat("city name is mandatory",address.getCity(), notNullValue());
        assertThat("County should be same as city for Netherlands", address.getCounty(), equalTo(address.getCity()));
        assertThat("stateCode is optional will be always null for Netherlands",address.getStateCode(), emptyOrNullString());
        assertThat("state is optional can be null depending on nextBoolean",address.getState(), emptyOrNullString());
        assertThat("countryName is mandatory field",address.getCountry(), equalTo("Netherlands"));
        assertThat("country code should be of length 3",address.getCountryCode(), hasLength(3));
        assertThat("country code should be NLD for Netherlands",address.getCountryCode(), equalTo("NLD"));
    }



    @Test
    void constructAddressWithState() {
        Mockito.when(randomBoolean.getNextBoolean()).thenReturn(true);
        Address address = netherlands.constructAddress();
        assertThat("state should be non null value",address.getState(), notNullValue());
    }

}