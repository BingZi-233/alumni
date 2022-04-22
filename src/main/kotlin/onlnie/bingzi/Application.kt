package onlnie.bingzi

import io.ktor.server.engine.*
import io.ktor.server.netty.*
import onlnie.bingzi.plugins.*

fun main() {
    embeddedServer(Netty, port = 8080, host = "0.0.0.0") {
        configureRouting()
        configureMonitoring()
        configureSerialization()
        configureAdministration()
        configureSecurity()
    }.start(wait = true)
}
