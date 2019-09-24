package no.template

import no.template.generated.model.ServiceEndpoint
import no.template.generated.model.Version
import no.template.model.ServiceEndpointDB
import org.bson.types.ObjectId
import java.net.URI

const val API_SERVICE_NAME = "template"
const val API_PORT = 8080

const val MONGO_SERVICE_NAME = "mongodb"
const val MONGO_PORT = 27017

const val MONGO_USER = "testuser"
const val MONGO_PASSWORD = "testpassword"

val GENERATED_ID_0 = ObjectId("5d846c475f599c04093216c3")

const val DATABASE_NAME = "templateAPI"
const val MONGO_COLLECTION = "template"
private const val MONGO_AUTH = "?authSource=admin&authMechanism=SCRAM-SHA-1"

fun mongoUri(host: String, port: Int): String =
    "mongodb://$MONGO_USER:$MONGO_PASSWORD@$host:$port/$DATABASE_NAME$MONGO_AUTH"

fun createServiceEndpointDB(objectId: ObjectId?) =
    ServiceEndpointDB().apply {
        id = objectId
        name = "Endpoint name"
        uri = URI("http://www.endpoint.no/version")
    }

fun createServiceEndpoint(hexStringId: String?) =
    ServiceEndpoint().apply {
        id = hexStringId
        name = "Endpoint name"
        uri = URI("http://www.endpoint.no/version")
    }

private fun createServiceEndpointWithVersionData(hexStringId: String?) =
    ServiceEndpoint().apply {
        id = hexStringId
        name = "Endpoint name"
        uri = URI("http://www.endpoint.no/version")
        version = Version().apply{
            repositoryUrl = "repositoryUrl"
            branchName = "branchName"
            buildTime = "buildTime"
            sha = "sha"
            versionId = "versionId"
        }
    }

val EMPTY_DB_LIST = emptyList<ServiceEndpointDB>()
val ENDPOINTS_DB_LIST = listOf(createServiceEndpointDB(GENERATED_ID_0))

val EMPTY_ENDPOINTS_LIST = emptyList<ServiceEndpoint>()
val ENDPOINTS_LIST = listOf(createServiceEndpointWithVersionData(GENERATED_ID_0.toHexString()))

val VERSION_DATA = Version().apply{
    repositoryUrl = "repositoryUrl"
    branchName = "branchName"
    buildTime = "buildTime"
    sha = "sha"
    versionId = "versionId"
}

