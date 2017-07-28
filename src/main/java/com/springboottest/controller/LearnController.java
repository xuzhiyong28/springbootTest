package com.springboottest.controller;

import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.github.pagehelper.PageInfo;
import com.springboottest.domain.LearnResouce;
import com.springboottest.domain.UserInfo;
import com.springboottest.service.LearnMybatisService;
import com.springboottest.service.LearnService;
import com.springboottest.service.ShiroService;
import com.springboottest.tools.Page;
import com.springboottest.tools.ServletUtil;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.*;
import org.apache.shiro.session.Session;
import org.apache.shiro.subject.Subject;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.thymeleaf.util.StringUtils;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by Administrator on 2017/7/11.
 */
@Controller
@RequestMapping("/learn")
public class LearnController {

    private Logger logger = LoggerFactory.getLogger(LearnController.class);


    @Autowired
    private LearnService learnService;

    @Autowired
    private LearnMybatisService learnMybatisService;

    @Autowired
    private ShiroService shiroService;


    @RequestMapping(value = "/login", method = RequestMethod.GET)
    public String login() {
        return "login";
    }

    /***
     * 这个是shiro认证出现错误的时候才会执行的，真正的认证不走这里，直接给shiro底层去做认证
     * @param request
     * @return
     */
    @RequestMapping(value = "/login", method = RequestMethod.POST)
    public String init(HttpServletRequest request) {
        Subject subject = SecurityUtils.getSubject();
        String username = request.getParameter("username");
        String password = request.getParameter("password");
        UsernamePasswordToken token = new UsernamePasswordToken(username, password);
        try {
            subject.login(token);
            return "login";
        } catch (LockedAccountException lae) {
            token.clear();
            request.setAttribute("msg", "用户已经被锁定不能登录，请与管理员联系！");
            return "login";
        } catch (AuthenticationException e) {
            token.clear();
            request.setAttribute("msg", "用户或密码不正确！");
            return "login";
        }
    }


    @RequestMapping(value = "index")
    public String index() {
        return "learn-index";
    }


    @RequestMapping("/register/{type}")
    public String register(@PathVariable String type, HttpServletRequest request, HttpServletResponse response) {
        if ("index".equals(type)) {
            JSONArray roleArray = shiroService.getRoleAll();
            request.setAttribute("roleArray", roleArray);
            return "register";
        } else {
            String name = request.getParameter("name");
            String userName = request.getParameter("userName");
            String role = request.getParameter("role");
            String password = request.getParameter("password");
            UserInfo userInfo = new UserInfo();
            userInfo.setPassword(password);
            userInfo.setName(name);
            userInfo.setUsername(userName);
            JSONObject result = new JSONObject();
            if (shiroService.addUserInfo(userInfo, role) > 0) {
                result.put("code", "1");
                result.put("message", "成功");
                ServletUtil.createSuccessResponse(200, result, response);
            } else {
                result.put("code", "-1");
                result.put("message", "失败");
                ServletUtil.createSuccessResponse(200, result, response);
            }
            return null;
        }
    }

    @RequestMapping("/main")
    public String main() {
        return "learn-main";
    }

    @RequestMapping("/resource")
    public String resource() {
        return "learn-resource";
    }


    @RequestMapping("/queryLearnList")
    @ResponseBody
    public JSONObject queryLearnList(HttpServletRequest request, HttpServletResponse response) throws Exception {
        Session session = SecurityUtils.getSubject().getSession();
        JSONObject userInfo = (JSONObject) session.getAttribute("userSession");
        String page = request.getParameter("page"); // 取得当前页数,注意这是jqgrid自身的参数
        String rows = request.getParameter("rows"); // 取得每页显示行数，,注意这是jqgrid自身的参数
        String author = request.getParameter("author");
        String title = request.getParameter("title");
        Map<String, Object> params = new HashMap<String, Object>();
        params.put("page", page);
        params.put("rows", rows);
        params.put("author", author);
        params.put("title", title);
        Page pageObj = learnService.queryLearnResouceList(params);

        //------------------------或者用mybatis--------------------
        List<LearnResouce> learnList2 = learnMybatisService.queryLearnResouceList(params);
        PageInfo<LearnResouce> pageInfo = new PageInfo<LearnResouce>(learnList2);
        JSONObject jo2 = new JSONObject();
        jo2.put("rows", learnList2);
        jo2.put("total", pageInfo.getPages());//总页数
        jo2.put("records", pageInfo.getTotal());//查询出的总记录数
        logger.debug("输出结果=" + jo2.toJSONString());
        //------------------------或者用mybatis--------------------

        List<Map<String, Object>> learnList = pageObj.getResultList();
        JSONObject jo = new JSONObject();
        jo.put("rows", learnList);
        jo.put("total", pageObj.getTotalPages());
        jo.put("records", pageObj.getTotalRows());
        logger.debug("输出结果=" + jo.toJSONString());
        //ServletUtil.createSuccessResponse(200, jo, response);
        return jo;
    }


    @RequestMapping("/addLearn")
    @ResponseBody
    public JSONObject addLearn(HttpServletRequest request, HttpServletResponse response) throws Exception {
        JSONObject result = new JSONObject();
        String author = request.getParameter("author");
        String title = request.getParameter("title");
        String url = request.getParameter("url");
        if (StringUtils.isEmpty(author) || StringUtils.isEmpty(title) || StringUtils.isEmpty(url)) {
            result.put("flag", false);
            result.put("flag", "表单填写错误");
        } else {
            LearnResouce learnResouce = new LearnResouce();
            learnResouce.setAuthor(author);
            learnResouce.setTitle(title);
            learnResouce.setUrl(url);
            //result.put("flag", learnService.add(learnResouce) > 0 ? true : false);
            result.put("flag", learnMybatisService.add(learnResouce) > 0 ? true : false);
            result.put("message", "插入成功");
        }
        return result;
    }

    @RequestMapping("/deleteLearn")
    @ResponseBody
    public JSONObject deleteLearn(HttpServletRequest request, HttpServletResponse response) {
        JSONObject result = new JSONObject();
        String ids = request.getParameter("ids");
        if (StringUtils.isEmpty(ids)) {
            result.put("message", "请选择一条记录进行删除");
        } else {
            result.put("message", learnService.deleteByIds(ids) > 0 ? "删除成功" : "删除失败");
        }
        return result;
    }


    @RequestMapping("/updateLearn")
    @ResponseBody
    public JSONObject updateLearn(HttpServletRequest request, HttpServletResponse response) {
        JSONObject result = new JSONObject();
        String id = request.getParameter("id");
        LearnResouce learnResouce = learnService.queryLearnResouceById(Long.valueOf(id));
        String author = request.getParameter("author");
        String title = request.getParameter("title");
        String url = request.getParameter("url");
        if (StringUtils.isEmpty(author) || StringUtils.isEmpty(title) || StringUtils.isEmpty(url)) {
            result.put("flag", false);
            result.put("flag", "表单填写错误");
        } else {
            learnResouce.setAuthor(author);
            learnResouce.setTitle(title);
            learnResouce.setUrl(url);
            result.put("flag", learnService.update(learnResouce) > 0 ? true : false);
            result.put("message", "修改成功");
        }
        return result;
    }

}
