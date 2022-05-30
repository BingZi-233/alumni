package online.bingzi.internal.routes.api.photo

import io.ktor.server.application.*
import io.ktor.server.request.*
import io.ktor.server.response.*
import io.ktor.server.routing.*
import online.bingzi.internal.entity.ServiceRequest
import online.bingzi.internal.entity.ServiceResult
import online.bingzi.internal.entity.StatusCode.Type.*
import online.bingzi.internal.util.gson
import online.bingzi.internal.util.photoMapper
import online.bingzi.internal.util.typeStringList

fun Route.photoImageDelete(path: String) {
    post(path) {
        // 接收数据并将其进行序列化
        val serviceRequest = call.receive(ServiceRequest::class)
        // 预构建返回数据
        val serviceResult = ServiceResult()
        // 获取相册UID
        val uid = serviceRequest.data["uid"]
        // 获取照片更新列表
        val image = serviceRequest.data["image"]
        // 校验相册UID和照片更新列表参数是否为空，并设置状态值
        serviceResult.statusCode.code = if (uid != null && image != null) {
            // 这里进行了异常捕捉，因为JSONArray在序列化的时候可能引发异常导致无法正常返回数据。
            try {
                // 将照片更新列表进行序列化
                val imageDeleteList = gson.fromJson<MutableList<String>>(image, typeStringList)
                // 从数据库中获取该相册中照片数据并在追加后返回一个包含照片更新列表的列表
                photoMapper.queryPhotoByUid(uid)?.let {
                    println("相册内图片删除前结果为" + it.image + " 即将要删除的列表为" + imageDeleteList)
                    // 对照片列表进行删除操作
                    it.deleteImageList(imageDeleteList)
                    println("相册内的图片在删除后的结果" + it.image)
                    // 在数据库中进行回写更新
                    photoMapper.updatePhotoFine(hashMapOf<String, String>().apply {
                        this["uid"] = uid
                        this["image"] = it.image
                    })
                    // 返回包含照片更新列表的所有列表
                } ?: RuntimeException("") // 如果为空直接引发异常，由上层异常捕捉进行处理
                // 返回成功状态码
                OK
            } catch (e: Exception) {
                // 如果发生了任何异常，都返回错误状态码
                ERROR
            }
        } else {
            // 返回警告状态码
            WARING
        }
        // 设置返回信息
        serviceResult.statusCode.message = when (serviceResult.statusCode.code) {
            OK -> "校验通过，指定的照片已删除！"
            ERROR -> "校验失败，可能由image参数格式错误或相册不存在引发异常！"
            WARING -> "校验失败，参数存在空值！"
            UNKNOWN -> "未知错误，程序或已离线！"
        }
        // 对请求进行响应
        call.respond(serviceResult)
    }
}