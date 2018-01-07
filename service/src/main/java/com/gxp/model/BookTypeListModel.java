package com.gxp.model;

import com.xxx.util.page.Paginator;

import java.util.List;

public class BookTypeListModel {

    private List<BookType> list;
    private Paginator paginator;

    public List<BookType> getList() {
        return list;
    }

    public void setList(List<BookType> list) {
        this.list = list;
    }

    public Paginator getPaginator() {
        return paginator;
    }

    public void setPaginator(Paginator paginator) {
        this.paginator = paginator;
    }
}
