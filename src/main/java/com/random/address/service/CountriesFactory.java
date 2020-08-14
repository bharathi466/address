package com.random.address.service;

import lombok.extern.log4j.Log4j2;
import org.apache.commons.lang3.StringUtils;
import org.springframework.stereotype.Component;

import java.util.Map;
import java.util.Optional;
import java.util.Set;
import java.util.concurrent.ThreadLocalRandom;
import java.util.stream.Collectors;

/**
 * This class maintains all the service implemented class beans as in a map.
 * Doesn't need any modifications in future even after adding new country support.
 * @author Bharathi Chandra Nekkalapudi
 */
@Component
@Log4j2
public class CountriesFactory {

    /**
     * map with country name as key and the corresponded implementation as value.
     */
    private final Map<String, Country> countryServices;

    /**
     * @param countries set of country service beans. constructor injection.
     */
    public CountriesFactory(Set<Country> countries) {
        log.debug("countries set :: {} " , countries);
        countryServices = mapCountryServices(countries);
    }

    /**
     * @param countryServices all the country service implementation classes
     * @return map with Key as country code and value as corresponding service class implementation bean.
     */
    Map<String, Country> mapCountryServices(Set<Country> countryServices) {
        return countryServices.stream().collect(Collectors.toMap(Country::getCountry, country -> country));
    }

    /**
     * @param country from query parameter. this is an optional parameter.
     * @return corresponding country service bean.
     * pick a random service bean from the countries service map
     * when country is blank.
     */
    public Optional<Country> findCountry(String country) {
        log.debug("countryMap :: {}" , countryServices);
        if (StringUtils.isBlank(country)) {
            int nextInt = ThreadLocalRandom.current().nextInt(countryServices.size());
            return Optional.of(countryServices.get(countryServices.keySet().toArray()[nextInt]));
        }
        return Optional.ofNullable(countryServices.get(country.toUpperCase()));
    }
}
