package com.springboottest.dao.impl;

import com.springboottest.dao.LearnDao;
import com.springboottest.domain.LearnResouce;
import com.springboottest.tools.Page;
import com.springboottest.tools.StringUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Map;

/**
 * Created by Administrator on 2017/7/11.
 */
@Repository
public class LearnDaoImpl implements LearnDao {


    @Autowired
    @Qualifier("mybatisJdbcTemplate")
    private JdbcTemplate jdbcTemplate;

    @Override
    public int add(LearnResouce learnResouce) {
        return jdbcTemplate.update("insert into learn_resource(author, title,url) values(?, ?, ?)",learnResouce.getAuthor(),learnResouce.getTitle(),learnResouce.getUrl());
    }

    @Override
    public int update(LearnResouce learnResouce) {
        return jdbcTemplate.update("update learn_resource set author=?,title=?,url=? where id = ?",new Object[]{learnResouce.getAuthor(),learnResouce.getTitle(),learnResouce.getUrl(),learnResouce.getId()});
    }

    @Override
    public int deleteByIds(String ids) {
        return jdbcTemplate.update("delete from learn_resource where id in ( " + ids + " )");
    }

    @Override
    public LearnResouce queryLearnResouceById(Long id) {
        List<LearnResouce> list = jdbcTemplate.query("select * from learn_resource where id = ?", new Object[]{id}, new BeanPropertyRowMapper(LearnResouce.class));
        if (null != list && list.size() > 0) {
            LearnResouce learnResouce = list.get(0);
            return learnResouce;
        } else {
            return null;
        }
    }

    @Override
    public Page queryLearnResouceList(Map<String, Object> params) {
        StringBuffer sql =new StringBuffer();
        sql.append("select * from learn_resource where 1=1");
        if(!StringUtil.isNull((String)params.get("author"))){
            sql.append(" and author like '%").append((String)params.get("author")).append("%'");
        }
        if(!StringUtil.isNull((String)params.get("title"))){
            sql.append(" and title like '%").append((String)params.get("title")).append("%'");
        }
        Page page = new Page(sql.toString(), Integer.parseInt(params.get("page").toString()), Integer.parseInt(params.get("rows").toString()), jdbcTemplate);
        return page;
    }
}
