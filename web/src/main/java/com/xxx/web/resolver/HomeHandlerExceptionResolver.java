package com.xxx.web.resolver;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.web.servlet.HandlerExceptionResolver;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class HomeHandlerExceptionResolver implements HandlerExceptionResolver {

    /**
     * 日志
     */
    //TODO
    private static final Log LOGGER = LogFactory.getLog(HomeHandlerExceptionResolver.class);

    /**
     * 这个位置可以拦截其他地方没有拦截(catch)到的错误，做个统一处理
     *
     * @param httpServletRequest
     * @param httpServletResponse
     * @param o
     * @param e
     * @return
     */
    @Override
    public ModelAndView resolveException(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, Object o, Exception e) {
        ModelAndView view = new ModelAndView();
        view.addObject("success", false);
        view.addObject("errorMsg", e.getMessage());
        return view;
    }
}
