package online.bingzi.internal.routes.photo

import io.ktor.server.application.*
import io.ktor.server.request.*
import io.ktor.server.response.*
import io.ktor.server.routing.*
import online.bingzi.internal.entity.ServiceRequest
import online.bingzi.internal.entity.ServiceResult
import online.bingzi.internal.entity.StatusCode.Type.*
import online.bingzi.internal.util.photoMapper

fun Route.photoDelete(path: String) {
    post(path) {
        // 接收数据并将其进行序列化
        val serviceRequest = call.receive(ServiceRequest::class)
        // 预构建返回数据
        val serviceResult = ServiceResult()
        // 获取相册UID
        val uid = serviceRequest.data["uid"]
        // 校验相册UID参数是否为空，并设置状态值
        serviceResult.statusCode.code = if (uid != null) {
            // 语法糖，在数据库中查询相册是否存在。
            // 如果存在执行let{ }内的代码，不存在则将?:后的ERROR返回
            photoMapper.queryPhotoByUid(uid)?.let {
                // 在数据库中对该UID行进行删除
                photoMapper.deletePhoto(it)
                // 返回成功状态码
                OK
            } ?: ERROR // 返回错误状态码
        } else {
            // 返回警告状态码
            WARING
        }
        // 设置返回信息
        serviceResult.statusCode.message = when (serviceResult.statusCode.code) {
            OK -> "校验通过，相册已删除！"
            ERROR -> "校验失败，相册不存在！"
            WARING -> "校验失败，参数缺失！"
            UNKNOWN -> "未知错误，程序或已离线！"
        }
        // 对请求进行响应
        call.respond(serviceResult)
    }
}