package online.bingzi.internal.mapper.photo

import online.bingzi.internal.entity.photo.EssentialsPhotoData

/**
 * Photo create mapper
 * 相册创建映射器
 *
 * @constructor Create empty Photo create mapper
 */
interface PhotoMapper {
    fun queryPhotoByPhoto(photo: String): EssentialsPhotoData?
    fun queryPhotoByUser(user: String): EssentialsPhotoData?
    fun queryPhotoByUserAndPhoto(photo: String, user: String): EssentialsPhotoData?
    fun insertPhoto()
    fun deletePhoto()
    fun updatePhoto()
}