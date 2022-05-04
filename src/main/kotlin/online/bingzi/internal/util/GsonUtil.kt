package online.bingzi.internal.util

import com.google.gson.Gson
import com.google.gson.reflect.TypeToken
import online.bingzi.internal.entity.record.RecordData

/**
 * Gson
 * 通用序列化与反序列化工具
 */
val gson = Gson()

val typeStringList = object : TypeToken<List<String>>() {}.type

val typeRecordData = object : TypeToken<List<RecordData>>() {}.type