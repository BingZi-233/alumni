package online.bingzi.internal.mapper

import online.bingzi.internal.entity.essentials.EssentialsMessageBoardData

/**
 * Message mapper
 * 留言板映射器
 *
 * @constructor Create empty Message mapper
 */
interface MessageMapper {
    /**
     * Query message by user
     * 通过用户查询留言板
     *
     * @param user 用户
     * @return 留言板基本数据
     */
    fun queryMessageByUser(user: String): EssentialsMessageBoardData?

    /**
     * Query message by clazz
     * 通过班级查询留言板
     *
     * @param clazz 班级
     * @return 留言板基本数据
     */
    fun queryMessageByClazz(clazz: String): EssentialsMessageBoardData?

    /**
     * Insert message by user
     * 通过用户新建留言板
     *
     * @param essentialsMessageBoardData 留言板基本数据
     */
    fun insertMessageByUser(essentialsMessageBoardData: EssentialsMessageBoardData)

    /**
     * Insert message by clazz
     * 通过班级新建留言板
     *
     * @param essentialsMessageBoardData 留言板基本数据
     */
    fun insertMessageByClazz(essentialsMessageBoardData: EssentialsMessageBoardData)

    /**
     * Update message by user
     * 通过用户更新留言板
     *
     * @param message 留言板
     * @param user 用户
     */
    fun updateMessageByUser(message: String, user: String)

    /**
     * Update message by user
     * 通过用户更新留言板
     *
     * @param message 留言板
     * @param user 用户
     */
    fun updateMessageByClazz(message: String, user: String)
}