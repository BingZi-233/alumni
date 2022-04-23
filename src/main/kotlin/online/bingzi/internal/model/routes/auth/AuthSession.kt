package online.bingzi.internal.model.routes.auth

import online.bingzi.internal.mapper.UserMapper
import online.bingzi.internal.util.openSession

/**
 * Auth session
 * 认证路由的MySQL访问入口
 *
 * @constructor Create empty Auth session
 */
object AuthSession {
    val mapper: UserMapper = openSession.getMapper(UserMapper::class.java)
}