package online.bingzi.internal.entity.essentials

import online.bingzi.internal.entity.record.RecordData

/**
 * Essentials record data
 * 通讯录基础数据
 *
 * @property user 用户
 * @property data 数据
 * @constructor Create empty Essentials record data
 */
data class EssentialsRecordData(
    val user: String,
    val data: MutableList<RecordData> = mutableListOf(),
)
