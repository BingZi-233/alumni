package online.bingzi.internal.routes.user

import io.ktor.server.application.*
import io.ktor.server.request.*
import io.ktor.server.response.*
import io.ktor.server.routing.*
import online.bingzi.internal.entity.StatusCode.Type.*
import online.bingzi.internal.entity.request.user.UserRequest
import online.bingzi.internal.entity.request.user.UserResult
import online.bingzi.internal.plugins.authGetToken

/**
 * Login
 *
 * @param path Url路径
 */
fun Route.userLogin(path: String) {
    post(path) {
        // 接收数据并将其进行序列化
        val userRequest = call.receive(UserRequest::class)
        // 预构建返回数据
        val userResult = UserResult()
        // 获取账户
        val user = userRequest.data["user"]
        // 获取密码
        val password = userRequest.data["password"]
        // 账户和密码为空校验，并设置状态码
        userResult.statusCode.code = if (user != null && password != null) {
            // 在数据库中查询相关行，并设置状态体
            userMapper.queryUserByUserAndPassword(user, password)?.let {
                // 在data中附加token作为安全令牌
                userResult.data["token"] = authGetToken(user)
                // 返回成功状态码
                OK
            } ?: ERROR // 返回错误状态码
        } else {
            // 账户和密码全部为空或有一者为空，状态码变更为警告码
            WARING
        }
        // 设置返回信息
        userResult.statusCode.message = when (userResult.statusCode.code) {
            OK -> "验证通过，登录成功！"
            ERROR -> "验证失败，账户或密码错误！"
            WARING -> "无法验证，账户或者密码留空！"
            UNKNOWN -> "未知错误，程序或已离线！"
        }
        // 对请求进行响应
        call.respond(userResult)
    }
}