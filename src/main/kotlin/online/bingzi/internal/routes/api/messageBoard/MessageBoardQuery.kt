package online.bingzi.internal.routes.api.messageBoard

import io.ktor.server.application.*
import io.ktor.server.request.*
import io.ktor.server.response.*
import io.ktor.server.routing.*
import online.bingzi.internal.entity.ServiceRequest
import online.bingzi.internal.entity.ServiceResult
import online.bingzi.internal.entity.StatusCode.Type.*
import online.bingzi.internal.util.gson
import online.bingzi.internal.util.messageMapper

fun Route.messageBoardQuery(path: String) {
    post(path) {
        // 接收数据并将其进行序列化
        val serviceRequest = call.receive(ServiceRequest::class)
        // 预构建返回数据
        val serviceResult = ServiceResult()
        // 获取用户
        val user = serviceRequest.data["user"]
        // 获取类型
        val type = serviceRequest.data["type"]
        // 校验用户和类型参数是否为空，并设置状态值
        serviceResult.statusCode.code = if (user != null && type != null) {
            // 类型推断 0-班级，1-个人
            when (type.toIntOrNull() ?: 1) {
                0 -> {
                    // 从数据库中查询
                    messageMapper.queryMessageByClazz(user)?.let {
                        // 查询到之后设置返回数据，由GSON负责将对象进行序列化
                        serviceResult.data["messageBoard"] = gson.toJson(it)
                        // 返回成功状态码
                        OK
                    } ?: ERROR // 返回错误状态码
                }
                1 -> {
                    messageMapper.queryMessageByUser(user)?.let {
                        // 查询到之后设置返回数据，由GSON负责将对象进行序列化
                        serviceResult.data["messageBoard"] = gson.toJson(it)
                        // 返回成功状态码
                        OK
                    } ?: ERROR // 返回错误状态码
                }
                else -> ERROR // 返回错误状态码
            }
        } else {
            WARING // 返回警告状态码
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