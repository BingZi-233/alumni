package online.bingzi.internal.routes.photo

import io.ktor.server.application.*
import io.ktor.server.request.*
import io.ktor.server.response.*
import io.ktor.server.routing.*
import online.bingzi.internal.entity.request.photo.PhotoQuery
import online.bingzi.internal.entity.request.photo.PhotoQueryResult

fun Route.photoQuery(path: String) {
    post(path) {
        // 将发送过来的JSON进行序列化
        val photoQuery = call.receive(PhotoQuery::class)
        // 从数据库中查询用户名下的相册，并构建List进行返回
        val photoList = PhotoSession.photoQueryMapper.queryPhotoByUser(photoQuery)
        // 构建返回对象并对值进行初始化
        val photoQueryResult = PhotoQueryResult().apply {
            // 设置用户名
            this.user = photoQuery.user
            // 设置相册列表
            this.photoMutableList.addAll(photoList)
        }
        // 返回实体并自动转化为JSON类型返回
        call.respond(photoQueryResult)
    }
}