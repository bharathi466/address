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
class MexicoTest {

    @InjectMocks
    Mexico mexico;

    @Mock
    RandomBoolean randomBoolean;

    @Test
    void getCountry() {
        assertThat("getCountry on Mexico should return MEX",mexico.getCountry(), equalTo("MEX"));
    }

    @Test
    void constructAddressWithNOStateAndStateCode() {

        Mockito.when(randomBoolean.getNextBoolean()).thenReturn(false, false);
        Address address = mexico.constructAddress();
        assertThat("House or Street number is mandatory and only numbers are allowed",address.getHouse(), notNullValue());
        assertThat("Street Name should is mandatory can contain street Numbers",address.getStreet(), notNullValue());
        assertThat("Postal Code for Mexico should have 5 digits ",address.getPostalCode(), matchesPattern("[0-9]{5}"));
        assertThat("city name is mandatory",address.getCity(), notNullValue());
        assertThat("County should be same as city for Mexico", address.getCounty(), equalTo(address.getCity()));
        assertThat("stateCode is optional can be null depending on nextBoolean",address.getStateCode(), emptyOrNullString());
        assertThat("state is optional can be null depending on nextBoolean",address.getState(), emptyOrNullString());
        assertThat("countryName is mandatory field",address.getCountry(), equalTo("Mexico"));
        assertThat("country code should be of length 3",address.getCountryCode(), hasLength(3));
        assertThat("country code should be MEX for mexico",address.getCountryCode(), equalTo("MEX"));
    }

    @Test
    void constructAddressWithStateCode() {
        Mockito.when(randomBoolean.getNextBoolean()).thenReturn(true, false);
        Address address = mexico.constructAddress();
        assertThat("stateCode should be of max length 3 , any case alphabets allowed",address.getStateCode(), matchesPattern("[a-zA-Z]{3}"));
        assertThat("state is optional",address.getState(), emptyOrNullString());
    }

    @Test
    void constructAddressWithStateAndStateCode() {
        Mockito.when(randomBoolean.getNextBoolean()).thenReturn(true, true);
        Address address = mexico.constructAddress();
        assertThat("stateCode should be of max length 3 , any case alphabets allowed",address.getStateCode(), matchesPattern("[a-zA-Z]{3}"));
        assertThat("state should be corresponding to stateCode",address.getState(), equalTo(StatesAndCodes.stateCodeVsName.get(address.getStateCode())));
    }

    @Test
    void constructAddressWithoutStateCodeAndState() {
        Mockito.when(randomBoolean.getNextBoolean()).thenReturn(false, true);
        Address address = mexico.constructAddress();
        assertThat("stateCode should null as getNextBoolean is false",address.getStateCode(), emptyOrNullString());
        assertThat("state should be non null value",address.getState(), notNullValue());
    }


}