package online.bingzi.internal.util

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