package online.bingzi.internal.entity

import java.util.*

/**
 * User
 * 用户类
 *
 * @property uid 用户唯一标识
 * @property username 用户展示名
 * @property password 登录密码
 * @property age 年龄（-1 未设置）
 * @property sex 性别（0-隐藏，1-男，2女）
 * @property tel 电话号码-用来作为登录账户
 * @property email 邮箱
 * @property clazz 班级
 * @constructor Create empty User
 */
data class User(
    var uid: UUID = UUID.randomUUID(),
    var username: String = "一只小可爱",
    var password: String,
    var age: Int = -1,
    var sex: Int = 0,
    var tel: String,
    var email: String = "",
    var clazz: String = "",
)
