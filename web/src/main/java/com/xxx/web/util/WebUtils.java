package com.xxx.web.util;

import com.alibaba.fastjson.JSON;
import org.apache.commons.lang3.StringUtils;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

public class WebUtils {
    /* 日志 */
    private final static Log LOGGER = LogFactory.getLog(WebUtils.class);

    /* header常量定义 */
    private static final String HEADER_ENCONDING = "encoding";
    private static final String HEADER_NOCACHE = "no-cache";
    private static final String DEFAULT_ENCODING = "UTF-8";
    private static final boolean DEFAULT_NOCACHE = true;

    /* Content Type 定义 */
    private static final String JSON_TYPE = "application/json";
    private static final String HTML_TYPE = "text/html";

    private WebUtils() {

    }

    /**
     * 直接输出内容的简便函数
     * <p>
     * eg.
     * render(response,"text/plain","hello","encodeing:GBK");
     * render(response,"text/plain","hello","no-cache:false");
     * render(response,"text/plain","hello","encodeing:GBK","no-cache:false");
     *
     * @param headers 可变的header数组，目前接受的值为"encoding"或"no-cache",默认分别是UTF-8和true
     */
    public static void render(HttpServletResponse response, String contentType, String content, String... headers) {
        initResponseHeader(response, contentType, headers);
        try {
            response.getWriter().write(content);
            response.getWriter().flush();
        } catch (IOException e) {
            throw new RuntimeException(e.getMessage(), e);
        }
    }

    /**
     * 直接输出JSON，使用JSON转换Java对象
     *
     * @param data 可以是任何类型的数据 List、Map、POJO
     */
    public static void renderJson(HttpServletResponse response, Object data, String... headers) {
        initResponseHeader(response, JSON_TYPE, headers);
        String jsonString = JSON.toJSONString(data);
        render(response, JSON_TYPE, jsonString, headers);
    }

    /**
     * 直接输出JSON ie type，使用JSON转换Java对象
     *
     * @param data 可以是任何类型的数据 List、Map、POJO
     */
    public static void renderJsonIE(HttpServletResponse response, Object data, String... headers) {
        initResponseHeader(response, HTML_TYPE, headers);
        String jsonString = JSON.toJSONString(data);
        render(response, HTML_TYPE, jsonString, headers);
    }

    /**
     * 分析并设置contentType与headers
     *
     * @param response
     * @param contentType
     * @param headers
     */
    private static HttpServletResponse initResponseHeader(HttpServletResponse response, String contentType, String... headers) {
        // 1.分析header参数
        String encoding = DEFAULT_ENCODING;
        boolean noCache = DEFAULT_NOCACHE;
        for (String header : headers) {
            String headerName = StringUtils.substringBefore(header, ":");
            String headerValue = StringUtils.substringAfter(header, ":");
            if (StringUtils.equalsIgnoreCase(headerName, HEADER_ENCONDING)) {
                encoding = headerValue;
            } else if (StringUtils.equalsIgnoreCase(headerName, HEADER_NOCACHE)) {
                noCache = Boolean.parseBoolean(headerValue);
            } else {
                throw new IllegalArgumentException(header + "不是合法的header类型");
            }
        }

        //设置headers参数
        String fullContentType = contentType + ";charset=" + encoding;
        response.setContentType(fullContentType);

        if (noCache) {
            // Http 1.0 header
            response.setDateHeader("Expires", 1L);
            response.addHeader("Pragma", "no-cache");
            // Http 1.1 header
            response.setHeader("Cache-Control", "no-cache,no-store,max-age=0");
        }
        return response;
    }

    public static void downloadFile(HttpServletResponse response, String fileName, byte[] data) {
        try {
            response.setContentType("application/octet-stream");
            response.addHeader("Content-Disposition", "attachment;filename=" + fileName);
            ServletOutputStream out = response.getOutputStream();
            out.flush();
            out.close();

        } catch (IOException e) {
            // TODO
        }

    }

    /**
     * 判断一个url是否是ajax请求
     *
     * @param url
     */
    public static boolean isAjaxUrl(String url) {
        int pos = url.indexOf('?');
        if (pos != 1) {
            url = url.substring(0, pos);
        }
        return url.toLowerCase().endsWith(".json");
    }


    public static void writeJson(HttpServletResponse response, Object data) {
        PrintWriter write = null;
        try {
            response.setContentType("application/json");
            response.setCharacterEncoding(DEFAULT_ENCODING);
            response.setHeader("Cache-Control", "no-cache");
            write = response.getWriter();
            String json = JSON.toJSONString(data);
            write.write(json);
            write.flush();
        } catch (Exception e) {
            // TODO
        } finally {
            if (null != write) {
                write.close();

            }
        }
    }

    public static void writeJsonp(HttpServletResponse response, String callback, Object data) {
        PrintWriter write = null;
        try {
            response.setContentType("application/json");
            response.setCharacterEncoding(DEFAULT_ENCODING);
            response.setHeader("Cache-Control", "no-cache");
            write = response.getWriter();
            String jsonp = String.format("%s(%s)", callback, JSON.toJSONString(data));
            write.write(jsonp);
            write.flush();
        } catch (Exception e) {
            // TODO
        } finally {
            if (null != write) {
                write.close();

            }
        }

    }
}
