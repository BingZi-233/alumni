package onlnie.bingzi.plugins

import io.ktor.server.application.*
import io.ktor.server.engine.*

fun Application.configureAdministration() {
    install(ShutDownUrl.ApplicationCallPlugin) {
        // 将被拦截的 URL（也可以使用 application.conf 的 ktor.deployment.shutdown.url 键）
        shutDownUrl = "/shutdown"
        // 将执行以获取进程的退出代码的函数
        exitCodeSupplier = { 0 } // ApplicationCall.() -> Int
    }

}
