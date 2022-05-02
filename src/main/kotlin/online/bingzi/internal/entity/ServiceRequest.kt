package online.bingzi.internal.entity

/**
 * Request
 *
 * @property data 数据体
 * @constructor Create empty User
 */
@kotlinx.serialization.Serializable
data class ServiceRequest(
    val data: MutableMap<String, String> = mutableMapOf()
)
