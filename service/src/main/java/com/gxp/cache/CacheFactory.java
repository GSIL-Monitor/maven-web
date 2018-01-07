package com.gxp.cache;


import com.google.common.cache.Cache;
import com.google.common.cache.CacheLoader;
import com.google.common.cache.LoadingCache;

/**
 * 基于Google Guava Cache 构建缓存构造器
 */
public interface CacheFactory {

    /**
     * 注意：对于同一个Key，只让一个请求回源load数据，其他线程阻塞等待结果
     *
     * @param name 缓存对象的名称
     * @param <K>
     * @param <V>
     * @return 缓存器
     */
    <K, V> Cache<K, V> createExpireAfterWrite(String name);

    /**
     * 注意：CacheLoager同步的去refresh V
     *
     * @param loder CacheLoader
     * @param <K>
     * @param <V>
     * @return 缓存器
     */
    <K, V> LoadingCache<K, V> createRefreshAfterWrite(CacheLoader<K, V> loder);

}
