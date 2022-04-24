package online.bingzi.internal.entity.request.auth

import kotlinx.serialization.Serializable

/**
 * User register result
 * 用户信息验证结果
 *
 * @property user User验证结果
 * @property username UserName验证结果
 * @property password Password验证结果
 * @property clazz Class验证结果
 * @property result 最终验证结果
 * @property info 备注
 * @constructor Create empty User register result
 */
@Serializable
data class UserRegisterResult(
    var user: Boolean = false,
    var username: Boolean = false,
    var password: Boolean = false,
    var clazz: Boolean = false,
    var result: Boolean = false,
    var info: String = "",
)
