package com.springboottest.dao;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;

import java.util.Map;

/**
 * Created by Administrator on 2017/6/29.
 */
@Service("productDao")
public class ProductDao {
    @Autowired
    private JdbcTemplate jdbcTemplate;

    public void getAllProducs() {
        String sql = "select * from products where id = 1";
        Map map = jdbcTemplate.queryForMap(sql);
        System.out.println(map);
    }


}
