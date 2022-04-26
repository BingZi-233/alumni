package online.bingzi.internal.routes.photo

import io.ktor.server.application.*
import io.ktor.server.request.*
import io.ktor.server.response.*
import io.ktor.server.routing.*
import online.bingzi.internal.entity.request.photo.PhotoUpdate
import online.bingzi.internal.entity.request.photo.PhotoUpdateResult

fun Route.photoUpdate(path: String) {
    post(path) {
        // 将发送过来的JSON进行序列化
        val photoUpdate = call.receive(PhotoUpdate::class)
        // 构建返回对象并对值进行初始化
        val photoUpdateResult = PhotoUpdateResult().apply {
            // 对用户名进行设置
            this.user = photoUpdate.user
            // 对相册UID进行设置
            this.uid = photoUpdate.uid
            // 正则校验相册名是否合法
            this.photo = photoUpdate.photo.matches("^[a-z\\d\u4e00-\u9fa5]+[^_]\$".toRegex())
        }
        // 在数据库中查询相关行
        val queryPhotoByUser = PhotoSession.photoUpdateMapper.queryPhotoByUser(photoUpdate)
        // 设置最终返回结果
        photoUpdateResult.result = if (queryPhotoByUser != null && photoUpdateResult.photo) { // 需要查询结果不为空且相册名验证通过
            // 对涉及的行进行更新
            PhotoSession.photoUpdateMapper.updatePhoto(photoUpdate)
            // 设置提示语句
            photoUpdateResult.info = "用户${photoUpdate.user}的${photoUpdate.uid}相册已更名为${photoUpdate.photo}"
            true
        } else {
            // 设置提示语句
            photoUpdateResult.info = "用户${photoUpdate.user}的${photoUpdate.uid}相册变更失败，相册可能不存在或者相册名验证未通过。"
            false
        }
        // 返回实体并自动转化为JSON类型返回
        call.respond(photoUpdateResult)
    }
}