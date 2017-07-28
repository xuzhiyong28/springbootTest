package com.springboottest.dao;

import com.springboottest.domain.LearnResouce;
import com.springboottest.tools.Page;

import java.util.Map;

/**
 * Created by Administrator on 2017/7/11.
 */
public interface LearnDao {
    int add(LearnResouce learnResouce);
    int update(LearnResouce learnResouce);
    int deleteByIds(String ids);
    LearnResouce queryLearnResouceById(Long id);
    Page queryLearnResouceList(Map<String,Object> params);
}
