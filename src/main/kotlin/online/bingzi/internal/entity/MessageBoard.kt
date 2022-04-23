package online.bingzi.internal.entity

import java.util.*

/**
 * Message board
 * 留言板
 *
 * @property uuid UUID
 * @property type 类型
 * @property user 关联用户
 * @constructor Create empty Message board
 */
data class MessageBoard(
    var uuid: UUID = UUID.randomUUID(),
    var type: Type = Type.Class,
    var user: String? = null,
    var messageList: MutableList<String> = mutableListOf(),
) {
    /**
     * Type
     * 留言板类型
     *
     * @constructor Create empty Type
     */
    enum class Type {
        // 班级
        Class,

        // 个人
        Personal
    }
}
