package address

import org.springframework.cloud.contract.spec.Contract

Contract.make {
    description "generate a random address when optional country query parameter is not provided" +
            "generates specific region related address when country parameter is passed below are the supported countries" +
            "USA, CAN, MEX, NLD. would support more in future."

    request {
        url("/randomizer/address")
                { queryParameters { parameter 'country': $(c(optional(regex('[a-zA-Z-\\s]+{3}'))), p("USA")) } }
        method GET()

    }

    response {
        status OK()
        body(
                house: $(p(regex('[0-9]{1,5}')), c('532')),
                street: $(p(regex('[a-zA-Z-\\s]+')), c('Union Street')),
                postalCode: $(p(regex('[A-Z0-9]{5,6}')), c('60090')),
                city: $(p(regex('[a-zA-Z-\\s]+')), c('San Diego')),
                county: $(p(regex('[a-zA-Z-\\s]+')), c('San Diego')),
                state: $(p(optional(regex('[a-zA-Z-\\s]+'))), c('California')),
                stateCode: $(p(optional(regex('[a-zA-Z-\\s]+{2}'))), c('CA')),
                country: $(p(optional(regex('[a-zA-Z-\\s]+'))), c('United States Of America')),
                countryCode: $(p(regex('[a-zA-Z-\\s]+{3}')), c(fromRequest().query('country')))
        )
    }
}