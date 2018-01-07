///**
// * Shangshu
// * Copyright (c) 2017-2017 All Rights Reserved.
// */
//package com.shangshu.pms.util;
//
//import com.alibaba.common.lang.MessageUtil;
//import com.alibaba.common.lang.StringUtil;
//import com.alibaba.common.logging.Logger;
//
///**
// * 日志打印工具类
// *
// * @author wb-gxp214256
// * @version $Id: LoggerUtil.java, v 0.1 2017-05-26 wb-gxp214256 Exp $
// */
//public class LoggerUtil {
//    /**
//     * 摘要日志分割线
//     */
//    private static final String SPLITOR = "/";
//
//    /** DEFAULT */
//    private static final String DEFAULT = "default";
//
//    /**
//     * warn日志摘要
//     *
//     * @param logger
//     * @param message
//     */
//    public static void digestWarn(Logger logger, String message) {
//        logger.warn(formatLogger(null, message, null));
//    }
//
//    /**
//     * warn日志摘要
//     *
//     * @param logger
//     * @param message
//     * @param errorCode
//     */
//    public static void digestWarn(Logger logger, String message, Object errorCode) {
//        logger.warn(formatLogger(null, message, errorCode));
//    }
//
//    /**
//     * info日志摘要
//     *
//     * @param logger
//     * @param bizScene
//     * @param message
//     */
//    public static void digestInfo(Logger logger, String bizScene, String message) {
//        if (logger.isInfoEnabled()) {
//            logger.info(formatLogger(bizScene, message, null));
//        }
//    }
//
//    /**
//     * 日志格式调整
//     * @param bizScene
//     * @param message
//     * @param errorCode
//     *
//     * @return
//     */
//    private static String formatLogger(String bizScene, String message, Object errorCode) {
//        StringBuffer logStr = new StringBuffer();
//        // 加载场景
//        logStr.append(StringUtil.isNotBlank(bizScene) ? bizScene : DEFAULT);
//        logStr.append(SPLITOR);
//
//        // errorCode
//        logStr.append((errorCode != null && StringUtil.isNotBlank(errorCode.toString())) ? errorCode
//                : DEFAULT);
//        logStr.append(SPLITOR);
//
//        // message
//        logStr.append(StringUtil.isNotBlank(message) ? message : "");
//        return logStr.toString();
//    }
//
//    /**
//     * 输出info level的log信息.
//     *
//     * @param logger 日志记录器
//     * @param message log信息,如:<code>xxx{0},xxx{1}...</code>
//     * @param params log格式化参数,数组length与message参数化个数相同, 如:<code>Object[]  object=new Object[]{"xxx","xxx"}</code>
//     */
//    public static void info(Logger logger, String message, Object... params) {
//        if (logger.isInfoEnabled()) {
//            logger.info(format(message, params));
//        }
//    }
//
//    /**
//     * 输出info level的log信息.
//     *
//     * @param throwable 异常对象
//     * @param logger  日志记录器
//     * @param message log信息,如:<code>xxx{0},xxx{1}...</code>
//     * @param params log格式化参数,数组length与message参数化个数相同, 如:<code>Object[]  object=new Object[]{"xxx","xxx"}</code>
//     */
//    public static void info(Throwable throwable, Logger logger, String message, Object... params) {
//        if (logger.isInfoEnabled()) {
//            logger.info(format(message, params), throwable);
//        }
//    }
//
//    /**
//     * 输出warn level的log信息.
//     *
//     * @param logger 日志记录器
//     * @param message log信息,如:<code>xxx{0},xxx{1}...</code>
//     * @param params log格式化参数,数组length与message参数化个数相同, 如:<code>Object[]  object=new Object[]{"xxx","xxx"}</code>
//     */
//    public static void warn(Logger logger, String message, Object... params) {
//        if (logger.isWarnEnabled()) {
//            logger.warn(format(message, params));
//        }
//    }
//
//    /**
//     * 输出warn level的log信息.
//     *
//     * @param throwable 异常对象
//     * @param logger  日志记录器
//     * @param message log信息,如:<code>xxx{0},xxx{1}...</code>
//     * @param params log格式化参数,数组length与message参数化个数相同, 如:<code>Object[]  object=new Object[]{"xxx","xxx"}</code>
//     */
//    public static void warn(Throwable throwable, Logger logger, String message, Object... params) {
//        if (logger.isWarnEnabled()) {
//            logger.warn(format(message, params), throwable);
//        }
//    }
//
//    /**
//     * 输出debug level的log信息.
//     *
//     * @param logger  日志记录器
//     * @param message log信息,如:<code>xxx{0},xxx{1}...</code>
//     * @param params log格式化参数,数组length与message参数化个数相同, 如:<code>Object[]  object=new Object[]{"xxx","xxx"}</code>
//     */
//    public static void debug(Logger logger, String message, Object... params) {
//        if (logger.isDebugEnabled()) {
//            logger.debug(format(message, params));
//        }
//    }
//
//    /**
//     * 输出debug level的log信息.
//     *
//     * @param throwable 异常对象
//     * @param logger  日志记录器
//     * @param message log信息,如:<code>xxx{0},xxx{1}...</code>
//     * @param params log格式化参数,数组length与message参数化个数相同, 如:<code>Object[]  object=new Object[]{"xxx","xxx"}</code>
//     */
//    public static void debug(Throwable throwable, Logger logger, String message, Object... params) {
//        if (logger.isDebugEnabled()) {
//            logger.debug(format(message, params), throwable);
//        }
//    }
//
//    /**
//     * 输出error level的log信息.
//     *
//     * @param logger  日志记录器
//     * @param message log信息,如:<code>xxx{0},xxx{1}...</code>
//     * @param params log格式化参数,数组length与message参数化个数相同, 如:<code>Object[]  object=new Object[]{"xxx","xxx"}</code>
//     */
//    public static void error(Logger logger, String message, Object... params) {
//        if (logger.isErrorEnabled()) {
//            logger.error(format(message, params));
//        }
//    }
//
//    /**
//     * 输出error level的log信息.
//     *
//     * @param throwable 异常对象
//     * @param logger  日志记录器
//     * @param message log信息,如:<code>xxx{0},xxx{1}...</code>
//     * @param params log格式化参数,数组length与message参数化个数相同, 如:<code>Object[]  object=new Object[]{"xxx","xxx"}</code>
//     */
//    public static void error(Throwable throwable, Logger logger, String message, Object... params) {
//        if (logger.isErrorEnabled()) {
//            logger.error(format(message, params), throwable);
//        }
//    }
//
//    /**
//     * 日志信息参数化格式化
//     *
//     * @param message log信息,如:<code>xxx{0},xxx{1}...</code>
//     * @param params log格式化参数,数组length与message参数化个数相同, 如:<code>Object[]  object=new Object[]{"xxx","xxx"}</code>
//     */
//    private static String format(String message, Object... params) {
//        if (params != null && params.length != 0) {
//            return MessageUtil.formatMessage(message, params);
//        }
//        return message;
//
//    }
//}
