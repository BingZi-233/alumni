package online.bingzi.internal.entity.request.photo

import kotlinx.serialization.Serializable

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
@Serializable
data class PhotoUpdateResult(
    var user: String = "",
    var uid: String = "",
    var photo: Boolean = false,
    var result: Boolean = false,
    var info: String = "",
)
