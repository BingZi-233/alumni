package online.bingzi.internal.entity

import java.util.*

/**
 * Photo album
 * 相册
 *
 * @property name 相册名
 * @property mutableList 资源列表
 * @constructor Create empty Photo album
 */
data class PhotoAlbum(
    var name: UUID = UUID.randomUUID(),
    var mutableList: MutableList<String> = mutableListOf(),
)
