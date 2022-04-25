package online.bingzi.internal.entity.request.photo

import kotlinx.serialization.Serializable
import java.util.*

/**
 * Photo create
 *
 * @property user 用户
 * @property uid 相册UUID
 * @property photo 相册名
 * @property image 预览图
 * @constructor Create empty Photo create
 */
@Serializable
data class PhotoCreate(
    var user: String,
    var uid: String = UUID.randomUUID().toString(),
    var photo: String = "默认名",
    var image: String = "",
)
