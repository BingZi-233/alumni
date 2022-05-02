package online.bingzi.internal.routes.photo

import io.ktor.server.application.*
import io.ktor.server.request.*
import io.ktor.server.response.*
import io.ktor.server.routing.*
import online.bingzi.internal.entity.ServiceRequest
import online.bingzi.internal.entity.ServiceResult
import online.bingzi.internal.entity.StatusCode.Type.*
import online.bingzi.internal.entity.essentials.EssentialsPhotoData
import online.bingzi.internal.util.photoMapper

fun Route.photoCreate(path: String) {
    post(path) {
        // 接收数据并将其进行序列化
        val serviceRequest = call.receive(ServiceRequest::class)
        // 预构建返回数据
        val serviceResult = ServiceResult()
        // 获取用户
        val user = serviceRequest.data["user"]
        // 获取相册名
        val photo = serviceRequest.data["photo"]
        // 校验用户和相册名参数是否为空，并设置状态值
        serviceResult.statusCode.code = if (user != null && photo != null) {
            // 在数据库中查询相册数量
            if (photoMapper.queryPhotoByUser(user).size <= 3) {
                // 构建相册基本数据
                val essentialsPhotoData = EssentialsPhotoData(user, photo)
                // 校验相册基本数据是否合法
                if (essentialsPhotoData.hasLegitimate()) {
                    // 在数据库中插入该相册
                    photoMapper.insertPhoto(essentialsPhotoData)
                    // 返回成功状态码
                    OK
                } else {
                    // 返回错误状态码
                    ERROR
                }
            } else {
                // 返回错误状态码
                ERROR
            }
        } else {
            // 返回警告状态码
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