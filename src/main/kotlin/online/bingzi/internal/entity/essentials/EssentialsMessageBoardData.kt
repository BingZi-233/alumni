package online.bingzi.internal.entity.essentials

import online.bingzi.internal.entity.message.MessageData

/**
 * Essentials message board data
 *
 * @property user 用户
 * @property type 1-用户，0-班级
 * @property message 消息列表
 * @constructor Create empty Essentials message board data
 */
@kotlinx.serialization.Serializable
data class EssentialsMessageBoardData(
    var user: String = "",
    var type: Int = -1,
    var message: MutableList<MessageData> = mutableListOf(),
)
