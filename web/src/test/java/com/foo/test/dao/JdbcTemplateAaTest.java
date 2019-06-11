package com.foo.test.dao;

import java.util.List;
import java.util.Properties;
import java.util.stream.Collectors;

import javax.sql.DataSource;

import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;

import com.zaxxer.hikari.HikariConfig;
import com.zaxxer.hikari.HikariDataSource;

/**
 * @author fooisart
 * @date 11:47 31-05-2019
 */
public class JdbcTemplateAaTest {
    private static final String TABLE = "aa";
    private static final String HOST = "172.16.240.104";
    private static final int PORT = 1433;
    private static final String USER = "BCDBUser";
    private static final String PASSWORD = "Kuaishou@123)(*";
    private static final String DATABASE = "BasicCallDB";
    private static final String DRIVER_CLASS_NAME = "com.microsoft.sqlserver.jdbc.SQLServerDriver";
    private static RowMapper<Aa> rowMapper = new BeanPropertyRowMapper<>(Aa.class);
    public static void main(String[] args) {
        //创建jdbcTemplate对象，设置数据源
        JdbcTemplate jdbcTemplate = new JdbcTemplate(getDataSource());

//        //调用jdbcTemplate对象里面的方法实现操作
//        //创建sql语句
        String timestamp = " where version > 0 order by version asc";

        String sql = "select * from " + TABLE + timestamp;
        List<Aa> query = jdbcTemplate.query(sql, rowMapper);
        System.out.println(query);

        String timestamp1 = " where version > 4790673 order by version asc";

        String sql1 = "select top 2 * from " + TABLE + timestamp1;
        List<Aa> query1 = jdbcTemplate.query(sql1, rowMapper);
        System.out.println(query1);

    }

    private static DataSource getDataSource(){
        Properties properties = new Properties();
        properties.put("user", USER);
        properties.put("password", PASSWORD);

        HikariConfig config = new HikariConfig();
        config.setDriverClassName(DRIVER_CLASS_NAME);
        String url = String.format("jdbc:sqlserver://%s:%d;database=%s;", HOST, PORT, DATABASE);
        System.out.println(url);
        config.setJdbcUrl(url);
        config.setDataSourceProperties(properties);
        config.setMinimumIdle(0);
        return new HikariDataSource(config);
    }

}
