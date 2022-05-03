package online.bingzi.internal.entity.essentials

import com.alibaba.fastjson2.JSONArray
import online.bingzi.internal.entity.message.MessageData
import online.bingzi.internal.util.gson

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
    var message: String = "",
) {
    fun getMessageList(): MutableList<MessageData> {
        return JSONArray.of(message).toJavaList(MessageData::class.java) ?: mutableListOf()
    }

    fun setMessageList(messageList: MutableList<MessageData>) {
        this.message = gson.toJson(messageList)
    }
}
