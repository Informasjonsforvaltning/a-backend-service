package no.brreg.informasjonsforvaltning.abackendservice.utils

import no.brreg.informasjonsforvaltning.abackendservice.generated.model.ServiceEndpoint
import no.brreg.informasjonsforvaltning.abackendservice.generated.model.Version
import no.brreg.informasjonsforvaltning.abackendservice.model.ServiceEndpointDB
import org.bson.types.ObjectId
import java.net.URI
import java.net.URL
import com.fasterxml.jackson.module.kotlin.jacksonObjectMapper

const val API_SERVICE_NAME = "a-backend-service"
const val API_PORT = 8080

const val MONGO_SERVICE_NAME = "mongodb"
const val MONGO_PORT = 27017

const val MONGO_USER = "testuser"
const val MONGO_PASSWORD = "testpassword"

val GENERATED_ID_0 = ObjectId("5d846c475f599c04093216c3")

const val DATABASE_NAME = "a-backend-service"
const val MONGO_COLLECTION = "service-endpoints"
private const val MONGO_AUTH = "?authSource=admin&authMechanism=SCRAM-SHA-1"

const val ADMIN_TOKEN_TMP ="dfghjklasfijkf5fgahfskjl"
const val NON_ADMIN_TOKEN_TMP ="dfghjklasfijkf5fgahfskjl"

const val SERVICE_ENDPOINT = "/serviceendpoints"

fun mongoUri(host: String, port: Int): String =
    "mongodb://$MONGO_USER:$MONGO_PASSWORD@$host:$port/$DATABASE_NAME$MONGO_AUTH"

fun createServiceEndpointDB(testName: String, testUrl: String) =
    ServiceEndpointDB().apply {
        name = testName
        url = URL(testUrl)
    }

fun createServiceEndpoint(testName: String,testUrl: String) =
    ServiceEndpoint().apply {
        name = testName
        url = URI(testUrl)
    }

fun jsonServiceEndpointObject (name: String, addName: Boolean = true, addUri: Boolean = true ): String? {
    val map = mapOf<String,String?>(
            "name" to if(addName) name else null ,
            "uri" to if(addUri) "http://nothing.org/${name}" else null
    )
    return jacksonObjectMapper().writeValueAsString(map)
}

private fun createServiceEndpointWithVersionData(hexStringId: String?) =
    ServiceEndpoint().apply {
        id = hexStringId
        name = "Endpoint name"
        url = URI("http://localhost:$API_PORT/version")
    }

val EMPTY_DB_LIST = emptyList<ServiceEndpointDB>()
val ENDPOINTS_DB_LIST = listOf(createServiceEndpointDB(TestNames.CORRECT,TestUrls.CORRECT))

val EMPTY_ENDPOINTS_LIST = emptyList<ServiceEndpoint>()
val ENDPOINTS_LIST = listOf(createServiceEndpointWithVersionData(GENERATED_ID_0.toHexString()))


val VERSION_DATA = Version().apply{
    repositoryUrl = "repositoryUrl"
    branchName = "branchName"
    buildTime = "buildTime"
    sha = "sha"
    versionId = "versionId"
}

val VERSION_JSON = (
        jacksonObjectMapper().writeValueAsString(VERSION_DATA))
object TestNames{
    val CORRECT = "a-bakcend-service"
    val WITH_WHITE_SPACE= "a backend service"
    val WITH_NUMBER = "a-back3nd-servi3"
}

object TestUrls{
    val CORRECT = "http://localhost:8080/version"
    val NOT_URL = "this is not a url"
    val INVALID_FORMAT = "http:8080/version"
}

