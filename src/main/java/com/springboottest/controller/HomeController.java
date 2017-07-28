package com.springboottest.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

/**
 * Created by Administrator on 2017/7/17.
 */
@Controller
public class HomeController {
    //这里设置默认主页为learn-index.html 这样shiro成功后才不会跳转报错， shiro默认成功跳转到上一次的页面
    @RequestMapping("/")
    public ModelAndView index() {
        return new ModelAndView("learn-index");
    }

    @RequestMapping("/403")
    public ModelAndView error(){
        return new ModelAndView("error");
    }
}
