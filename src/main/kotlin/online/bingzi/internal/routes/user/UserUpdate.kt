package online.bingzi.internal.routes.user

import io.ktor.server.application.*
import io.ktor.server.request.*
import io.ktor.server.response.*
import io.ktor.server.routing.*
import online.bingzi.internal.entity.request.user.UserUpdate
import online.bingzi.internal.entity.request.user.UserUpdateResult
import online.bingzi.internal.routes.user.UserSession.userUpdateMapper

/**
 * User update
 * 更新路由
 *
 * @param path Url路径
 */
fun Route.userUpdate(path: String) {
    post(path) {
        // 将发送过来的JSON进行序列化
        val userUpdate = call.receive(UserUpdate::class)
        // 构建返回对象并对值进行初始化
        val userUpdateResult = UserUpdateResult().apply {
            // 正则校验账户名是否合法
            this.user = userUpdate.user.matches("^[a-zA-Z\\d_-]{2,15}$".toRegex())
            // 正则校验昵称是否合法
            this.username = userUpdate.username.matches("^[a-z\\d\u4e00-\u9fa5]+[^_]\$".toRegex())
            // 正则校验密码是否合法
            this.password = userUpdate.password.matches("^(?!\\d+\$)(?![a-zA-Z]+\$)[\\dA-Za-z]{6,15}\$".toRegex())
            // 正则校验班级是否合法
            this.clazz = userUpdate.clazz.matches("^[a-zA-Z\\d_-]{2,15}\$".toRegex())
            // 根据上面判断返回值，此刻并不是最终返回值
            this.result = user && username && password && clazz
            // 构建提示语句
            this.info = if (result) "校验已结束，全部正确！" else "校验失败，有部分参数不正确！请检查您不正确的参数并进行修正。"
        }
        // 在数据中进行查询该用户是否存在
        userUpdateResult.result = userUpdateMapper.queryUserByUser(userUpdate)?.let {
            // 存在且校验通过
            if (userUpdateResult.result) {
                // 更新用户数据
                userUpdateMapper.updateUser(userUpdate)
                // 构建提示语句
                userUpdateResult.info = "用户${userUpdate.user}的信息已更新。"
                // 设置最终返回值
                true
            } else {
                // 校验未通过，设置最终返回结果
                false
            }
        } ?: false // 数据库中不存在该用户，设置最终返回结果
        // 返回实体并自动转化为JSON类型返回
        call.respond(userUpdateResult)
    }
}