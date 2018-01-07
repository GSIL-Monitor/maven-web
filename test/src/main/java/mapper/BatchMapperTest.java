package mapper;

import base.BaseAbstract;
import com.gxp.batch.BatchMapper;
import com.gxp.model.BookType;
import org.junit.Assert;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.ArrayList;
import java.util.List;

public class BatchMapperTest extends BaseAbstract {

    @Autowired
    private BatchMapper batchMapper;

    @Test
    public void getAllBookTypesTest() {
        List<BookType> bookList = new ArrayList<BookType>();
        for (int i = 0; i < 20; i++) {
            BookType bookType = new BookType();
            bookType.setTypename("--" + i);
            bookList.add(bookType);
        }

        // 防止每次启动测试代码的时候都有插入
        // batchMapper.batch(BookTypeMapper.class, "insertNoKey", bookList);
        Assert.assertNotNull(bookList);
    }

}
