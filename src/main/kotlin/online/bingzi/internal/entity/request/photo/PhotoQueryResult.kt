package online.bingzi.internal.entity.request.photo

import kotlinx.serialization.Serializable

/**
 * Photo query result
 *
 * @property user 用户
 * @property photoMutableList 相册列表
 * @constructor Create empty Photo query result
 */
@Serializable
data class PhotoQueryResult(
    var user: String = "",
    val photoMutableList: MutableList<Photo> = mutableListOf()
)
