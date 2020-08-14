package com.random.address.model;

import io.swagger.annotations.ApiModelProperty;
import lombok.Builder;
import lombok.Data;
import lombok.NonNull;

@Builder
@Data
public class Address {
    @ApiModelProperty(required = true, value = "House or street number.")
    @NonNull
    private String house;
    @ApiModelProperty(required = true, value = "Street name (in practice may also contain street number).")
    @NonNull
    private String street;
    @ApiModelProperty(required = true, value = "An alphanumeric string included in a postal address to facilitate\n" +
            "mail sorting (a.k.a. post code, postcode, or ZIP code).")
    @NonNull
    private String postalCode;
    @ApiModelProperty(required = true, value = "The name of the primary locality of the place.")
    @NonNull
    private String city;
    @ApiModelProperty(required = true, value = "A division of a state; typically a secondary-level administrative\n" +
            "division of a country or equivalent.")
    @NonNull
    private String county;
    @ApiModelProperty(value = "A division of a country; typically a first-level administrative division\n" +
            "of a country and/or a geographical region.")
    private String state;
    @ApiModelProperty(value = "A code/abbreviation for the state division of a country.")
    private String stateCode;
    @ApiModelProperty(value = "The localised country name.")
    private String country;
    @ApiModelProperty(required = true, value = "A three-letter country code. (ISO 3166-1 alpha-3 code)")
    @NonNull
    private String countryCode;

}
