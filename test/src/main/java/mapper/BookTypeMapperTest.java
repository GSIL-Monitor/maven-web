package mapper;


import base.BaseAbstract;
import com.gxp.mapper.BookTypeMapper;
import com.gxp.model.BookType;
import com.xxx.util.page.Paginator;
import com.xxx.util.page.PaginatorConvert;
import org.junit.Assert;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

public class BookTypeMapperTest extends BaseAbstract {
    @Autowired
    private BookTypeMapper bookTypeMapper;

    @Test
    public void getAllBookTypesTest() {
        List<BookType> list = bookTypeMapper.getAllBookTypes(10, 1);
        Paginator paginator = PaginatorConvert.convertPageResult(list, 1, 10);
        Assert.assertNotNull(list);
    }

}
