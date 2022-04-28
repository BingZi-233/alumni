package online.bingzi.internal.mapper.photo

import online.bingzi.internal.entity.request.photo.Image
import online.bingzi.internal.entity.request.photo.PhotoImageInsertOrDelete
import online.bingzi.internal.entity.request.photo.PhotoImageQuery

/**
 * Photo image mapper
 * 相册内图片集中映射器
 *
 * @constructor Create empty Photo image mapper
 */
interface PhotoImageMapper {
    /**
     * Insert image by photo
     * 插入图片到相册内
     *
     * @param photoImageInsertOrDelete 相册UID以及图片地址
     */
    fun insertImageByPhoto(photoImageInsertOrDelete: PhotoImageInsertOrDelete)

    /**
     * Delete image by photo
     * 删除图片从相册内
     *
     * @param photoImageInsertOrDelete 相册UID以及图片地址
     */
    fun deleteImageByPhoto(photoImageInsertOrDelete: PhotoImageInsertOrDelete)

    /**
     * Query image by photo
     * 查询图片从相册内
     *
     * @param photoImageQuery 相册UID
     * @return 相册内照片资源列表
     */
    fun queryImageByPhoto(photoImageQuery: PhotoImageQuery): List<Image>
}