package online.bingzi.internal.mapper.photo

import online.bingzi.internal.entity.request.photo.PhotoDelete

/**
 * Photo create mapper
 * 相册创建映射器
 *
 * @constructor Create empty Photo create mapper
 */
interface PhotoDeleteMapper {
    /**
     * Query user by user
     * 查询用户根据用户名进行
     *
     * @param photoDelete 相册
     * @return 相册列表
     */
    fun queryPhotoByUser(photoDelete: PhotoDelete): PhotoDelete?

    /**
     * Delete photo
     *
     * @param photoDelete 相册
     * @return
     */
    fun deletePhoto(photoDelete: PhotoDelete): Void
}