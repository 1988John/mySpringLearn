package com.foo.test.mysql;

import java.sql.DatabaseMetaData;
import java.sql.ResultSet;
import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Properties;
import java.util.Set;
import java.util.stream.Collectors;

import javax.sql.DataSource;

import org.apache.ibatis.metadata.Database;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowCountCallbackHandler;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.core.namedparam.EmptySqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.jdbc.support.rowset.SqlRowSet;
import org.springframework.jdbc.support.rowset.SqlRowSetMetaData;

import com.foo.test.dao.Aa;
import com.zaxxer.hikari.HikariConfig;
import com.zaxxer.hikari.HikariDataSource;

/**
 * @author fooisart
 * @date 11:47 31-05-2019
 */
public class JdbcTemplateTest {
    private static final String TABLE = "user";
    private static final String HOST = "127.0.0.1";
    private static final int PORT = 3306;
    private static final String USER = "root";
    private static final String PASSWORD = "Jw19930109";
    private static final String DATABASE = "foo";
    private static final String DRIVER_CLASS_NAME = "com.mysql.jdbc.Driver";
    private static RowMapper<Aa> rowMapper = new BeanPropertyRowMapper<>(Aa.class);
    public static void main(String[] args) {
        //创建jdbcTemplate对象，设置数据源
        NamedParameterJdbcTemplate jdbcTemplate = new NamedParameterJdbcTemplate(getDataSource());
        String s = jdbcTemplate.queryForObject("select database()", Collections.emptyMap(), String.class);
        System.out.println(s);

        try {
            DatabaseMetaData dbMetaData = jdbcTemplate.getJdbcTemplate().getDataSource().getConnection().getMetaData();

            System.out.println(dbMetaData.getConnection().getMetaData().getURL());
            //表对应的schema
            ResultSet resultSet = dbMetaData.getColumns(null, DATABASE, TABLE, null);
            while (resultSet.next()) {
                String name = resultSet.getString("COLUMN_NAME");
                System.out.println(name);
                //业务逻辑
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
//        String sql = "select COLUMN_NAME from information_schema.COLUMNS where table_name = 'user' and  table_schema = 'foo'";
//        List<Map<String, Object>> maps = jdbcTemplate.queryForList(sql, Collections.emptyMap());
//        System.out.println(maps);
    }

    private static DataSource getDataSource(){
        Properties properties = new Properties();
        properties.put("user", USER);
        properties.put("password", PASSWORD);

        HikariConfig config = new HikariConfig();
        config.setDriverClassName(DRIVER_CLASS_NAME);
        String url = String.format("jdbc:mysql://%s:%d/%s", HOST, PORT, DATABASE);
        System.out.println(url);
        config.setJdbcUrl(url);
        config.setDataSourceProperties(properties);
        config.setMinimumIdle(0);
        return new HikariDataSource(config);
    }

}
