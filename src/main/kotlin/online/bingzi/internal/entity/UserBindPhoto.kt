package online.bingzi.internal.entity

import java.util.*

/**
 * User bind photo
 * 用户相册关联
 *
 * @property user 用户
 * @property photo 相册
 * @constructor Create empty User bind photo
 */
data class UserBindPhoto(
    val user: UUID,
    val photo: UUID,
)
