package com.springboottest.service.impl;

import com.github.pagehelper.PageHelper;
import com.springboottest.dao.mapper.LearnMapper;
import com.springboottest.domain.LearnResouce;
import com.springboottest.service.LearnMybatisService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Map;

/**
 * Created by Administrator on 2017/7/12.
 */
@Service
@Transactional(value = "mybatisTransactionManager")
//mysql事务需要注意几点问题：my.in加default-storage-engine=INNODB  init_connect='SET autocommit=0'
//由于我这里自定义的事务管理器，所以上面value 要加mybatisTransactionManager
public class LearnMybatisServiceImpl implements LearnMybatisService {

    @Autowired
    private LearnMapper learnMapper;

    @Override
    public int add(LearnResouce learnResouce) throws Exception{
        int count = this.learnMapper.add(learnResouce);
        return count;
    }

    @Override
    public int update(LearnResouce learnResouce) {
        return this.learnMapper.update(learnResouce);
    }

    @Override
    public int deleteByIds(String[] ids) {
        return this.learnMapper.deleteByIds(ids);
    }

    @Override
    public LearnResouce queryLearnResouceById(Long learnResouce) {
        return this.learnMapper.queryLearnResouceById(learnResouce);
    }

    @Override
    public List<LearnResouce> queryLearnResouceList(Map<String, Object> params) {
        PageHelper.startPage(Integer.parseInt(params.get("page").toString()), Integer.parseInt(params.get("rows").toString())); //分页插件，这样用就可以了 奇怪
        return this.learnMapper.queryLearnResouceList(params);
    }
}
