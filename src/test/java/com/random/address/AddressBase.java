package com.random.address;

import com.random.address.controller.AddressGeneratorController;
import com.random.address.handler.GlobalExceptionHandler;
import com.random.address.model.Address;
import com.random.address.service.CountriesFactory;
import com.random.address.service.Country;
import io.restassured.module.mockmvc.RestAssuredMockMvc;
import org.junit.Before;
import org.junit.Ignore;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.test.web.servlet.setup.StandaloneMockMvcBuilder;

import java.util.Arrays;
import java.util.Optional;

import static org.mockito.Mockito.when;

@RunWith(SpringRunner.class)
@Ignore
public class AddressBase {
    @InjectMocks
    private AddressGeneratorController addressGeneratorController;

    @Mock
    private CountriesFactory countriesFactory;

    @Mock
    private Country country;

    @Before
    public void setUp() {
        StandaloneMockMvcBuilder standaloneMockMvcBuilder = MockMvcBuilders
                .standaloneSetup(addressGeneratorController)
                .setControllerAdvice(GlobalExceptionHandler.class);
        RestAssuredMockMvc.standaloneSetup(standaloneMockMvcBuilder);

        when(countriesFactory.findCountry(Mockito.any()))
                .thenAnswer(invocation -> {
                    String query = invocation.getArgument(0);
                    return Arrays.asList("USA", "CAN", "MEX", "NLD").contains(query) ?
                            Optional.of(country) : Optional.empty();

                });
        when(country.constructAddress()).thenReturn(Address.builder()
                .house("598")
                .street("CoreyLane")
                .postalCode("60090")
                .city("Wheeling")
                .county("cook")
                .state("Utah")
                .stateCode("UT")
                .country("United States Of America")
                .countryCode("USA")
                .build());
    }

}
