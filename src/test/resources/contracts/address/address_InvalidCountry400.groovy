package address

import org.springframework.cloud.contract.spec.Contract

Contract.make {
    description "invalid country selected gives 400 status. supports USA, CAN, MEX, NLD"

    request {
        url("/randomizer/address")
                { queryParameters { parameter 'country': $(c(optional(regex('[a-zA-Z-\\s]+{3}'))), p("IND")) } }
        method GET()
    }

    response {
        status BAD_REQUEST()
        body(
                errorCode: "400",
                errorMessage: "Invalid input country :: IND"
        )
    }
}