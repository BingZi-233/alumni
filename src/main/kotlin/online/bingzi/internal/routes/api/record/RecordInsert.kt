package online.bingzi.internal.routes.api.record

import io.ktor.server.application.*
import io.ktor.server.request.*
import io.ktor.server.response.*
import io.ktor.server.routing.*
import online.bingzi.internal.entity.ServiceRequest
import online.bingzi.internal.entity.ServiceResult
import online.bingzi.internal.entity.StatusCode.Type.*
import online.bingzi.internal.entity.essentials.EssentialsRecordData
import online.bingzi.internal.util.recordMapper

fun Route.recordInsert(path: String) {
    post(path) {
        // 接收数据并将其进行序列化
        val serviceRequest = call.receive(ServiceRequest::class)
        // 预构建返回数据
        val serviceResult = ServiceResult()
        val user = serviceRequest.data["user"]
        serviceResult.statusCode.code = if (user != null) {
            recordMapper.queryRecordByUser(user)?.let {
                ERROR
            }
            recordMapper.insertRecordByUser(EssentialsRecordData(user))
            OK
        } else {
            WARING
        }
        // 设置返回信息
        serviceResult.statusCode.message = when (serviceResult.statusCode.code) {
            OK -> "校验通过，相册已创建！"
            ERROR -> "校验失败，参数留空！"
            WARING -> "校验失败，相册达到上限或参数格式错误！"
            UNKNOWN -> "未知错误，程序或已离线！"
        }
        // 对请求进行响应
        call.respond(serviceResult)
    }
}