package com.springboottest.service;

import com.springboottest.domain.LearnResouce;
import com.springboottest.tools.Page;

import java.util.Map;

/**
 * Created by Administrator on 2017/7/11.
 */
public interface LearnService {
    int add(LearnResouce learnResouce);

    int update(LearnResouce learnResouce);

    int deleteByIds(String ids);

    LearnResouce queryLearnResouceById(Long learnResouce);

    Page queryLearnResouceList(Map<String, Object> params);
}
