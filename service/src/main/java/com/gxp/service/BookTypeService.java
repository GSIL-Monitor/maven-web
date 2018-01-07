package com.gxp.service;

import com.gxp.model.BookTypeListModel;

public interface BookTypeService {
    /**
     * 获得所有图书类型
     */
    BookTypeListModel getAllBookTypes(int pageSize, int pageNum);
}
