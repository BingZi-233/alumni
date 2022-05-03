package online.bingzi.internal.entity.essentials

/**
 * Essentials user data
 * 用户基础数据类
 *
 * @property user 账户
 * @property password 密码
 * @property username 账户名
 * @property clazz 班级
 * @constructor Create empty Essentials user data
 */
@kotlinx.serialization.Serializable
data class EssentialsUserData(
    var user: String = "",
    var password: String = "",
    var username: String = "",
    var clazz: String = "",
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
     * Has password
     * 验证密码是否合法
     *
     * @return true-合法，false-不合法
     */
    fun hasPassword(password: String? = null): Boolean {

        val regex = Regex(pattern = "^(?!\\d+\$)(?![a-zA-Z]+\$)[\\dA-Za-z]{6,15}\$")
        return if (password != null) {
            regex.matches(password)
        } else {
            regex.matches(this.password)
        }
    }

    /**
     * Has user name
     * 验证账户名是否合法
     *
     * @return true-合法，false-不合法
     */
    fun hasUserName(username: String? = null): Boolean {
        val regex = Regex(pattern = "^[\u4e00-\u9fa5]{2,4}\$")
        return if (username != null) {
            regex.matches(username)
        } else {
            regex.matches(this.username)
        }
    }

    /**
     * Has clazz
     * 验证班级是否合法
     *
     * @return true-合法，false-不合法
     */
    fun hasClazz(clazz: String? = null): Boolean {
        val regex = Regex(pattern = "^[a-zA-Z\\d_-]{2,15}\$")
        return if (clazz != null) {
            regex.matches(clazz)
        } else {
            regex.matches(this.clazz)
        }
    }

    /**
     * Has legitimate
     * 验证用户所有数据是否合法
     *
     * @return true-合法，false-不合法
     */
    fun hasLegitimate(user: String? = null, password: String? = null, username: String? = null, clazz: String? = null): Boolean {
        return hasUser(user) && hasPassword(password) && hasUserName(username) && hasClazz(clazz)
    }

    /**
     * Auth login
     *
     * @param user 账户
     * @param password 密码
     * @return true-通过，false-未通过
     */
    fun authLogin(user: String, password: String): Boolean {
        return this.user == user && this.password == password
    }
}
