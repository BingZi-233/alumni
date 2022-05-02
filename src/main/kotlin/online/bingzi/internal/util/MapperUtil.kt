package online.bingzi.internal.util

import online.bingzi.internal.mapper.MessageMapper
import online.bingzi.internal.mapper.PhotoMapper
import online.bingzi.internal.mapper.RecordMapper
import online.bingzi.internal.mapper.UserMapper
import org.apache.ibatis.io.Resources
import org.apache.ibatis.session.SqlSession
import org.apache.ibatis.session.SqlSessionFactory
import org.apache.ibatis.session.SqlSessionFactoryBuilder
import java.io.InputStream

/**
 * Open session
 * 创建MyBatis访问对象，但是没有进一步进行创建。
 * 注意：已经启用自动提交。
 */
val openSession: SqlSession by lazy {
    val resourceAsStream: InputStream = Resources.getResourceAsStream("mybatis-config.xml")
    val sqlSessionFactoryBuilder: SqlSessionFactoryBuilder = SqlSessionFactoryBuilder()
    val sessionFactory: SqlSessionFactory = sqlSessionFactoryBuilder.build(resourceAsStream)
    sessionFactory.openSession(true)
}

/**
 * User session
 * 用户路由的MySQL访问入口
 */
val userMapper: UserMapper = openSession.getMapper(UserMapper::class.java)

/**
 * Photo mapper
 * 相册路由的MySQL访问入口
 */
val photoMapper: PhotoMapper = openSession.getMapper(PhotoMapper::class.java)

/**
 * Message mapper
 * 留言板路由的MySQL访问入口
 */
val messageMapper: MessageMapper = openSession.getMapper(MessageMapper::class.java)

/**
 * Record mapper
 * 通讯录路由的MySQL访问入口
 */
val recordMapper: RecordMapper = openSession.getMapper(RecordMapper::class.java)