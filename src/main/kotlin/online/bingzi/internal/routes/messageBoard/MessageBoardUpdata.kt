package online.bingzi.internal.routes.messageBoard

import com.alibaba.fastjson2.JSONArray
import io.ktor.server.application.*
import io.ktor.server.request.*
import io.ktor.server.response.*
import io.ktor.server.routing.*
import online.bingzi.internal.entity.ServiceRequest
import online.bingzi.internal.entity.ServiceResult
import online.bingzi.internal.entity.StatusCode.Type.*
import online.bingzi.internal.entity.message.MessageData
import online.bingzi.internal.util.gson
import online.bingzi.internal.util.messageMapper

fun Route.messageBoardUpdate(path: String) {
    post(path) {
        // 接收数据并将其进行序列化
        val serviceRequest = call.receive(ServiceRequest::class)
        // 预构建返回数据
        val serviceResult = ServiceResult()
        val user = serviceRequest.data["user"]
        val type = serviceRequest.data["type"]
        val message = serviceRequest.data["message"]
        serviceResult.statusCode.code = if (user != null && type != null && message != null) {
            try {
                val messageDataList = JSONArray.of(message).toJavaList(MessageData::class.java)
                when (type.toIntOrNull() ?: 1) {
                    0 -> {
                        messageMapper.queryMessageByClazz(user)?.let {
                            it.message.addAll(messageDataList)
                            messageMapper.updateMessageByClazz(gson.toJson(it.message), user)
                            OK
                        } ?: ERROR
                    }
                    1 -> {
                        messageMapper.queryMessageByUser(user)?.let {
                            it.message.addAll(messageDataList)
                            messageMapper.updateMessageByUser(gson.toJson(it.message), user)
                            OK
                        } ?: ERROR
                    }
                    else -> ERROR
                }
                OK
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