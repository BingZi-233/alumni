package online.bingzi.internal.mapper

import online.bingzi.internal.entity.essentials.EssentialsRecordData

interface RecordMapper {
    fun queryRecordByUser(user: String): EssentialsRecordData?
    fun insertRecordByUser(essentialsRecordData: EssentialsRecordData)
    fun deleteRecordByUser(user: String)
    fun updateRecordByUser(user: String, data: String)
}