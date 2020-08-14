package com.random.address.controller;

import com.random.address.model.Address;
import com.random.address.model.ServiceError;
import com.random.address.service.CountriesFactory;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import lombok.extern.log4j.Log4j2;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;


@RestController
@Log4j2
public class AddressGeneratorController {

    @Autowired
    private CountriesFactory countriesFactory;

    /**
     * @param country optional country query parameter. defaulted to random if country is not selected.
     * @return random address json.
     */
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "Successfully read address for a given country or random"),
            @ApiResponse(code = 400, message = "Invalid input country", response = ServiceError.class),
            @ApiResponse(code = 500, message = "Error while processing the request, Try again.", response = ServiceError.class)
    })

    @GetMapping(path = "/randomizer/address", produces = MediaType.APPLICATION_JSON_VALUE)
    public Address address(@RequestParam(required = false, value = "country" ) String country) {
        log.debug("Inside get Address :: {}", country);
        return countriesFactory
                .findCountry(country)
                .orElseThrow(() -> new IllegalArgumentException("Invalid input country :: " + country))
                .constructAddress();
    }
}
