package online.bingzi.internal.plugins

import io.ktor.server.application.*
import io.ktor.server.auth.*
import io.ktor.server.routing.*
import online.bingzi.internal.routes.messageBoard.messageBoardInsert
import online.bingzi.internal.routes.messageBoard.messageBoardQuery
import online.bingzi.internal.routes.messageBoard.messageBoardUpdate
import online.bingzi.internal.routes.photo.*
import online.bingzi.internal.routes.user.userLogin
import online.bingzi.internal.routes.user.userRegister
import online.bingzi.internal.routes.user.userUnRegister
import online.bingzi.internal.routes.user.userUpdate

/**
 * Configure routing
 * 路由模块
 */
fun Application.configureRouting() {
    // 默认自动安装，并使用routing{ }来进行集中管理路由请求
    routing {
        // API接口路由
        route("/api") {
            // 安全不安全路由
            route("/auth") {
                // 注册路由
                userRegister("/register")
                // 登录路由
                userLogin("/login")
            }
            // 受保护的路由，以下路由受JWT(Token)保护
            authenticate("auth-jwt") {
                // 认证安全路由
                route("/auth") {
                    // 注销路由
                    userUnRegister("/unregister")
                    // 用户信心更新
                    userUpdate("/update")
                }
                // 留言板
                route("/messageboard") {
                    messageBoardInsert("/insert")
                    messageBoardUpdate("/update")
                    messageBoardQuery("/query")
                }
                // 相册安全路由
                route("photo") {
                    // 相册创建路由
                    photoCreate("/create")
                    // 相册查询路由
                    photoQuery("/query")
                    // 相册更新路由
                    photoUpdate("/update")
                    // 相册删除路由
                    photoDelete("/delete")
                    // 相册内图片安全路由
                    route("/image") {
                        // 相册内照片查询路由
                        photoImageQuery("/query")
                        // 相册内照片删除路由
                        photoImageDelete("/delete")
                        // 相册内照片插入路由
                        photoImageInsert("/insert")
                    }
                }
            }
        }
    }
}
