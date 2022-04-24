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
        val userUnRegister = call.receive(UserUnRegister::class)
        val userUnRegisterResult = UserUnRegisterResult(userUnRegister.user)
        userUnRegisterResult.result = AuthSession.unRegisterMapper.queryUserByUser(userUnRegister)?.let {
            AuthSession.unRegisterMapper.deleteUser(userUnRegister)
            userUnRegisterResult.info = "账户${userUnRegister.user}已被删除"
            true
        } ?: false
        call.respond(userUnRegisterResult)
    }
}