package online.bingzi.internal.routes.photo

import io.ktor.server.application.*
import io.ktor.server.request.*
import io.ktor.server.response.*
import io.ktor.server.routing.*
import online.bingzi.internal.entity.request.photo.PhotoImageQuery
import online.bingzi.internal.entity.request.photo.PhotoImageQueryResult
import online.bingzi.internal.entity.request.photo.PhotoQuery
import online.bingzi.internal.routes.photo.PhotoSession.photoImageMapper
import online.bingzi.internal.routes.photo.PhotoSession.photoQueryMapper

fun Route.photoImageQuery(path: String) {
    post(path) {
        // 将发送过来的JSON进行序列化
        val photoImageQuery = call.receive(PhotoImageQuery::class)
        // 构建返回对象并对值进行初始化
        val photoImageQueryResult = PhotoImageQueryResult().apply {
            // 用户
            this.user = photoImageQuery.user
            // 相册uid
            this.photo = photoImageQuery.photo
            // 在数据中检索是否存在该相册，map语法糖将list对象统一进行格式转换
            if (photoQueryMapper.queryPhotoByUser(PhotoQuery(photoImageQuery.user)).map { photo -> photo.uid }.contains(photoImageQuery.photo)) {
                // 在相册数据库内搜索相关资源
                this.imageMutableList.addAll(photoImageMapper.queryImageByPhoto(photoImageQuery))
            }
        }
        // 返回实体并自动转化为JSON类型返回
        call.respond(photoImageQueryResult)
    }
}