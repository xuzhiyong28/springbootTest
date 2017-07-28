package com.springboottest.controller;

import com.springboottest.dao.ProductDao;
import com.springboottest.domain.ConfigBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import java.util.HashMap;
import java.util.Map;

/**
 * Created by Administrator on 2017/6/22.
 */
@RestController
@RequestMapping("/springSession")
public class SpringSessionRedisController {

    @Autowired
    private ProductDao productDao;

    @Autowired
    private ConfigBean configBean;


    @RequestMapping(value = "/first", method = RequestMethod.GET)
    public Map<String, Object> firstResp (HttpServletRequest request){
        Map<String, Object> map = new HashMap<>();
        request.getSession().setAttribute("request Url", request.getRequestURL());
        map.put("request Url", request.getRequestURL());
        productDao.getAllProducs();
        return map;
    }

    @RequestMapping(value = "/sessions", method = RequestMethod.GET)
    public Object sessions (HttpServletRequest request){
        Map<String, Object> map = new HashMap<>();
        map.put("sessionId", request.getSession().getId());
        map.put("message", request.getSession().getAttribute("map"));
        return map;
    }

    /****
     * 自定义配置
     * @param request
     * @return
     */
    @RequestMapping(value = "/configResp", method = RequestMethod.GET)
    public  Map configResp(HttpServletRequest request){
        Map<String, Object> map = new HashMap<>();
        map.put("name",configBean.getName());
        map.put("message",configBean.getMessage());
        map.put("uuid",configBean.getUuid());
        return map;
    }

}
