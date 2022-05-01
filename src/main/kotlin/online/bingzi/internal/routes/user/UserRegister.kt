package online.bingzi.internal.routes.user

import com.alibaba.fastjson2.JSONObject
import io.ktor.server.application.*
import io.ktor.server.request.*
import io.ktor.server.response.*
import io.ktor.server.routing.*
import online.bingzi.internal.entity.StatusCode.Type.*
import online.bingzi.internal.entity.request.user.EssentialsUserData
import online.bingzi.internal.entity.request.user.UserRequest
import online.bingzi.internal.entity.request.user.UserResult

/**
 * Register
 * 注册路由
 *
 * @param path Url路径
 */
fun Route.userRegister(path: String) {
    post(path) {
        // 接收数据并将其进行序列化
        val userRequest = call.receive(UserRequest::class)
        // 预构建返回数据
        val userResult = UserResult()
        // 将从userRequest获取到的数据再次序列化
        val essentialsUserData = JSONObject.parseObject(userRequest.data.toString(), EssentialsUserData::class.java)
        // 在数据库中查询该账户是否被注册
        userMapper.queryUserByUser(essentialsUserData.user)?.let {
            // 如果查询到了该用户，则状态码变更为警告
            userResult.statusCode.code = WARING
        }
        // 校验用户数据以及是否在数据库中查询到该用户，并设置状态值
        userResult.statusCode.code =
            if (userResult.statusCode.code != WARING) { // 该用户已在数据中被注册
                if (essentialsUserData.hasLegitimate()) { // 用户数据校验是否通过
                    // 将该用户插入到数据库中保存
                    userMapper.insertUser(essentialsUserData)
                    // 返回成功状态码
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
        userResult.statusCode.message = when (userResult.statusCode.code) {
            OK -> "验证通过，该用户已更新至数据库中！"
            ERROR -> "验证失败，数据库中已存在该用户。"
            WARING -> "验证失败，该用户数据校验未通过。"
            UNKNOWN -> "未知错误，程序或已离线！"
        }
        // 对请求进行响应
        call.respond(userResult)
    }
}