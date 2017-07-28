package com.springboottest.controller;

import com.alibaba.fastjson.JSONObject;
import org.apache.log4j.Logger;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.PrintWriter;
import java.io.StringWriter;

/**
 * Created by Administrator on 2017/7/13.
 * 统一异常处理
 */
@ControllerAdvice
public class GlobalExceptionHandler {
    private static Logger log = Logger.getLogger(GlobalExceptionHandler.class);
    public static final String DEFAULT_ERROR_VIEW = "error";

    @ExceptionHandler(value = Exception.class)
    public Object defaultErrorHandler(HttpServletRequest request,HttpServletResponse response , Exception e) throws Exception{
        String requestType = request.getHeader("X-Requested-With"); //用来判断是不是异步请求
        if ("XMLHttpRequest".equals(requestType)) { //异步请求
            e.printStackTrace();
            log.error(e.getMessage());
            JSONObject result = new JSONObject();
            StringWriter sw = new StringWriter();
            e.printStackTrace(new PrintWriter(sw, true));
            result.put("exception",sw.toString());
            result.put("url",request.getRequestURL());
            response.setStatus(500); //返回500错误
            printJSON(response, result);
            return null;
        }else{
            log.error(e.getMessage());
            ModelAndView mav = new ModelAndView();
            mav.addObject("exception", e);
            mav.addObject("url", request.getRequestURL());
            mav.setViewName(DEFAULT_ERROR_VIEW);
            return mav;
        }
    }

    public void printJSON(HttpServletResponse response, JSONObject json){
        PrintWriter out = null;
        response.setContentType("text/html;charset=UTF-8");
        response.setCharacterEncoding("UTF-8");
        try{
            out = response.getWriter();
            out.print(json.toJSONString());
        }catch (Exception e){
            e.printStackTrace();
        }
        finally{
            if(out != null)
                out.close();
        }
    }






}
