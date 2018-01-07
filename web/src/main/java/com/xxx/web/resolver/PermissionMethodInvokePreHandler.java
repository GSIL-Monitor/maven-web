package com.xxx.web.resolver;

import com.xxx.util.annonation.RequirePermission;
import org.springframework.core.annotation.AnnotationUtils;
import org.springframework.web.method.HandlerMethod;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.lang.reflect.Method;
import java.util.Arrays;
import java.util.Map;

/**
 * 登录权限拦截器
 */
public class PermissionMethodInvokePreHandler implements HandlerInterceptor {

    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {

        // 可以通过注解，分配类访问权限
        RequirePermission annotation = AnnotationUtils.findAnnotation(handler.getClass(), RequirePermission.class);
        String str = annotation.value();

        Method method = handler.getClass().getMethod("queryBookTypeList", HttpServletResponse.class);
        RequirePermission methodAnnotation = AnnotationUtils.findAnnotation(method, RequirePermission.class);
        String str1 = methodAnnotation.value();

        // 方法访问权限判断
        if (handler instanceof HandlerMethod) {
            HandlerMethod handlerMethod = (HandlerMethod) handler;
            checkMethodPermission(handlerMethod);
        }

        if (handler instanceof HandlerMethod) {
            StringBuilder sb = new StringBuilder(1000);

//            sb.append("-----------------------").append(SimpleDateFormatCache.getYmdhms().format(new Date()))
//                    .append("-------------------------------------\n");
            HandlerMethod h = (HandlerMethod) handler;
            sb.append("Controller: ").append(h.getBean().getClass().getName()).append("\n");
            sb.append("Method    : ").append(h.getMethod().getName()).append("\n");
            sb.append("Params    : ").append(getParamString(request.getParameterMap())).append("\n");
            sb.append("URI       : ").append(request.getRequestURI()).append("\n");
            System.out.println(sb.toString());
        }

        System.out.println("--------------------------");
        System.out.println("-----preHandle-----");
        System.out.println("-----+++++++");
        System.out.println("-----+++++++");
        System.out.println("--------------------------");
        return true;
    }

    private void checkMethodPermission(HandlerMethod handlerMethod) {
//        RequirePermission annotation = AnnotationUtils.findAnnotation(handlerMethod, RequirePermission.class);
        RequirePermission annotation = handlerMethod.getMethodAnnotation(RequirePermission.class);
        String str = annotation.value();
        System.out.println("-----+++++++");
    }

    private String getParamString(Map<String, String[]> map) {
        StringBuilder sb = new StringBuilder();
        for (Map.Entry<String, String[]> e : map.entrySet()) {
            sb.append(e.getKey()).append("=");
            String[] value = e.getValue();
            if (value != null && value.length == 1) {
                sb.append(value[0]).append("\t");
            } else {
                sb.append(Arrays.toString(value)).append("\t");
            }
        }
        return sb.toString();
    }

    @Override
    public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler, ModelAndView modelAndView) throws Exception {
        System.out.println("--------------------------");
        System.out.println("-----postHandle-----");

        long startTime = (Long) request.getAttribute("startTime");
        long endTime = System.currentTimeMillis();
        long executeTime = endTime - startTime;
        if (handler instanceof HandlerMethod) {
            StringBuilder sb = new StringBuilder(1000);
            sb.append("CostTime  : ").append(executeTime).append("ms").append("\n");
            sb.append("postHandle -------------------------------------------------------------------------------");
            System.out.println(sb.toString());
        }
        System.out.println("--------------------------");
    }


    @Override
    public void afterCompletion(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, Object o, Exception e) throws Exception {
        System.out.println("--------------------------");
        System.out.println("-----afterCompletion-----");
        System.out.println("-----+++++++");
        System.out.println("-----+++++++");
        System.out.println("--------------------------");
    }
}
