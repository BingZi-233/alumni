package online.bingzi.internal.routes.photo

import io.ktor.server.application.*
import io.ktor.server.request.*
import io.ktor.server.response.*
import io.ktor.server.routing.*
import online.bingzi.internal.entity.ServiceRequest
import online.bingzi.internal.entity.ServiceResult
import online.bingzi.internal.entity.StatusCode.Type.OK
import online.bingzi.internal.entity.StatusCode.Type.WARING
import online.bingzi.internal.util.gson
import online.bingzi.internal.util.photoMapper

fun Route.photoQuery(path: String) {
    post(path) {
        // 接收数据并将其进行序列化
        val serviceRequest = call.receive(ServiceRequest::class)
        // 预构建返回数据
        val serviceResult = ServiceResult()
        // 获取用户
        val user = serviceRequest.data["user"]
        // 校验用户参数是否为空，并设置状态值
        serviceResult.statusCode.code = if (user != null) {
            // 从数据库中获取用户名下所有下相册
            val queryPhotoByUser = photoMapper.queryPhotoByUser(user)
            // 设置返回携带的数据，这里使用JSONArray进行序列化
            serviceResult.data["photo"] = gson.toJson(queryPhotoByUser)
            // 返回成功状态码
            OK
        } else {
            // 返回警告状态码
            WARING
        }
        // 对请求进行响应
        call.respond(serviceResult)
    }
}