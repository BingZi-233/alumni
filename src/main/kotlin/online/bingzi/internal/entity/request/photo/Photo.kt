package online.bingzi.internal.entity.request.photo

import kotlinx.serialization.Serializable

/**
 * Photo
 *
 * @property user 用户
 * @property uid 相册UUID
 * @property photo 相册名称
 * @property image 预览图片
 * @constructor Create empty Photo
 */
@Serializable
data class Photo(
    val user: String,
    val uid: String,
    val photo: String,
    val image: String,
)
