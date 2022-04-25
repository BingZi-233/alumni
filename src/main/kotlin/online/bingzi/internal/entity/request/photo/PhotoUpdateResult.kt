package online.bingzi.internal.entity.request.photo

/**
 * Photo update result
 *
 * @property user 用户
 * @property uid 相册UUID
 * @property photo 相册名称验证结果
 * @property result 最终验证结果
 * @property info 备注
 * @constructor Create empty Photo update result
 */
data class PhotoUpdateResult(
    val user: String,
    val uid: String,
    val photo: Boolean,
    val result: Boolean,
    val info: String,
)
