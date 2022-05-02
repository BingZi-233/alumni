package online.bingzi.internal.mapper

import online.bingzi.internal.entity.essentials.EssentialsRecordData

interface RecordMapper {
    /**
     * Query record by user
     * 通过用查询通讯录
     *
     * @param user 用户
     * @return 通讯录基础数据
     */
    fun queryRecordByUser(user: String): EssentialsRecordData?

    /**
     * Insert record by user
     * 通过用户新建通讯录
     *
     * @param essentialsRecordData 通讯录基础数据
     */
    fun insertRecordByUser(essentialsRecordData: EssentialsRecordData)

    /**
     * Delete record by user
     * 通过用户删除通讯录
     *
     * @param user 用户
     */
    fun deleteRecordByUser(user: String)

    /**
     * Update record by user
     * 通过用户更新数据库
     *
     * @param user 用户
     * @param data 数据
     */
    fun updateRecordByUser(user: String, data: String)
}