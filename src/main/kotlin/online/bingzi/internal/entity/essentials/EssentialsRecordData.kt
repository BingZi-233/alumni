package online.bingzi.internal.entity.essentials

import online.bingzi.internal.entity.record.RecordData
import online.bingzi.internal.util.gson
import online.bingzi.internal.util.typeRecordData

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
    var data: String = "",
) {
    fun getDataList(): MutableList<RecordData> {
        return gson.fromJson<MutableList<RecordData>>(data, typeRecordData) ?: mutableListOf()
    }

    fun setDataList(dataList: MutableList<RecordData>) {
        this.data = gson.toJson(dataList)
    }

    fun addDataList(dataList: MutableList<RecordData>) {
        val recordDataMutableList = getDataList()
        recordDataMutableList.addAll(dataList)
        setDataList(recordDataMutableList)
    }
}
