package no.brreg.informasjonsforvaltning.abackendservice.mapping

import no.brreg.informasjonsforvaltning.abackendservice.generated.model.ServiceEndpoint
import no.brreg.informasjonsforvaltning.abackendservice.model.ServiceEndpointDB

fun ServiceEndpointDB.mapToGenerated(): ServiceEndpoint {
    val mapped = ServiceEndpoint()

    mapped.name = name
    mapped.url = url.toURI()

    return mapped
}

fun ServiceEndpoint.mapForCreation(): ServiceEndpointDB {
    val mapped = ServiceEndpointDB()

    mapped.name = name
    mapped.url = url.toURL()

    return mapped
}
