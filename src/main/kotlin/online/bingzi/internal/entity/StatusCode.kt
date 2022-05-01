package online.bingzi.internal.entity

/**
 * Status code
 * 状态体
 *
 * @property code 状态码
 * @property message 状态信息
 * @constructor Create empty Status code
 */
@kotlinx.serialization.Serializable
data class StatusCode(
    var code: Type,
    var message: String = "",
) {
    enum class Type {
        /**
         * Ok
         * 没有发生任何异常，已正确响应请求。
         * @constructor Create empty Ok
         */
        OK,

        /**
         * Error
         * 发生了致命错误，无法完成请求。
         * @constructor Create empty Error
         */
        ERROR,

        /**
         * Waring
         * 完成了对应请求，但是可能有一些潜在的问题。
         * @constructor Create empty Waring
         */
        WARING,

        /**
         * Unknown
         * 未知，通常用于预构建返回请求
         *
         * @constructor Create empty Unknown
         */
        UNKNOWN,
    }
}
