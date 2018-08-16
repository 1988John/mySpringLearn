package com.foo.test.mybatis;

import com.foo.dao.user.UserDao;
import org.apache.ibatis.binding.MapperProxyFactory;
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
public class MybatisTest {
    public static void main(String[] args) throws IOException {
        String resource = "mybatis-config.xml";
        InputStream inputStream = Resources.getResourceAsStream(resource);
        SqlSessionFactory sqlSessionFactory =
                new SqlSessionFactoryBuilder().build(inputStream);

        SqlSession session = sqlSessionFactory.openSession();
        try {
            Integer count = session.selectOne("com.foo.dao.user.UserDao.selectCount");
            System.out.println(count);
        } finally {
            session.close();
        }

    }
}

