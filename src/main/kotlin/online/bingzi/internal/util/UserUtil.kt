package online.bingzi.internal.routes.user

import online.bingzi.internal.mapper.user.UserMapper
import online.bingzi.internal.util.openSession

/**
 * User session
 * 用户路由的MySQL访问入口
 *
 * @constructor Create empty Auth session
 */
val userMapper: UserMapper = openSession.getMapper(UserMapper::class.java)
