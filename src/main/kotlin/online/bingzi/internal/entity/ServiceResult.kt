package online.bingzi.internal.entity

/**
 * Result
 *
 * @property statusCode 状态体
 * @property data 数据体
 * @constructor Create empty User
 */
data class ServiceResult(
    val statusCode: StatusCode = StatusCode(StatusCode.Type.UNKNOWN),
    val data: MutableMap<String, String> = mutableMapOf()
)
