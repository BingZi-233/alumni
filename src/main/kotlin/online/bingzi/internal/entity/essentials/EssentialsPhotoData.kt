package online.bingzi.internal.entity.essentials

import java.util.*

/**
 * Essentials photo
 *
 * @property user 用户（指这个相册属于谁）
 * @property photo 相册名
 * @property uid 相册唯一ID，UUID格式
 * @property image 资源列表（这里参考了阿里云盘，没有照片名）
 * @constructor Create empty Essentials photo
 */
@kotlinx.serialization.Serializable
data class EssentialsPhotoData(
    var user: String = "",
    var photo: String = "",
    var uid: String = UUID.randomUUID().toString(),
    var image: MutableList<String> = mutableListOf(),
) {
    /**
     * Has user
     * 验证账户是否合法
     *
     * @return true-合法，false-不合法
     */
    fun hasUser(user: String? = null): Boolean {
        val regex = Regex(pattern = "^[a-zA-Z\\d_-]{2,15}\$")
        return if (user != null) {
            regex.matches(user)
        } else {
            regex.matches(this.user)
        }
    }

    /**
     * Has photo
     * 验证相册名是否合法
     *
     * @param photo 相册名
     * @return true-合法，false-不合法
     */
    fun hasPhoto(photo: String? = null): Boolean {
        val regex = Regex(pattern = "^[a-z\\d\u4e00-\u9fa5]+[^_]{2,15}\$")
        return if (photo != null) {
            regex.matches(photo)
        } else {
            regex.matches(this.photo)
        }
    }

    /**
     * Has legitimate
     * 验证用户所有数据是否合法
     *
     * @return true-合法，false-不合法
     */
    fun hasLegitimate(user: String? = null, password: String? = null, username: String? = null, clazz: String? = null): Boolean {
        return hasUser(user) && hasPhoto()
    }
}
