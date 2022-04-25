package online.bingzi.internal.entity.request.photo

/**
 * Photo update
 *
 * @property user 用户
 * @property uid 相册UUID
 * @property photo 相册新名字
 * @constructor Create empty Photo update
 */
data class PhotoUpdate(
    val user: String,
    val uid: String,
    val photo: String,
)
