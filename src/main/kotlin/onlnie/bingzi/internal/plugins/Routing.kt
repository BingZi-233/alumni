package onlnie.bingzi.internal.plugins

import io.ktor.server.application.*
import io.ktor.server.routing.*

/**
 * Configure routing
 * 路由模块
 */
fun Application.configureRouting() {
    // 默认自动安装，并使用routing{ }来进行集中管理路由请求
    routing {
        // 注册
        register("/register")
        // 登录
        login("/login")
        userInfo("/user/{id}")
    }
}

private fun Route.register(path: String) {
    post(path) {

    }
}

private fun Route.login(path: String) {
    post(path) {

    }
}

private fun Route.userInfo(path: String) {
    post(path) {

    }
}

private fun Route.leaveComments(path: String) {
    post(path) {

    }
}
