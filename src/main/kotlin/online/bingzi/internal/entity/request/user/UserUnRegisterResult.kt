package online.bingzi.internal.entity.request.user

import kotlinx.serialization.Serializable

/**
 * User un register
 *
 * @property user 账户
 * @property info 备注
 * @constructor Create empty User un register
 */
@Serializable
data class UserUnRegisterResult(
    var user: String = "",
    var result: Boolean = false,
    var info: String = "账户${user}不存在或密码错误。",
)
