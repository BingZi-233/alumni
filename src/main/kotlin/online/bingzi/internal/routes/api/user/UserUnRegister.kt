package online.bingzi.internal.routes.api.user

import io.ktor.server.application.*
import io.ktor.server.request.*
import io.ktor.server.response.*
import io.ktor.server.routing.*
import online.bingzi.internal.entity.ServiceRequest
import online.bingzi.internal.entity.ServiceResult
import online.bingzi.internal.entity.StatusCode.Type.*
import online.bingzi.internal.entity.essentials.EssentialsUserData
import online.bingzi.internal.util.gson
import online.bingzi.internal.util.userMapper

/**
 * Unregister
 * 注销路由
 *
 * @param path Url路径
 */
fun Route.userUnRegister(path: String) {
    post(path) {
        // 接收数据并将其进行序列化
        val serviceRequest = call.receive(ServiceRequest::class)
        // 预构建返回数据
        val serviceResult = ServiceResult()
        // 将从userRequest获取到的数据再次序列化
        val essentialsUserData = gson.fromJson(serviceRequest.data.toString(), EssentialsUserData::class.java)
        // 在数据库中查询该账户是否存在
        val queryUserByUserAndPassword = userMapper.queryUserByUserAndPassword(hashMapOf<String, Any>().apply {
            this["user"] = essentialsUserData.user
            this["password"] = essentialsUserData.password
        })
        // 校验用户数据以及是否在数据库中查询到该用户，并设置状态值
        serviceResult.statusCode.code =
            if (queryUserByUserAndPassword != null) { // 用户不存在，可能是用户名或者密码不正确导致的
                // 将该用户从数据库中进行删除
                userMapper.deleteUserByUserAndPassword(hashMapOf<String, Any>().apply {
                    this["user"] = essentialsUserData.user
                    this["password"] = essentialsUserData.password
                })
                // 返回成功状态码
                OK
            } else {
                // 返回错误状态码
                ERROR
            }
        // 设置返回信息
        serviceResult.statusCode.message = when (serviceResult.statusCode.code) {
            OK -> "验证通过，该账户已删除。"
            ERROR -> "验证失败，该账户不存在。"
            WARING -> "验证失败，该账户或密码错误。"
            UNKNOWN -> "未知错误，程序或已离线！"
        }
        // 对请求进行响应
        call.respond(serviceResult)
    }
}