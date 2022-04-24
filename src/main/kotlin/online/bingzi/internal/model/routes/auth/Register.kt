package online.bingzi.internal.model.routes.auth

import io.ktor.server.application.*
import io.ktor.server.request.*
import io.ktor.server.response.*
import io.ktor.server.routing.*
import online.bingzi.internal.entity.request.auth.UserRegister
import online.bingzi.internal.entity.request.auth.UserRegisterResult

/**
 * Register
 *
 * @param path Url路径
 */
fun Route.register(path: String) {
    post(path) {
        // 将发送过来的JSON进行序列化
        val userRegister = call.receive(UserRegister::class)
        val userRegisterResult = UserRegisterResult().apply {
            this.user = userRegister.user.matches("^[a-zA-Z\\d_-]{2,15}$".toRegex())
            this.username = userRegister.username.matches("[\\u4e00-\\u9fa5]*[a-z]*[A-Z]*\\\\d*-*_*\\\\s*".toRegex())
            this.password = userRegister.password.matches("^(?!\\d+\$)(?![a-zA-Z]+\$)[\\dA-Za-z]{6,15}\$".toRegex())
            this.clazz = userRegister.clazz.matches("^[a-zA-Z\\d_-]{2,15}\$".toRegex())
            this.result = user && username && password && clazz
            this.info = if (result) "校验已结束，全部正确！该数据已插入到数据库中。" else "校验失败，有部分参数不正确！请检查您不正确的参数并进行修正。"
        }
        call.respond(userRegisterResult)
    }
}