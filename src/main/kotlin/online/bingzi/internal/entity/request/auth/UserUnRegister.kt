package online.bingzi.internal.entity.request.auth

import kotlinx.serialization.Serializable

/**
 * User un register
 *
 * @property user 账户
 * @property password 密码
 * @constructor Create empty User un register
 */
@Serializable
data class UserUnRegister(
    var user: String = "",
    var password: String = "",
)
