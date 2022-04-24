package online.bingzi.internal.model.routes.auth

import io.ktor.server.application.*
import io.ktor.server.request.*
import io.ktor.server.response.*
import io.ktor.server.routing.*
import online.bingzi.internal.entity.request.auth.UserRegister
import online.bingzi.internal.entity.request.auth.UserRegisterResult

/**
 * Register
 * 注册路由
 *
 * @param path Url路径
 */
fun Route.register(path: String) {
    post(path) {
        // 将发送过来的JSON进行序列化
        val userRegister = call.receive(UserRegister::class)
        // 构建返回对象并对值进行初始化
        val userRegisterResult = UserRegisterResult().apply {
            // 正则校验账户名是否合法
            this.user = userRegister.user.matches("^[a-zA-Z\\d_-]{2,15}$".toRegex())
            // 正则校验昵称是否合法
            this.username = userRegister.username.matches("^[a-z\\d\u4e00-\u9fa5]+[^_]\$".toRegex())
            // 正则校验密码是否合法
            this.password = userRegister.password.matches("^(?!\\d+\$)(?![a-zA-Z]+\$)[\\dA-Za-z]{6,15}\$".toRegex())
            // 正则校验班级是否合法
            this.clazz = userRegister.clazz.matches("^[a-zA-Z\\d_-]{2,15}\$".toRegex())
            // 根据上面判断返回值，此刻并不是最终返回值
            this.result = user && username && password && clazz
            // 构建提示语句
            this.info = if (result) "校验已结束，全部正确！该数据已插入到数据库中。" else "校验失败，有部分参数不正确！请检查您不正确的参数并进行修正。"
        }
        // 判断检验是否通过
        if (userRegisterResult.result) {
            // 在数据库中查询该用户是否存在
            AuthSession.registerMapper.queryUserByUser(userRegister.user)?.let {
                // 用户存在，更改返回值
                userRegisterResult.result = false
                // 构建提示语句
                userRegisterResult.info = "校验失败，该用户名已存在！"
            } ?: AuthSession.registerMapper.insertUser(userRegister) // 用户不存在，将该用户数据插入到数据库中
        }
        // 返回实体并自动转化为JSON类型返回
        call.respond(userRegisterResult)
    }
}