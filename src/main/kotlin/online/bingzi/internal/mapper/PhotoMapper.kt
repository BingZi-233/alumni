package online.bingzi.internal.mapper

import online.bingzi.internal.entity.essentials.EssentialsPhotoData

/**
 * Photo create mapper
 * 相册创建映射器
 *
 * @constructor Create empty Photo create mapper
 */
interface PhotoMapper {
    /**
     * Query photo by uid
     * 根据相册UID查询相册
     * @param uid 相册UID
     * @return 相册基本数据
     */
    fun queryPhotoByUid(uid: String): EssentialsPhotoData?

    /**
     * Query photo by user
     * 根据用户查询名下相册
     * @param user 用户
     * @return 相册基本数据
     */
    fun queryPhotoByUser(user: String): List<EssentialsPhotoData>

    /**
     * Query photo by user and uid
     * 根据用户和相册UID来查询相册
     *
     * @param uid 相册UID
     * @param user 用户
     * @return 相册基本数据
     */
    fun queryPhotoByUserAndUid(uid: String, user: String): EssentialsPhotoData?

    /**
     * Insert photo
     * 新建相册
     *
     * @param essentialsPhotoData 相册基本数据
     */
    fun insertPhoto(essentialsPhotoData: EssentialsPhotoData)

    /**
     * Delete photo
     * 删除相册
     *
     * @param essentialsPhotoData 相册基本数据
     */
    fun deletePhoto(essentialsPhotoData: EssentialsPhotoData)

    /**
     * Update photo
     * 更新相册
     *
     * @param essentialsPhotoData 相册基本数据
     */
    fun updatePhoto(essentialsPhotoData: EssentialsPhotoData)

    /**
     * Update photo fine
     * 更新相册-精细
     *
     */
    fun updatePhotoFine(map: HashMap<String, String>)
}