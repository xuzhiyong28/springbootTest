package com.springboottest.service.impl;

import com.springboottest.dao.LearnDao;
import com.springboottest.domain.LearnResouce;
import com.springboottest.service.LearnService;
import com.springboottest.tools.Page;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.Map;

/**
 * Created by Administrator on 2017/7/11.
 */
@Repository
public class LearnServiceImpl implements LearnService {
    @Autowired
    private LearnDao learnDao;
    @Override
    public int add(LearnResouce learnResouce) {
        return this.learnDao.add(learnResouce);
    }

    @Override
    public int update(LearnResouce learnResouce) {
        return this.learnDao.update(learnResouce);
    }

    @Override
    public int deleteByIds(String ids) {
        return this.learnDao.deleteByIds(ids);
    }

    @Override
    public LearnResouce queryLearnResouceById(Long learnResouce) {
        return this.learnDao.queryLearnResouceById(learnResouce);
    }

    @Override
    public Page queryLearnResouceList(Map<String, Object> params) {
        return this.learnDao.queryLearnResouceList(params);
    }
}
