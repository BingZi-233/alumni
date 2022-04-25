package online.bingzi.internal.entity.request.user

import kotlinx.serialization.Serializable

@Serializable
data class UserLoginResult(
    var user: String,
    var token: String = "",
    var result: Boolean = false,
    var info: String = "验证失败，账户名或者密码不正确。",
)
