package online.bingzi.internal.entity.request.photo

import kotlinx.serialization.Serializable

/**
 * Photo image query
 *
 * @property user 用户
 * @property photo 相册
 * @property imageMutableList 图片列表
 * @constructor Create empty Photo image query
 */
@Serializable
data class PhotoImageQueryResult(
    var user: String = "",
    var photo: String = "",
    var imageMutableList: MutableList<Image> = mutableListOf(),
)
