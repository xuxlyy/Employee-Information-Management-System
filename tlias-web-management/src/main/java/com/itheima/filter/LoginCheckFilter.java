package com.itheima.filter;

import com.alibaba.fastjson.JSONObject;
import com.itheima.pojo.Result;
import com.itheima.utils.JwtUtils;
import lombok.extern.slf4j.Slf4j;
import netscape.javascript.JSObject;
import org.springframework.util.StringUtils;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@Slf4j
@WebFilter(urlPatterns = "/*")
public class LoginCheckFilter implements Filter {

    @Override//获取请求参数 响应结果 执行放行操作
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
        //类型的强制转换
        HttpServletRequest req = (HttpServletRequest) servletRequest;
        HttpServletResponse resp = (HttpServletResponse) servletResponse;

        //获取请求URL
        String url = req.getRequestURL().toString();
        log.info("获取请求的URL：{}",url);//记录日志
        //判断URL中是否包括Login
        if(url.contains("login")){
            //如果包含 则说明是登录操作，放行
            log.info("登录。。。放行");
            filterChain.doFilter(servletRequest,servletResponse);
            return;//程序退出 不再执行下面的操作
        }


        //不是登录操作的请求
        //获取请求头中的 令牌（token）
        String jwt = req.getHeader("token");

        //判断令牌是否存在
        if(!StringUtils.hasLength(jwt)){//令牌不存在
            //记录日志 返回错误结果
            log.info("请求头为空 返回未登录的信息");
            Result error = Result.error("NOT_LOGIN");
            //将Result转化为Json格式
            String notLogin = JSONObject.toJSONString(error);
            resp.getWriter().write(notLogin);
            return;
        }

        //如果令牌存在
        //解析token 如果解析失败 返回错误结果
        try {
            JwtUtils.parseJWT(jwt);
        }catch (Exception e){
            e.printStackTrace();
            log.info("令牌解析失败，返回登录错误信息");
            //将Result转化为Json格式
            Result error = Result.error("NOT_LOGIN");
            String notLogin = JSONObject.toJSONString(error);
            resp.getWriter().write(notLogin);
            return;
        }

        //执行到最后 那么令牌就是合法的
        //放行
        log.info("令牌合法，放行");
        filterChain.doFilter(servletRequest,servletResponse);
    }
}
