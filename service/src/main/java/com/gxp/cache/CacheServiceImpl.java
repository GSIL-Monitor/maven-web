package com.gxp.cache;

import com.google.common.cache.CacheLoader;
import com.google.common.cache.LoadingCache;
import com.google.common.util.concurrent.ListenableFuture;
import com.google.common.util.concurrent.ListeningExecutorService;
import com.google.common.util.concurrent.MoreExecutors;
import com.gxp.mapper.BookTypeMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.Callable;
import java.util.concurrent.Executors;

@Component
public class CacheServiceImpl implements CacheService {

    @Autowired
    private CacheFactory cacheFactory;

    private LoadingCache<String, List<String>> listCache;

    @Autowired
    private BookTypeMapper bookTypeMapper;

    private static ListeningExecutorService EXECUTOR = MoreExecutors.listeningDecorator(Executors.newFixedThreadPool(2));

    @Override
    public List<String> fastQueryList(String type) {
        return listCache.getUnchecked(type);
    }

    public void init() {
        this.listCache = cacheFactory.createRefreshAfterWrite(new CacheLoader<String, List<String>>() {
            @Override
            public List<String> load(String key) throws Exception {
                return queryList(key);
            }

            @Override
            public ListenableFuture<List<String>> reload(final String key, List<String> oldValue) throws Exception {
                return EXECUTOR.submit(new Callable<List<String>>() {
                    @Override
                    public List<String> call() throws Exception {
                        return queryList(key);
                    }
                });
            }
        });
    }

    private List<String> queryList(String type) {

        return bookTypeMapper.getAll();
    }
}
