package online.bingzi.internal.mapper.photo

import online.bingzi.internal.entity.request.photo.PhotoCreate

/**
 * Photo create mapper
 * 相册创建映射器
 *
 * @constructor Create empty Photo create mapper
 */
interface PhotoCreateMapper {
    /**
     * Query user by user
     * 查询用户根据用户名进行
     *
     * @param photoCreate 相册
     * @return 相册列表
     */
    fun queryPhotoByUser(photoCreate: PhotoCreate): List<String>

    /**
     * Insert photo
     *
     * @param photoCreate 相册
     * @return
     */
    fun insertPhoto(photoCreate: PhotoCreate): Void
}