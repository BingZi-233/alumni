package online.bingzi.internal.entity

/**
 * User
 *
 * @property user User
 * @property password Password
 * @property clazz Class
 * @constructor Create empty User
 */
data class User(
    val user: String,
    val password: String,
    val clazz: String,
)
