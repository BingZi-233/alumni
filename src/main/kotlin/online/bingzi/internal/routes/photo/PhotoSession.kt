package online.bingzi.internal.routes.photo

import online.bingzi.internal.mapper.photo.*
import online.bingzi.internal.util.openSession

object PhotoSession {
    val photoCreateMapper: PhotoCreateMapper = openSession.getMapper(PhotoCreateMapper::class.java)
    val photoQueryMapper: PhotoQueryMapper = openSession.getMapper(PhotoQueryMapper::class.java)
    val photoDeleteMapper: PhotoDeleteMapper = openSession.getMapper(PhotoDeleteMapper::class.java)
    val photoUpdateMapper: PhotoUpdateMapper = openSession.getMapper(PhotoUpdateMapper::class.java)
    val photoImageMapper: PhotoImageMapper = openSession.getMapper(PhotoImageMapper::class.java)
}