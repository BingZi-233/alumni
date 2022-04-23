package online.bingzi.internal.plugins

import io.ktor.server.application.*
import io.ktor.server.routing.*
import online.bingzi.internal.model.routes.auth.login
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

        }
        // 验证接口
        route("/auth") {
            register("/register")
            login("/login")
        }
        // 留言接口
        route("/leaveComments") {

        }
        // 照片接口
        route("/image") {

        }
    }
}
