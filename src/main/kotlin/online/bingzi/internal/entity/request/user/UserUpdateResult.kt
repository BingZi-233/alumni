package online.bingzi.internal.entity.request.user

import kotlinx.serialization.Serializable

/**
 * User update result
 *
 * @property user 账户
 * @property username 账户昵称
 * @property password 密码
 * @property clazz 班级
 * @property result 最终验证结果
 * @property info 备注
 * @constructor Create empty User update result
 */
@Serializable
data class UserUpdateResult(
    var user: Boolean = false,
    var username: Boolean = false,
    var password: Boolean = false,
    var clazz: Boolean = false,
    var result: Boolean = false,
    var info: String = "账户${user}不存在或格式错误。",
)
