package online.bingzi.internal.mapper

import online.bingzi.internal.entity.essentials.EssentialsMessageBoardData

/**
 * Message mapper
 * 留言板映射器
 *
 * @constructor Create empty Message mapper
 */
interface MessageMapper {
    fun queryMessageByUser(user: String): EssentialsMessageBoardData?
    fun queryMessageByClazz(clazz: String): EssentialsMessageBoardData?
    fun insertMessageByUser(essentialsMessageBoardData: EssentialsMessageBoardData)
    fun insertMessageByClazz(essentialsMessageBoardData: EssentialsMessageBoardData)
    fun updateMessageByUser(message: String, user: String)
    fun updateMessageByClazz(message: String, user: String)
}