package online.bingzi.internal.entity.request.photo

import kotlinx.serialization.Serializable

/**
 * Photo delete
 *
 * @property user 用户
 * @property uid 相册UUID
 * @constructor Create empty Photo delete
 */
@Serializable
data class PhotoDelete(
    val user: String,
    val uid: String,
)
