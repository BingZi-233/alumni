package online.bingzi.internal.entity.request.user

import kotlinx.serialization.Serializable

/**
 * User update
 *
 * @property id 数据中行号
 * @property user 账户
 * @property username 账户昵称
 * @property password 密码
 * @property clazz 班级
 * @constructor Create empty User update
 */
@Serializable
data class UserUpdate(
    var id: Int = 0,
    var user: String,
    var username: String = "一只小可爱",
    var password: String,
    var clazz: String = "",
)
