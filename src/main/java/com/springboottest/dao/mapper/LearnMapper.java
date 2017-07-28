package com.springboottest.dao.mapper;

import com.springboottest.domain.LearnResouce;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;
import java.util.Map;

/**
 * Created by Administrator on 2017/7/12.
 */
@Mapper
public interface LearnMapper {
    int add(LearnResouce learnResouce);
    int update(LearnResouce learnResouce);
    int deleteByIds(String[] ids);
    LearnResouce queryLearnResouceById(Long id);
    List<LearnResouce> queryLearnResouceList(Map<String, Object> params);
}
