package online.bingzi.internal.plugins

import io.ktor.server.application.*
import io.ktor.server.routing.*
import online.bingzi.internal.model.routes.auth.register

/**
 * Configure routing
 * 路由模块
 */
fun Application.configureRouting() {
    // 默认自动安装，并使用routing{ }来进行集中管理路由请求
    routing {
        // API接口
        route("/api") {
            route("/auth") {
                register("/register")
            }
        }
    }
}
