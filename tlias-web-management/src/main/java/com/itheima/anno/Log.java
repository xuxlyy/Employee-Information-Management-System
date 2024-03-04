package com.itheima.anno;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Retention(RetentionPolicy.RUNTIME)//指定注解生效的时间-->运行时有效
@Target(ElementType.METHOD)//注解在哪里使用
//注解 起到一个标识的作用
public @interface Log {
}
