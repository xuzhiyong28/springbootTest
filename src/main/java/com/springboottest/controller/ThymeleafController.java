package com.springboottest.controller;

import com.springboottest.domain.LearnResouce;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by Administrator on 2017/7/8.
 */
@Controller
@RequestMapping("/thymeleaf")
public class ThymeleafController {

    @RequestMapping("/")
    public ModelAndView index() throws Exception{
        ModelAndView modelAndView = new ModelAndView("/index");
        modelAndView.addObject("learnList",this.initLearnResouce());
        return modelAndView;
    }


    /***
     *
     * @return
     */
    @RequestMapping("/bootIndex")
    public ModelAndView bootindex(){
        ModelAndView modelAndView = new ModelAndView("/bootstrapindex");
        modelAndView.addObject("learnList",this.initLearnResouce());
        return modelAndView;
    }

    /***
     * 详细介绍
     * @return
     */
    @RequestMapping("/introduce")
    public ModelAndView introduce(HttpServletRequest request){
        String type = request.getParameter("type");
        ModelAndView modelAndView = new ModelAndView("/introduce");
        return modelAndView;
    }

    public List<LearnResouce> initLearnResouce() {
        List<LearnResouce> learnList = new ArrayList<LearnResouce>();
        LearnResouce bean = new LearnResouce("官方参考文档", "Spring Boot Reference Guide", "http://localhost:8080/thymeleaf/introduce?type=check");
        learnList.add(bean);
        bean = new LearnResouce("官方SpriongBoot例子", "官方SpriongBoot例子", "http://localhost:8080/thymeleaf/introduce");
        learnList.add(bean);
        bean = new LearnResouce("龙国学院", "Spring Boot 教程系列学习", "http://www.roncoo.com/article/detail/125488");
        learnList.add(bean);
        bean = new LearnResouce("嘟嘟MD独立博客", "Spring Boot干货系列 ", "http://tengj.top/");
        learnList.add(bean);
        bean = new LearnResouce("后端编程嘟", "Spring Boot教程和视频 ", "http://www.toutiao.com/m1559096720023553/");
        learnList.add(bean);
        bean = new LearnResouce("程序猿DD", "Spring Boot系列", "http://www.roncoo.com/article/detail/125488");
        learnList.add(bean);
        bean = new LearnResouce("纯洁的微笑", "Sping Boot系列文章", "http://www.ityouknow.com/spring-boot");
        learnList.add(bean);
        bean = new LearnResouce("CSDN——小当博客专栏", "Sping Boot学习", "http://blog.csdn.net/column/details/spring-boot.html");
        learnList.add(bean);
        bean = new LearnResouce("梁桂钊的博客", "Spring Boot 揭秘与实战", "http://blog.csdn.net/column/details/spring-boot.html");
        learnList.add(bean);
        bean = new LearnResouce("林祥纤博客系列", "从零开始学Spring Boot ", "http://412887952-qq-com.iteye.com/category/356333");
        learnList.add(bean);
        return learnList;
    }

}
