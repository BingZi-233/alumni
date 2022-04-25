package online.bingzi.internal.util

import io.ktor.server.application.*
import io.ktor.server.auth.*
import io.ktor.server.auth.jwt.*
import io.ktor.util.pipeline.*


fun PipelineContext<Unit, ApplicationCall>.tokenVerification(): Boolean {
    return call.principal<JWTPrincipal>()?.let {
        it.payload.getClaim("user").asString()
        val time = it.expiresAt?.time?.minus(System.currentTimeMillis()) ?: 0
        if (time <= 0) {
            call.application.environment.log.info("令牌已过期")
            true
        } else {
            call.application.environment.log.info("令牌将在 $time 毫秒后过期")
            false
        }
    } ?: false
}