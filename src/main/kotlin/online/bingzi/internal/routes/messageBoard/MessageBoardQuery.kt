package online.bingzi.internal.routes.messageBoard

import io.ktor.server.application.*
import io.ktor.server.request.*
import io.ktor.server.response.*
import io.ktor.server.routing.*
import online.bingzi.internal.entity.ServiceRequest
import online.bingzi.internal.entity.ServiceResult

fun Route.messageBoardQuery(path: String) {
    post(path) {
        // 接收数据并将其进行序列化
        val serviceRequest = call.receive(ServiceRequest::class)
        // 预构建返回数据
        val serviceResult = ServiceResult()
        val user = serviceRequest.data["user"]
        // 对请求进行响应
        call.respond(serviceResult)
    }
}