package com.gxp.mapper;

import com.gxp.model.BookType;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface BookTypeBaseMapper {
    /**
     * 获得所有图书类型
     */
    List<BookType> getAllBookTypes(@Param(value = "pageSize") int pageSize, @Param(value = "pageNum") int pageNum);

    /**
     * 数据插入
     */
    public void insertNoKey(BookType bookType);


    /**
     * 获得所有图书类型
     */
    List<String> getAll();
}
