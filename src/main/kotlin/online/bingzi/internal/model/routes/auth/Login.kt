package online.bingzi.internal.model.routes.auth

import io.ktor.server.routing.*
import online.bingzi.internal.mapper.UserMapper
import online.bingzi.internal.util.openSession

/**
 * Login
 *
 * @param path Url路径
 */
fun Route.login(path: String) {

}

/**
 * Login
 *
 * @constructor Create empty Login
 */
object Login {
    // 数据库连接对象，这个变量具体负责访问数据库。
    val userMapper: UserMapper = openSession.getMapper(UserMapper::class.java)

}