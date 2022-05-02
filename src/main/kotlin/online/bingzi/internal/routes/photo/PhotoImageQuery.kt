package online.bingzi.internal.routes.photo

import io.ktor.server.application.*
import io.ktor.server.request.*
import io.ktor.server.response.*
import io.ktor.server.routing.*
import online.bingzi.internal.entity.ServiceRequest
import online.bingzi.internal.entity.ServiceResult
import online.bingzi.internal.entity.StatusCode.Type.*
import online.bingzi.internal.util.gson
import online.bingzi.internal.util.photoMapper

fun Route.photoImageQuery(path: String) {
    post(path) {
        // 接收数据并将其进行序列化
        val serviceRequest = call.receive(ServiceRequest::class)
        // 预构建返回数据
        val serviceResult = ServiceResult()
        val uid = serviceRequest.data["uid"]
        serviceResult.statusCode.code = if (uid != null) {
            photoMapper.queryPhotoByUid(uid)?.let {
                serviceResult.data["image"] = gson.toJson(it.image)
                OK
            } ?: ERROR
        } else {
            WARING
        }
        // 设置返回信息
        serviceResult.statusCode.message = when (serviceResult.statusCode.code) {
            OK -> "校验通过，照片列表已返回！"
            ERROR -> "校验失败，可能由相册不存在引发异常！"
            WARING -> "校验失败，参数存在空值！"
            UNKNOWN -> "未知错误，程序或已离线！"
        }
        // 对请求进行响应
        call.respond(serviceResult)
    }
}