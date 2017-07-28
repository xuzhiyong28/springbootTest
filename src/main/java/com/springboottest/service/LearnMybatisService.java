package com.springboottest.service;

import com.springboottest.domain.LearnResouce;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Map;

/**
 * Created by Administrator on 2017/7/12.
 */
public interface LearnMybatisService {
    int add(LearnResouce learnResouce) throws Exception;
    int update(LearnResouce learnResouce);
    int deleteByIds(String[] ids);
    LearnResouce queryLearnResouceById(Long learnResouce);
    List<LearnResouce> queryLearnResouceList(Map<String, Object> params);
}
