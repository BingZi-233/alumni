package online.bingzi.internal.entity.request.photo

import kotlinx.serialization.Serializable

/**
 * Photo image insert or delete
 *
 * @property user 用户
 * @property photo 相册uid
 * @property image 图像地址
 * @property type 类型，插入还是删除(1-Insert,0-Delete)
 * @constructor Create empty Photo image insert or delete
 */
@Serializable
data class PhotoImageInsertOrDelete(
    val user: String,
    val photo: String,
    val image: String,
    val type: Int,
)
