package service;

import base.BaseAbstract;
import com.gxp.mapper.BookTypeMapper;
import com.gxp.model.BookType;
import com.gxp.model.BookTypeListModel;
import com.gxp.service.BookTypeService;
import org.junit.Assert;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

public class BookTypeServiceTest extends BaseAbstract {
    @Autowired
    private BookTypeService bookTypeService;

    @Test
    public void getAllBookTypesTest() {
        BookTypeListModel model = bookTypeService.getAllBookTypes(10, 1);

        Assert.assertNotNull(model);
    }

}
