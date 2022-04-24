package online.bingzi.internal.mapper.auth

import online.bingzi.internal.entity.request.auth.UserUnRegister

interface UnRegisterMapper {
    /**
     * Query user by user
     * 查询用户根据用户名进行
     *
     * @param unRegister 用户
     * @return 用户
     */
    fun queryUserByUser(unRegister: UserUnRegister): UserUnRegister?

    /**
     * Delete user
     *
     * @param unRegister 用户
     * @return 影响的行号
     */
    fun deleteUser(unRegister: UserUnRegister): Int
}