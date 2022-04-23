package online.bingzi.internal.mapper

interface UserMapper {
    fun insertUser(user: String, password: String): Int
}