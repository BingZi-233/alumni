package online.bingzi.internal.routes.photo

import io.ktor.server.application.*
import io.ktor.server.request.*
import io.ktor.server.response.*
import io.ktor.server.routing.*
import online.bingzi.internal.entity.request.photo.PhotoCreate
import online.bingzi.internal.entity.request.photo.PhotoCreateResult
import online.bingzi.internal.routes.photo.PhotoSession.photoCreateMapper

fun Route.photoCreate(path: String) {
    post(path) {
        // 将发送过来的JSON进行序列化
        val photoCreate = call.receive(PhotoCreate::class)
        // 构建返回对象并对值进行初始化
        val photoCreateResult = PhotoCreateResult().apply {
            // 正则校验账户名是否合法
            this.user = photoCreate.user.matches("^[a-zA-Z\\d_-]{2,15}$".toRegex())
            // 正则校验相册名是否合法
            this.photo = photoCreate.photo.matches("^[a-z\\d\u4e00-\u9fa5]+[^_]\$".toRegex())
            // 根据上面判断返回值，此刻并不是最终返回值
            this.result = user && photo
            // 构建提示语句
            this.info = if (result) "验证均已通过" else "部分验证未通过，请检查参数是否正确。"
        }
        // 从数据中查询用户是否已超出了最大数据库上限，这里使用kotlin特有的范围检测
        if (photoCreateMapper.queryPhotoByUser(photoCreate).size in 0..2) {
            // 将相册插入到数据中
            photoCreateMapper.insertPhoto(photoCreate)
            // 构建提示语句
            photoCreateResult.info = "用户${photoCreate.user}的相册${photoCreate.photo}创建成功！uid=${photoCreate.uid}"
        } else {
            // 构建提示语句
            photoCreateResult.info = "用户相册数已超过最大值，请先删除相册后再次尝试。"
        }
        // 返回实体并自动转化为JSON类型返回
        call.respond(photoCreateResult)
    }
}