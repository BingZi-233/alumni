package online.bingzi.internal.entity.request.photo

import kotlinx.serialization.Serializable

/**
 * Photo image insert or delete
 *
 * @property user 用户
 * @property photo 相册uid
 * @property image 图像地址
 * @property type 类型，插入还是删除(1-Insert,0-Delete)
 * @property result 结果
 * @constructor Create empty Photo image insert or delete
 */
@Serializable
data class PhotoImageInsertOrDeleteResult(
    var user: String = "",
    var photo: String = "",
    var image: String = "",
    var type: Int = -1,
    var result: Boolean = false,
)
