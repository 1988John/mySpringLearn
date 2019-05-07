package com.foo.test.sql;

import java.util.Date;
import java.util.List;

import javax.sql.DataSource;

import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.PreparedStatementCreator;
import org.springframework.jdbc.core.PreparedStatementCreatorFactory;
import org.springframework.jdbc.core.SqlParameter;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.jdbc.core.namedparam.NamedParameterUtils;
import org.springframework.jdbc.core.namedparam.ParsedSql;
import org.springframework.jdbc.core.namedparam.SqlParameterSource;
import org.springframework.jdbc.datasource.DriverManagerDataSource;
import org.springframework.jdbc.datasource.SimpleDriverDataSource;

import com.alibaba.fastjson.JSON;

/**
 * @author fooisart
 * @date 14:54 07-05-2019
 */
public class PrintSql {

    public static void main(String[] args) {
        BeanPropertyRowMapper<Address> rowMapper = new BeanPropertyRowMapper<>(Address.class);
        DriverManagerDataSource dataSource=new DriverManagerDataSource();
        dataSource.setDriverClassName("com.mysql.jdbc.Driver");
        dataSource.setUrl("jdbc:MySql://127.0.0.1:3306/foo?characterEncoding=UTF-8&zeroDateTimeBehavior=convertToNull&autoReconnect=true");
        dataSource.setUsername("root");
        dataSource.setPassword("Jw19930109");

        String sql = "select * from   address where id = :id and province = :cc";
        MapSqlParameterSource params = new MapSqlParameterSource("cc","河北").addValue("id",2);
//        PreparedStatementCreator psc = getPreparedStatementCreator(sql, params);
//        psc.createPreparedStatement()
        NamedParameterJdbcTemplate template = new NamedParameterJdbcTemplate(dataSource);
//        template.update(sql,params);
        List<Address> list = template.query(sql, params, rowMapper);
        System.out.println(JSON.toJSON(list));
//        System.out.println(psc);
    }
    protected static PreparedStatementCreator getPreparedStatementCreator(String sql, SqlParameterSource paramSource) {

        ParsedSql parsedSql = NamedParameterUtils.parseSqlStatement(sql);
        PreparedStatementCreatorFactory pscf = getPreparedStatementCreatorFactory(parsedSql, paramSource);
        Object[] params = NamedParameterUtils.buildValueArray(parsedSql, paramSource, null);
        return pscf.newPreparedStatementCreator(params);
    }

    protected static PreparedStatementCreatorFactory getPreparedStatementCreatorFactory(
            ParsedSql parsedSql, SqlParameterSource paramSource) {

        String sqlToUse = NamedParameterUtils.substituteNamedParameters(parsedSql, paramSource);
        List<SqlParameter> declaredParameters = NamedParameterUtils.buildSqlParameterList(parsedSql, paramSource);
        return new PreparedStatementCreatorFactory(sqlToUse, declaredParameters);
    }
}
