package online.bingzi.internal.plugins

import com.auth0.jwt.JWT
import com.auth0.jwt.algorithms.Algorithm
import io.ktor.http.*
import io.ktor.server.application.*
import io.ktor.server.auth.*
import io.ktor.server.auth.jwt.*
import io.ktor.server.response.*
import java.util.*

private const val secret = "secret"
private const val issuer = "http://0.0.0.0:8080/"
private const val audience = "http://0.0.0.0:8080/hello"
private const val myRealm = "bingzi.online"

fun Application.configureSecurity() {
    // 安装Jwt安全模块
    install(Authentication) {
        jwt("auth-jwt") {
            realm = myRealm
            verifier(JWT.require(Algorithm.HMAC256(secret)).withAudience(audience).withIssuer(issuer).build())
            validate {
                if (it.payload.getClaim("user").asString() != "") {
                    JWTPrincipal(it.payload)
                } else {
                    null
                }
            }
            challenge { _, _ ->
                call.respond(HttpStatusCode.Unauthorized, "令牌无效或已过期")
            }
        }
    }
}

fun authGetToken(user: String): String {
    return JWT.create()
        .withAudience(audience)
        .withIssuer(issuer).withClaim("user", user)
        .withExpiresAt(Date(System.currentTimeMillis() + 3600 * 1000 * 10))
        .sign(Algorithm.HMAC256(secret))
}
