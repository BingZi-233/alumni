package onlnie.bingzi

import io.ktor.server.engine.*
import io.ktor.server.netty.*
import onlnie.bingzi.internal.plugins.*

/**
 * Main
 * 主函数入口
 */
fun main() {
    /**
     * 服务端启动入口
     * 引擎 Netty
     * 端口 8080
     * 地址 0.0.0.0
     */
    embeddedServer(Netty, port = 8080, host = "0.0.0.0") {
        // 路由配置
        // 管理和分发所有请求消息
        configureRouting()
        // 监控配置
        // 对系统内进行日志记录
        configureMonitoring()
        // 序列化配置
        // 对接受/发送的数据进行序列化
        configureSerialization()
        // Administration配置
        // 用来管理系统的情况，目前主要是负责正确关闭程序
        configureAdministration()
        // 安全配置
        // 管理账户的登录以及后续的验证
        configureSecurity()
    }.start(wait = true) // 阻塞启动
}
