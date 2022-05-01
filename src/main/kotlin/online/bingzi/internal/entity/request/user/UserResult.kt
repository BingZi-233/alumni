package online.bingzi.internal.entity.request.user

import online.bingzi.internal.entity.StatusCode

/**
 * User
 *
 * @property statusCode 状态体
 * @property data 数据体
 * @constructor Create empty User
 */
data class UserResult(
    val statusCode: StatusCode = StatusCode(StatusCode.Type.UNKNOWN),
    val data: MutableMap<String, String> = mutableMapOf()
)
