package online.bingzi.internal.entity.request.photo

import kotlinx.serialization.Serializable

/**
 * Image
 *
 * @property uid 相册UUID
 * @property image 预览图片
 * @constructor Create empty Photo
 */
@Serializable
data class Image(
    val uid: String,
    val image: String,
)
