package com.itheima.aop;

import com.alibaba.fastjson.JSONObject;
import com.itheima.mapper.OperateLogMapper;
import com.itheima.pojo.OperateLog;
import com.itheima.utils.JwtUtils;
import io.jsonwebtoken.Claims;
import lombok.extern.slf4j.Slf4j;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.servlet.http.HttpServletRequest;
import java.lang.reflect.Array;
import java.time.LocalDateTime;
import java.util.Arrays;

@Slf4j
@Component
@Aspect //指定当前类为切面类
public class LogAspect {
    //依赖注入
    @Autowired
    private OperateLogMapper operateLogMapper;
    @Autowired
    private HttpServletRequest request;

    @Around("@annotation(com.itheima.anno.Log)") //指定为环绕通知-->基于注解切入-->相应注解
    public Object recordLog(ProceedingJoinPoint joinPoint) throws Throwable {//需要调用原始的方法运行
        //获取操作人信息
        //ID
        //通过解析jwt令牌进行获取
        String jwt = request.getHeader("token");
        Claims claims = JwtUtils.parseJWT(jwt);
        Integer operateUser = (Integer) claims.get("id");

        //操作时间
        LocalDateTime operateTime = LocalDateTime.now();

        //操作类名
        String className = joinPoint.getTarget().getClass().getName();

        //操作方法名
        String methodName = joinPoint.getSignature().getName();

        //操作方法参数
        Object[] args = joinPoint.getArgs();
        String methodParams = Arrays.toString(args);

        //记录开始时间-->记录方法耗时
        Long begin = System.currentTimeMillis();
        //调用原始方法运行
        Object result = joinPoint.proceed();
        //方法返回值
        String returnValue = JSONObject.toJSONString(result);
        //记录结束时间-->记录方法耗时
        Long end = System.currentTimeMillis();
        //方法操作耗时
        Long costTime = end - begin;

        //记录操作日志
        OperateLog operateLog = new OperateLog(null,operateUser,operateTime,className,methodName,methodParams,returnValue,costTime);
        operateLogMapper.insert(operateLog);
        log.info("通过AOP记录操作日志:{}",operateLog);
        return result;
    }
}
