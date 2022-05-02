package online.bingzi.internal.entity.message

import java.time.LocalDateTime
import java.time.ZoneOffset

/**
 * Message data
 * 消息数据
 *
 * @property time 时间
 * @property user 用户
 * @property message 消息
 * @constructor Create empty Message data
 */
@kotlinx.serialization.Serializable
data class MessageData(
    var time: Long = LocalDateTime.now().toInstant(ZoneOffset.of("+8")).toEpochMilli(),
    var user: String = "",
    var message: String = "",
)
