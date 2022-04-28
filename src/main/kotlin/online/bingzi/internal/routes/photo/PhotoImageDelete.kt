package online.bingzi.internal.routes.photo

import io.ktor.server.application.*
import io.ktor.server.request.*
import io.ktor.server.response.*
import io.ktor.server.routing.*
import online.bingzi.internal.entity.request.photo.PhotoImageInsertOrDelete
import online.bingzi.internal.entity.request.photo.PhotoImageInsertOrDeleteResult
import online.bingzi.internal.entity.request.photo.PhotoImageQuery
import online.bingzi.internal.entity.request.photo.PhotoQuery
import online.bingzi.internal.routes.photo.PhotoSession.photoImageMapper
import online.bingzi.internal.routes.photo.PhotoSession.photoQueryMapper

fun Route.photoImageDelete(path: String) {
    post(path) {
        val photoImageInsertOrDelete = call.receive(PhotoImageInsertOrDelete::class)
        val photoImageInsertOrDeleteResult = PhotoImageInsertOrDeleteResult().apply {
            this.user = photoImageInsertOrDelete.user
            this.photo = photoImageInsertOrDelete.photo
            this.image = photoImageInsertOrDelete.image
            this.type = photoImageInsertOrDelete.type
        }
        when (photoImageInsertOrDelete.type) {
            0 -> {
                // 查询用户名下相册是否存在
                if (photoQueryMapper.queryPhotoByUser(PhotoQuery(photoImageInsertOrDelete.user)).map { it.uid }
                        .contains(photoImageInsertOrDelete.photo)) {
                    // 查询相册内照片是否存在
                    if (photoImageMapper.queryImageByPhoto(PhotoImageQuery(photoImageInsertOrDelete.user, photoImageInsertOrDelete.photo))
                            .map { it.image }.contains(photoImageInsertOrDelete.image)
                    ) {
                        photoImageMapper.deleteImageByPhoto(photoImageInsertOrDelete)
                        photoImageInsertOrDeleteResult.result = true
                    }
                }
            }
        }
        call.respond(photoImageInsertOrDeleteResult)
    }
}