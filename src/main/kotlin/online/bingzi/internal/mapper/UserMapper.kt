package online.bingzi.internal.mapper

import online.bingzi.internal.entity.essentials.EssentialsUserData

/**
 * User mapper
 * 用户映射器
 *
 * @constructor Create empty User mapper
 */
interface UserMapper {
    /**
     * Query user by user
     * 通过账户查询用户
     *
     * @param user 账户
     * @return 用户基础数据
     */
    fun queryUserByUser(user: String): EssentialsUserData?

    /**
     * Query user by user and password
     * 根据账户和密码查询用户
     *
     * @return 用户基础数据
     */
    fun queryUserByUserAndPassword(map: HashMap<String, Any>): EssentialsUserData?

    /**
     * Insert user
     * 插入用户数据
     *
     * @param essentialsUserData 用户基础数据
     */
    fun insertUser(essentialsUserData: EssentialsUserData)

    /**
     * Delete user by user
     * 根据账户删除用户
     *
     * @param user 账户
     */
    fun deleteUserByUser(user: String)

    /**
     * Delete user by user and password
     * 根据账户和密码删除用户
     *
     */
    fun deleteUserByUserAndPassword(map: HashMap<String, Any>)

    /**
     * Update user
     * 更新用户数据
     *
     * @param essentialsUserData 用户基础数据
     */
    fun updateUser(essentialsUserData: EssentialsUserData)
}