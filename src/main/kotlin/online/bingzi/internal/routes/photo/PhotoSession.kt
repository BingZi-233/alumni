package online.bingzi.internal.routes.photo

import online.bingzi.internal.mapper.photo.PhotoCreateMapper
import online.bingzi.internal.mapper.photo.PhotoDeleteMapper
import online.bingzi.internal.mapper.photo.PhotoQueryMapper
import online.bingzi.internal.mapper.photo.PhotoUpdateMapper
import online.bingzi.internal.util.openSession

object PhotoSession {
    val photoCreateMapper: PhotoCreateMapper = openSession.getMapper(PhotoCreateMapper::class.java)
    val photoQueryMapper: PhotoQueryMapper = openSession.getMapper(PhotoQueryMapper::class.java)
    val photoDeleteMapper: PhotoDeleteMapper = openSession.getMapper(PhotoDeleteMapper::class.java)
    val photoUpdateMapper: PhotoUpdateMapper = openSession.getMapper(PhotoUpdateMapper::class.java)
}