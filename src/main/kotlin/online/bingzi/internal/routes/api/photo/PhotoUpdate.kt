package online.bingzi.internal.routes.api.photo

import io.ktor.server.application.*
import io.ktor.server.request.*
import io.ktor.server.response.*
import io.ktor.server.routing.*
import online.bingzi.internal.entity.ServiceRequest
import online.bingzi.internal.entity.ServiceResult
import online.bingzi.internal.entity.StatusCode.Type.*
import online.bingzi.internal.util.photoMapper

fun Route.photoUpdate(path: String) {
    post(path) {
        // 接收数据并将其进行序列化
        val serviceRequest = call.receive(ServiceRequest::class)
        // 预构建返回数据
        val serviceResult = ServiceResult()
        // 获取相册UID
        val uid = serviceRequest.data["uid"]
        // 获取照片更新列表
        val photo = serviceRequest.data["photo"]
        // 校验相册UID和照片更新列表参数是否为空，并设置状态值
        serviceResult.statusCode.code = if (uid != null && photo != null) {
            // 从数据库中获取该相册中照片数据并在追加后返回一个包含照片更新列表的列表
            photoMapper.queryPhotoByUid(uid)?.let {
                // 对照片列表进行追加操作
                it.photo = photo
                // 在数据库中进行回写更新
                photoMapper.updatePhoto(it)
                // 返回成功状态码
                OK
            } ?: ERROR // 返回错误状态码
        } else {
            // 返回警告状态码
            WARING
        }
        serviceResult.data["uid"] = uid ?: "null"
        serviceResult.data["photo"] = photo ?: "null"
        // 设置返回信息
        serviceResult.statusCode.message = when (serviceResult.statusCode.code) {
            OK -> "校验通过，相册数据已更新！"
            ERROR -> "校验失败，可能由相册不存在引发异常！"
            WARING -> "校验失败，参数存在空值！"
            UNKNOWN -> "未知错误，程序或已离线！"
        }
        // 对请求进行响应
        call.respond(serviceResult)
    }
}