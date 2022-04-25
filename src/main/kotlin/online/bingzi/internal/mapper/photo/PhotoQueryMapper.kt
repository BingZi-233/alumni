package online.bingzi.internal.mapper.photo

import online.bingzi.internal.entity.request.photo.Photo
import online.bingzi.internal.entity.request.photo.PhotoQuery

/**
 * Photo create mapper
 * 相册创建映射器
 *
 * @constructor Create empty Photo create mapper
 */
interface PhotoQueryMapper {
    /**
     * Query user by user
     * 查询用户根据用户名进行
     *
     * @param photoQuery 相册
     * @return 相册列表
     */
    fun queryPhotoByUser(photoQuery: PhotoQuery): List<Photo>
}