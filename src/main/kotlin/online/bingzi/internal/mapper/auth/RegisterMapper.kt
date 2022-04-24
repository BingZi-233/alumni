package online.bingzi.internal.mapper.auth

import online.bingzi.internal.entity.request.auth.UserRegister

interface RegisterMapper {
    /**
     * Query user by user
     * 查询用户根据用户名进行
     *
     * @param user 用户名
     * @return 用户
     */
    fun queryUserByUser(user: String): UserRegister?

    /**
     * Insert user
     * 插入用户
     *
     * @return 影响的行号
     */
    fun insertUser(userRegister: UserRegister): Int
}