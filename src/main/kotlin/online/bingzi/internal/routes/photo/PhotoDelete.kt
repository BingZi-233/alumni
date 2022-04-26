package online.bingzi.internal.routes.photo

import io.ktor.server.application.*
import io.ktor.server.request.*
import io.ktor.server.response.*
import io.ktor.server.routing.*
import online.bingzi.internal.entity.request.photo.PhotoDelete
import online.bingzi.internal.entity.request.photo.PhotoDeleteResult

fun Route.photoDelete(path: String) {
    post(path) {
        // 将发送过来的JSON进行序列化
        val photoDelete = call.receive(PhotoDelete::class)
        // 构建返回对象并对值进行初始化
        val photoDeleteResult = PhotoDeleteResult().apply {
            // 对用户名进行设置
            this.user = photoDelete.user
            // 对相册UID进行设置
            this.uid = photoDelete.uid
        }
        // 在数据库中查询该相册是否存在
        val queryPhotoByUser = PhotoSession.photoDeleteMapper.queryPhotoByUser(photoDelete)
        photoDeleteResult.result = if (queryPhotoByUser != null) { // 当相册存在时
            // 从数据库中删除这个相册
            PhotoSession.photoDeleteMapper.deletePhoto(photoDelete)
            // 构建提示语句
            photoDeleteResult.info = "已将用户${photoDelete.user}的${photoDelete.uid}相册删除。"
            true
        } else {
            // 构建提示语句
            photoDeleteResult.info = "用户${photoDelete.user}的${photoDelete.uid}相册不存在。"
            false
        }
        // 返回实体并自动转化为JSON类型返回
        call.respond(photoDeleteResult)
    }
}