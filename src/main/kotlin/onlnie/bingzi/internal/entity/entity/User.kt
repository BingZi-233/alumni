package onlnie.bingzi.internal.entity.entity

/**
 * User
 *
 * @property user User Name
 * @property password Password
 * @property clazz Class
 * @constructor Create empty User
 */
data class User(
    var user: String,
    var password: String,
    var clazz: String,
) {
}
