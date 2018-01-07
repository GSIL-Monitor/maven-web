package com.xxx.util.annonation;


import java.lang.annotation.*;

/**
 * 鉴权注解，多个权限中的某个
 * <p>
 * 用来在方法访问前看用户是否有访问权限
 */
@Target({ElementType.METHOD, ElementType.TYPE})
@Retention(RetentionPolicy.RUNTIME)
@Documented
public @interface RequireAnyRole {
    String[] values();
}
