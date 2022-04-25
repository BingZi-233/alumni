package online.bingzi.internal.mapper.photo

import online.bingzi.internal.entity.request.photo.PhotoUpdate

/**
 * Photo create mapper
 * 相册创建映射器
 *
 * @constructor Create empty Photo create mapper
 */
interface PhotoUpdateMapper {
    /**
     * Query user by user
     * 查询用户根据用户名进行
     *
     * @param photoUpdate 相册
     * @return 相册
     */
    fun queryPhotoByUser(photoUpdate: PhotoUpdate): PhotoUpdate

    /**
     * Update photo
     * 更新用户的相册名
     *
     * @param photoUpdate 相册
     * @return
     */
    fun updatePhoto(photoUpdate: PhotoUpdate): Void
}