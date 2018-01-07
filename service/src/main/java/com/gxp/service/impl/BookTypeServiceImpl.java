package com.gxp.service.impl;

import com.gxp.mapper.BookTypeMapper;
import com.gxp.model.BookType;
import com.gxp.model.BookTypeListModel;
import com.gxp.service.BookTypeService;
import com.xxx.util.page.PaginatorConvert;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class BookTypeServiceImpl implements BookTypeService {

    @Autowired
    private BookTypeMapper bookTypeMapper;

    @Override
    public BookTypeListModel getAllBookTypes(int pageSize, int pageNum) {

        BookTypeListModel model = new BookTypeListModel();
        List<BookType> list = bookTypeMapper.getAllBookTypes(pageSize, pageNum);
        // 分页信息获取
        model.setPaginator(PaginatorConvert.convertPageResult(list, pageNum, pageSize));
        model.setList(list);
        return model;
    }
}
