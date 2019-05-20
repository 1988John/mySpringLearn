package com.foo.service.jdbc;

import java.util.Map;

import javax.annotation.Resource;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.google.common.collect.ImmutableMap;

//@Service("repeatContactsService")
@Transactional
public class RepeatContactsService {  
  
    private static final Logger LOG = LoggerFactory.getLogger(RepeatContactsService.class);
  
    @Resource
    private NamedParameterJdbcTemplate namedParameterJdbcTemplate;
  
    public int getRepeatContactsCountByPhone(String userid, String phone){  
        String sql= "SELECT count(1) FROM tab_user WHERE userid != :userid AND number = :phone";  
        Map parmas = ImmutableMap.of("userid",userid,"phone",phone);
        Integer count = null;  
        try {  
            count = namedParameterJdbcTemplate.queryForObject(sql, parmas, Integer.class);  
        } catch (DataAccessException e) {
            LOG.error("获取值时抛错：", e);  
        }  
        return count;  
    }
}  