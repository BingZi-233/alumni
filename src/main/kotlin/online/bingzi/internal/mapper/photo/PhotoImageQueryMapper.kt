package online.bingzi.internal.mapper.photo

import online.bingzi.internal.entity.request.photo.Image
import online.bingzi.internal.entity.request.photo.PhotoImageQuery

/**
 * Photo image query mapper
 * 相册照片映射器
 *
 * @constructor Create empty Photo image query mapper
 */
interface PhotoImageQueryMapper {
    /**
     * Query image by photo
     *
     * @param photoImageQuery 相册UID
     * @return 相册内照片资源列表
     */
    fun queryImageByPhoto(photoImageQuery: PhotoImageQuery): List<Image>
}