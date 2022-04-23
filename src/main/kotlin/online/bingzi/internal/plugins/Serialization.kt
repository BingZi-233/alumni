package online.bingzi.internal.plugins

import io.ktor.serialization.kotlinx.json.*
import io.ktor.server.application.*
import io.ktor.server.plugins.contentnegotiation.*

/**
 * Configure serialization
 * 序列化模块
 */
fun Application.configureSerialization() {
    // 安装ContentNegotiation插件
    install(ContentNegotiation) {
        // 启用JSON序列化功能
        json()
    }
}
