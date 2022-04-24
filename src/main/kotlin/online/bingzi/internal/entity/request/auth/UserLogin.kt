package online.bingzi.internal.entity.request.auth

import kotlinx.serialization.Serializable

@Serializable
data class UserLogin(
    var user: String,
    var password: String,
)
