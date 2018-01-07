package com.gxp.batch;

import org.apache.ibatis.session.ExecutorType;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.springframework.util.CollectionUtils;

import java.lang.reflect.Method;
import java.util.List;

public class BatchMapperImpl implements BatchMapper {
    private SqlSessionFactory sqlSessionFactory;

    @Override
    public <C, T> boolean batch(Class<C> mapperClass, String method, List<T> data) {
        if (CollectionUtils.isEmpty(data)) {
            return false;
        }

        // 新获取一个模式为batch，自动提交为false的session
        SqlSession session = sqlSessionFactory.openSession(ExecutorType.BATCH, false);
        // 通过新的session获取mapper
        C mapper = session.getMapper(mapperClass);
        try {
            Class parameterType = data.get(0).getClass();
            Method m = mapper.getClass().getDeclaredMethod(method, parameterType);
            int size = data.size();
            for (int i = 1; i <= size; i++) {
                m.invoke(mapper, data.get(i - 1));
                if (i % 1000 == 0 || i == size) {
                    // 手动每1000个一提交，提交后无法回滚
                    session.commit();
                    // 清理缓存，防止溢出
                    session.clearCache();
                }
            }

        } catch (Exception e) {
            session.rollback();
            e.printStackTrace();
            return false;
        } finally {
            session.close();
        }
        return true;
    }

    public void setSqlSessionFactory(SqlSessionFactory sqlSessionFactory) {
        this.sqlSessionFactory = sqlSessionFactory;
    }
}
