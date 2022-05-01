package online.bingzi.internal.entity.request.user

/**
 * User
 *
 * @property data 数据体
 * @constructor Create empty User
 */
data class UserRequest(
    val data: MutableMap<String, String> = mutableMapOf()
)
