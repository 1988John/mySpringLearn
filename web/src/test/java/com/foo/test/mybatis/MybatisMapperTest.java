package com.foo.test.mybatis;

import com.foo.dao.user.UserDao;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import java.io.IOException;
import java.io.InputStream;

/**
 * @author jiangwang3
 * @date 2018/8/16.
 */
public class MybatisMapperTest {
    public static void main(String[] args) throws IOException {
        String resource = "mybatis-config.xml";
        InputStream inputStream = Resources.getResourceAsStream(resource);
        SqlSessionFactory sqlSessionFactory =
                new SqlSessionFactoryBuilder().build(inputStream);

        //此处在mybatis-spring项目中，使用了jdk dynamic proxy。动态生成SqlSession实现类
        SqlSession session = sqlSessionFactory.openSession();

        //此处在mybatis-spring项目中，使用了jdk dynamic proxy。动态生成UserDao实现类
        UserDao userDao = session.getMapper(UserDao.class);
        try {
            int i = userDao.selectCount();
            System.out.println(i);
        } finally {
            session.close();
        }
    }
}

