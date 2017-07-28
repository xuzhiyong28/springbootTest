package com.springboottest.controller;/**
 * Created by Administrator on 2017/7/22.
 */

import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.springboottest.domain.UserInfo;
import com.springboottest.service.ShiroService;
import com.springboottest.tools.Page;
import com.springboottest.tools.ServletUtil;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.session.Session;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author xuzhiyong
 * @createDate 2017-07-22-12:43
 */
@Controller
@RequestMapping("/user")
public class UserRoleController {


    private Logger logger = LoggerFactory.getLogger(UserRoleController.class);

    @Autowired
    private ShiroService shiroService;

    @RequestMapping("/index")
    public String index(HttpServletRequest request){
        JSONArray roleArray = shiroService.getRoleAll();
        request.setAttribute("roleArray",roleArray);
        return "usertemplates/userindex";
    }



    @RequestMapping("/addUser")
    public String addUser(HttpServletRequest request,HttpServletResponse response){
        JSONObject result = new JSONObject();
        String username = request.getParameter("username");
        String name = request.getParameter("name");
        String role = request.getParameter("role");
        UserInfo userInfo = new UserInfo();
        userInfo.setPassword("111111");
        userInfo.setName(name);
        userInfo.setUsername(username);
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


    @RequestMapping("/updateUser")
    public String updateUser(HttpServletRequest request){
        String username = request.getParameter("username");
        String name = request.getParameter("name");
        String role = request.getParameter("role");

        return null;
    }


    @RequestMapping("/queryUserList")
    @ResponseBody
    public JSONObject queryUserList(HttpServletRequest request, HttpServletResponse response) throws Exception{
        Session session = SecurityUtils.getSubject().getSession();
        JSONObject userInfo = (JSONObject) session.getAttribute("userSession");
        String page = request.getParameter("page"); // 取得当前页数,注意这是jqgrid自身的参数
        String rows = request.getParameter("rows"); // 取得每页显示行数，,注意这是jqgrid自身的参数
        String username = request.getParameter("username");
        String name = request.getParameter("name");
        Map<String, String> params = new HashMap<String, String>();
        params.put("page", page);
        params.put("rows", rows);
        params.put("username", username);
        params.put("name", name);
        Page pageObj = shiroService.queryUserList(params);
        List<Map<String, Object>> learnList = pageObj.getResultList();
        JSONObject jo = new JSONObject();
        jo.put("rows", learnList);
        jo.put("total", pageObj.getTotalPages());
        jo.put("records", pageObj.getTotalRows());
        logger.debug("输出结果=" + jo.toJSONString());
        return jo;
    }

}
