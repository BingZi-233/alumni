package online.bingzi.internal.model.routes.auth

import io.ktor.server.application.*
import io.ktor.server.request.*
import io.ktor.server.response.*
import io.ktor.server.routing.*
import online.bingzi.internal.entity.request.auth.UserUnRegister
import online.bingzi.internal.entity.request.auth.UserUnRegisterResult

/**
 * Unregister
 * 注销路由
 *
 * @param path Url路径
 */
fun Route.unregister(path: String) {
    post(path) {
        // 将发送过来的JSON进行序列化
        val userUnRegister = call.receive(UserUnRegister::class)
        // 预构建返回对象，已指定用户名
        val userUnRegisterResult = UserUnRegisterResult(userUnRegister.user)
        // 在数据库中查询该用户（用户和密码均匹配），并设置返回对象的返回值
        userUnRegisterResult.result = AuthSession.unRegisterMapper.queryUserByUser(userUnRegister)?.let {
            // 已查到符合的行，对其进行删除
            AuthSession.unRegisterMapper.deleteUser(userUnRegister)
            // 构建提示语句
            userUnRegisterResult.info = "账户${userUnRegister.user}已被删除"
            // 返回值设置为真
            true
        } ?: false // 为查询到符合对象，返回值设置为假
        // 返回实体并自动转化为JSON类型返回
        call.respond(userUnRegisterResult)
    }
}