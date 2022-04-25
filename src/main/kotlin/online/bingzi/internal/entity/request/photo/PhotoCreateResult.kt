package online.bingzi.internal.entity.request.photo

import kotlinx.serialization.Serializable

/**
 * Photo create result
 *
 * @property user 用户验证结果
 * @property photo 相册验证结果
 * @property image 预览图验证结果
 * @property result 最终验证结果
 * @property info 备注
 * @constructor Create empty Photo create result
 */
@Serializable
data class PhotoCreateResult(
    var user: Boolean = false,
    var photo: Boolean = false,
    var image: Boolean = false,
    var result: Boolean = false,
    var info: String = "用户${user}的相册已超过了最大值或者部分参数验证失败。",
)
