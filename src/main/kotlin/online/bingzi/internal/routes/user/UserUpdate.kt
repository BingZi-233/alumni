package online.bingzi.internal.routes.user

import com.alibaba.fastjson2.JSONObject
import io.ktor.server.application.*
import io.ktor.server.request.*
import io.ktor.server.response.*
import io.ktor.server.routing.*
import online.bingzi.internal.entity.ServiceRequest
import online.bingzi.internal.entity.ServiceResult
import online.bingzi.internal.entity.StatusCode.Type.*
import online.bingzi.internal.entity.user.EssentialsUserData
import online.bingzi.internal.util.userMapper

/**
 * User update
 * 更新路由
 *
 * @param path Url路径
 */
fun Route.userUpdate(path: String) {
    post(path) {
        // 接收数据并将其进行序列化
        val serviceRequest = call.receive(ServiceRequest::class)
        // 预构建返回数据
        val serviceResult = ServiceResult()
        // 将从userRequest获取到的数据再次序列化
        val essentialsUserData = JSONObject.parseObject(serviceRequest.data.toString(), EssentialsUserData::class.java)
        // 在数据库中查询该账户是否存在
        val queryUserByUser = userMapper.queryUserByUser(essentialsUserData.user)
        // 校验用户数据以及是否在数据库中查询到该用户，并设置状态值
        serviceResult.statusCode.code =
            if (queryUserByUser != null) { // 查询到用户
                if (essentialsUserData.hasLegitimate()) { // 用户数据校验通过
                    // 更新数据库中的数据
                    userMapper.updateUser(essentialsUserData)
                    // 返回完成状态码
                    OK
                } else {
                    // 返回警告状态码
                    WARING
                }
            } else {
                // 返回错误状态码
                ERROR
            }
        // 设置返回信息
        serviceResult.statusCode.message = when (serviceResult.statusCode.code) {
            OK -> "验证成功，用户资料已经更新！"
            ERROR -> "验证失败，该用户不存在。"
            WARING -> "验证失败，该用户校验未通过。"
            UNKNOWN -> "未知错误，程序或已离线。"
        }
        // 对请求进行响应
        call.respond(serviceResult)
    }
}