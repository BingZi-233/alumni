package online.bingzi.internal.plugins

import io.ktor.server.application.*
import io.ktor.server.auth.*
import io.ktor.server.routing.*
import online.bingzi.internal.model.routes.user.userLogin
import online.bingzi.internal.model.routes.user.userRegister
import online.bingzi.internal.model.routes.user.userUnRegister
import online.bingzi.internal.model.routes.user.userUpdate

/**
 * Configure routing
 * 路由模块
 */
fun Application.configureRouting() {
    // 默认自动安装，并使用routing{ }来进行集中管理路由请求
    routing {
        // API接口路由
        route("/api") {
            // 安全主路由
            route("/auth") {
                // 注册路由
                userRegister("/register")
                // 注销路由
                userUnRegister("/unregister")
                // 登录路由
                userLogin("/login")
            }
            authenticate {

            }
            // 更新主路由
            route("/update") {
                // 用户信息更新路由
                userUpdate("/user")
            }
        }
    }
}
