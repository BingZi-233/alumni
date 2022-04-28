package online.bingzi.internal.routes.user

import io.ktor.server.application.*
import io.ktor.server.request.*
import io.ktor.server.response.*
import io.ktor.server.routing.*
import online.bingzi.internal.entity.request.user.UserLogin
import online.bingzi.internal.entity.request.user.UserLoginResult
import online.bingzi.internal.plugins.authGetToken
import online.bingzi.internal.routes.user.UserSession.userLoginMapper

/**
 * Login
 *
 * @param path Url路径
 */
fun Route.userLogin(path: String) {
    post(path) {
        // 将发送过来的JSON进行序列化
        val userLogin = call.receive(UserLogin::class)
        // 构建返回对象并对值进行初始化
        val userLoginResult = UserLoginResult(userLogin.user)
        // 在数据库中查询该用户是否存在
        userLoginMapper.queryUserByUser(userLogin)?.let {
            // 设置返回的token
            userLoginResult.token = authGetToken(userLogin.user)
            // 修改返回值
            userLoginResult.result = true
            // 设置返回信息
            userLoginResult.info = "登录成功"
        }
        call.respond(userLoginResult)
    }
}