package com.random.address.service;

import com.random.address.model.Address;
import com.random.address.util.RandomBoolean;
import com.random.address.util.StatesAndCodes;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.springframework.boot.test.context.SpringBootTest;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.*;
@SpringBootTest
class USATest {
    @InjectMocks
    USA usa;

    @Mock
    RandomBoolean randomBoolean;

    @Test
    void getCountry() {
        assertThat("getCountry on USA should return USA",usa.getCountry(), equalTo("USA"));
    }

    @Test
    void constructAddressWithNOStateAndStateCode() {

        Mockito.when(randomBoolean.getNextBoolean()).thenReturn(false,false);
        Address address = usa.constructAddress();
        assertThat("House or Street number is mandatory can be alpha numeric and have spaces",address.getHouse(), matchesPattern("[0-9a-zA-Z-\\s]+"));
        assertThat("Street Name should is mandatory can contain street Numbers",address.getStreet(), notNullValue());
        assertThat("Postal Code for usa should be 5 digits",address.getPostalCode(), matchesPattern("[0-9]{5}"));
        assertThat("city name is mandatory",address.getCity(), notNullValue());
        assertThat("county is mandatory", address.getCounty(), notNullValue());
        assertThat("stateCode is optional will be always null for usa",address.getStateCode(), emptyOrNullString());
        assertThat("state is optional can be null depending on nextBoolean",address.getState(), emptyOrNullString());
        assertThat("countryName is mandatory field",address.getCountry(), equalTo("United States of America"));
        assertThat("country code should be of length 3",address.getCountryCode(), hasLength(3));
        assertThat("country code should be USA for UnitedStatedOfAmerica",address.getCountryCode(), equalTo("USA"));
    }



    @Test
    void constructAddressWithStateAndStateCode() {
        Mockito.when(randomBoolean.getNextBoolean()).thenReturn(true,true);
        Address address = usa.constructAddress();
        assertThat("stateCode should be of max length 2 , any case alphabets allowed",address.getStateCode(), matchesPattern("[a-zA-Z]{2}"));
        assertThat("state should be corresponding to stateCode",address.getState(), equalTo(StatesAndCodes.stateCodeVsName.get(address.getStateCode())));
    }

    @Test
    void constructAddressWithStateCodeNoState() {
        Mockito.when(randomBoolean.getNextBoolean()).thenReturn(true,false);
        Address address = usa.constructAddress();
        assertThat("stateCode should be of max length 2 , any case alphabets allowed",address.getStateCode(), matchesPattern("[a-zA-Z]{2}"));
        assertThat("state should be non null value",address.getState(), emptyOrNullString());
    }
    @Test
    void constructAddressWithOutStateCodeWithState() {
        Mockito.when(randomBoolean.getNextBoolean()).thenReturn(false,true);
        Address address = usa.constructAddress();
        assertThat("stateCode should be null",address.getStateCode(),emptyOrNullString());
        assertThat("state should be non null value",address.getState(), notNullValue());
    }
}