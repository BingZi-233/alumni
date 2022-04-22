package onlnie.bingzi.plugins

import io.ktor.server.application.*
import io.ktor.server.plugins.callloging.*
import io.ktor.server.request.*
import org.slf4j.event.Level

/**
 * Configure monitoring
 * 日志模块
 */
fun Application.configureMonitoring() {
    // 安装CallLogging日志模块
    install(CallLogging) {
        // 设置日志等级
        level = Level.INFO
        // 记录访问到这个路由的日志
        filter { call -> call.request.path().startsWith("/") }
    }

}
