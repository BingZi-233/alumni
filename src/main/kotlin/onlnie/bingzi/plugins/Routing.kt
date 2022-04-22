package onlnie.bingzi.plugins

import io.ktor.server.application.*
import io.ktor.server.response.*
import io.ktor.server.routing.*

/**
 * Configure routing
 * 路由模块
 */
fun Application.configureRouting() {
    // 默认自动安装，并使用routing{ }来进行集中管理路由请求
    routing {
        get("/") {
            call.respondText("Hello World!")
        }
    }
}
