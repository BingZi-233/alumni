package online.bingzi.internal.entity.request.photo

/**
 * Photo delete
 *
 * @property user 用户
 * @property uid 相册UUID
 * @property result 结果
 * @property info 备注
 * @constructor Create empty Photo delete
 */
data class PhotoDeleteResult(
    var user: String = "",
    var uid: String = "",
    var result: Boolean = false,
    var info: String = "",
)
