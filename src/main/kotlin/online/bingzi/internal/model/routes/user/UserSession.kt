package online.bingzi.internal.model.routes.user

import online.bingzi.internal.mapper.user.UserLoginMapper
import online.bingzi.internal.mapper.user.UserRegisterMapper
import online.bingzi.internal.mapper.user.UserUnRegisterMapper
import online.bingzi.internal.mapper.user.UserUpdateMapper
import online.bingzi.internal.util.openSession

/**
 * User session
 * 用户路由的MySQL访问入口
 *
 * @constructor Create empty Auth session
 */
object UserSession {
    val userRegisterMapper: UserRegisterMapper = openSession.getMapper(UserRegisterMapper::class.java)
    val userUnRegisterMapper: UserUnRegisterMapper = openSession.getMapper(UserUnRegisterMapper::class.java)
    val userUpdateMapper: UserUpdateMapper = openSession.getMapper(UserUpdateMapper::class.java)
    val userLoginMapper: UserLoginMapper = openSession.getMapper(UserLoginMapper::class.java)
}