package online.bingzi.internal.mapper.user

import online.bingzi.internal.entity.request.user.UserUpdate

/**
 * User update mapper
 * 玩家更新映射器
 *
 * @constructor Create empty User update mapper
 */
interface UserUpdateMapper {
    /**
     * Query user by user
     * 查询用户根据用户名进行
     *
     * @param unRegister 用户
     * @return 用户
     */
    fun queryUserByUser(unRegister: UserUpdate): UserUpdate?

    /**
     * Delete user
     *
     * @param unRegister 用户
     * @return 影响的行号
     */
    fun updateUser(unRegister: UserUpdate)
}