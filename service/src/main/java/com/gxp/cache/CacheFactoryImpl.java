package com.gxp.cache;

import com.google.common.cache.*;

import java.util.concurrent.TimeUnit;

public class CacheFactoryImpl implements CacheFactory {
    @Override
    public <K, V> Cache<K, V> createExpireAfterWrite(final String name) {
        return CacheBuilder.newBuilder().removalListener(new RemovalListener<K, V>() {
            @Override
            public void onRemoval(RemovalNotification<K, V> removalNotification) {
                //============
            }
        }).expireAfterWrite(1, TimeUnit.MINUTES).build();
    }

    @Override
    public <K, V> LoadingCache<K, V> createRefreshAfterWrite(CacheLoader<K, V> loader) {
        // 指定1分钟才重新刷新一次缓存
        return CacheBuilder.newBuilder().refreshAfterWrite(1, TimeUnit.MINUTES).build(loader);
    }
}
