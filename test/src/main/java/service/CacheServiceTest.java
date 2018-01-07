package service;

import base.BaseAbstract;
import com.gxp.cache.CacheService;
import com.gxp.mapper.BookTypeMapper;
import com.gxp.model.BookType;
import org.junit.Assert;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

public class CacheServiceTest extends BaseAbstract {
    @Autowired
    private CacheService cacheService;

    @Autowired
    private BookTypeMapper bookTypeMapper;

    @Test
    public void getAllBookTypesTest() throws InterruptedException {
        List<String> model = cacheService.fastQueryList("ss");

        BookType type = new BookType();
        type.setTypename("test");
        bookTypeMapper.insert(type);

        List<String> model2 = cacheService.fastQueryList("ss");

        Thread.sleep(70000L);
        List<String> model3 = cacheService.fastQueryList("ss");

        Assert.assertNotNull(model);
    }

}
