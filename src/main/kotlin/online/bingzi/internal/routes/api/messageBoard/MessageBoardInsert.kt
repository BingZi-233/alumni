package online.bingzi.internal.routes.api.messageBoard

import io.ktor.server.application.*
import io.ktor.server.request.*
import io.ktor.server.response.*
import io.ktor.server.routing.*
import online.bingzi.internal.entity.ServiceRequest
import online.bingzi.internal.entity.ServiceResult
import online.bingzi.internal.entity.StatusCode.Type.*
import online.bingzi.internal.entity.essentials.EssentialsMessageBoardData
import online.bingzi.internal.util.messageMapper

fun Route.messageBoardInsert(path: String) {
    post(path) {
        // 接收数据并将其进行序列化
        val serviceRequest = call.receive(ServiceRequest::class)
        // 预构建返回数据
        val serviceResult = ServiceResult()
        // 获取用户
        val user = serviceRequest.data["user"]
        // 获取类型
        val type = serviceRequest.data["type"]
        serviceResult.statusCode.code = if (user != null && type != null) {
            try {
                when (type.toIntOrNull() ?: 1) {
                    0 -> {
                        messageMapper.insertMessageByClazz(EssentialsMessageBoardData(user, 0))
                        OK
                    }
                    1 -> {
                        messageMapper.insertMessageByUser(EssentialsMessageBoardData(user, 1))
                        OK
                    }
                    else -> ERROR
                }
            } catch (e: Exception) {
                ERROR
            }
        } else {
            WARING
        }
        // 设置返回信息
        serviceResult.statusCode.message = when (serviceResult.statusCode.code) {
            OK -> "验证通过，请求数据已返回！"
            ERROR -> "验证失败，可能是由与相册不存在导致引发的异常！"
            WARING -> "验证失败，参数由一个或多个为空！"
            UNKNOWN -> "未知错误，系统或已离线！"
        }
        // 对请求进行响应
        call.respond(serviceResult)

    }
}