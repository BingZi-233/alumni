package online.bingzi.internal.entity.request.photo

import kotlinx.serialization.Serializable

/**
 * Photo query
 *
 * @property user 用户
 * @constructor Create empty Photo query
 */
@Serializable
data class PhotoQuery(
    val user: String,
)
