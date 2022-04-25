package online.bingzi.internal.model.routes.user

import io.ktor.server.application.*
import io.ktor.server.request.*
import io.ktor.server.routing.*
import online.bingzi.internal.entity.User

/**
 * Login
 *
 * @param path Url路径
 */
fun Route.userLogin(path: String) {
    post(path) {
        // 将发送过来的JSON进行序列化
        val user = call.receive(User::class)
    }
}