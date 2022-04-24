package online.bingzi.internal.model.routes.auth

import online.bingzi.internal.mapper.auth.RegisterMapper
import online.bingzi.internal.mapper.auth.UnRegisterMapper
import online.bingzi.internal.util.openSession

/**
 * Auth session
 * 认证路由的MySQL访问入口
 *
 * @constructor Create empty Auth session
 */
object AuthSession {
    val registerMapper: RegisterMapper = openSession.getMapper(RegisterMapper::class.java)
    val unRegisterMapper: UnRegisterMapper = openSession.getMapper(UnRegisterMapper::class.java)
}