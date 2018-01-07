package com.gxp.batch;

import java.util.List;

/**
 * 做批量造作  通过SqlSession实现
 */
public interface BatchMapper {


    /**
     * 批量处理数据
     *
     * @param MapperClass 具体Mapper的累类名字
     * @param method      Mapper中具体要执行的方法名字，需要重新写在mapper.xml中，并且不能写如下的 selectKey
     *                    否则会造成批量插入的。。。
     *                    <p>
     *                    <selectKey keyProperty="id" order="AFTER"resultType="java.lang.Long">
     *                    SELECT LAST_INSERT_ID()
     *                    </selectKey>
     * @param data        list数据，实现类自动按照％1000提交
     * @param <C>         Mapper Class类型
     * @param <T>         数据DO类型
     * @return
     */
    <C, T> boolean batch(Class<C> MapperClass, String method, List<T> data);
}
