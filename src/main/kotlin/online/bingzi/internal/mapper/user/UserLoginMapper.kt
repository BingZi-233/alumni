package online.bingzi.internal.mapper.user

import online.bingzi.internal.entity.request.user.UserLogin

/**
 * User login mapper
 * 玩家登录映射器
 *
 * @constructor Create empty User login mapper
 */
interface UserLoginMapper {
    /**
     * Query user by user
     * 查询用户根据用户名进行
     *
     * @param userLogin 用户
     * @return 用户
     */
    fun queryUserByUser(userLogin: UserLogin): UserLogin?
}