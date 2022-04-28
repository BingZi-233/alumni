package online.bingzi.internal.entity.request.photo

import kotlinx.serialization.Serializable

/**
 * Photo image query
 *
 * @property user 用户
 * @property photo 相册
 * @constructor Create empty Photo image query
 */
@Serializable
data class PhotoImageQuery(
    val user: String,
    val photo: String,
)
