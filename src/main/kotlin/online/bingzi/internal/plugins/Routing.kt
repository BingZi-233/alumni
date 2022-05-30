package online.bingzi.internal.plugins

import io.ktor.server.application.*
import io.ktor.server.auth.*
import io.ktor.server.http.content.*
import io.ktor.server.routing.*
import online.bingzi.internal.routes.api.messageBoard.messageBoardInsert
import online.bingzi.internal.routes.api.messageBoard.messageBoardQuery
import online.bingzi.internal.routes.api.messageBoard.messageBoardUpdate
import online.bingzi.internal.routes.api.photo.*
import online.bingzi.internal.routes.api.record.recordInsert
import online.bingzi.internal.routes.api.record.recordQuery
import online.bingzi.internal.routes.api.record.recordUpdate
import online.bingzi.internal.routes.api.user.userLogin
import online.bingzi.internal.routes.api.user.userRegister
import online.bingzi.internal.routes.api.user.userUnRegister
import online.bingzi.internal.routes.api.user.userUpdate

/**
 * Configure routing
 * 路由模块
 */
fun Application.configureRouting() {
    // 默认自动安装，并使用routing{ }来进行集中管理路由请求
    routing {
        static("/") {
            staticBasePackage = "static"
            resource("index.html")
            defaultResource("index.html")

            static {
                staticBasePackage = "static/assets"
                static("assets") {
                    static("css") {
                        resources("css")
                    }
                    static("imgs") {
                        resources("imgs")
                    }
                    static("js") {
                        resources("js")
                    }
                    static("scss") {
                        resources("scss")
                    }
                    static("vendors") {
                        resources("vendors")
                    }
                }
            }
        }
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
                // 通讯录
                route("/record") {
                    // 新增
                    recordInsert("/insert")
                    // 查询
                    recordQuery("/query")
                    // 更新
                    recordUpdate("/update")
                }
                // 留言板
                route("/messageboard") {
                    // 新增
                    messageBoardInsert("/insert")
                    // 更新
                    messageBoardUpdate("/update")
                    // 查询
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
