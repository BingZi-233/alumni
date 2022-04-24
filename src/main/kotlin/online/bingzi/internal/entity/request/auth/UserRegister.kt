package online.bingzi.internal.entity.request.auth

import kotlinx.serialization.Serializable

/**
 * User register
 *
 * @property id 数据中行号
 * @property user 账户
 * @property username 账户昵称
 * @property password 密码
 * @property clazz 班级
 * @constructor Create empty User register
 */
@Serializable
data class UserRegister(
    var id: Int = 0,
    var user: String,
    var username: String = "一只小可爱",
    var password: String,
    var clazz: String = "",
)
