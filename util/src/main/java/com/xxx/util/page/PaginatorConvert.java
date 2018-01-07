package com.xxx.util.page;

import com.github.pagehelper.Page;

import java.util.List;

public class PaginatorConvert {
    /**
     * 转换为分页结果
     *
     * @param data     列表数据
     * @param pageNum  当前页
     * @param pageSize 每页大小
     * @param <T>      T
     */

    public static <T> Paginator convertPageResult(List<T> data, int pageNum, int pageSize) {
        Paginator paginator;
        if (data == null || !(data instanceof Page)) {
            paginator = new Paginator(pageSize, 0);
            paginator.setPage(pageNum);
            return paginator;
        }
        long total = ((Page<?>) data).getTotal();
        paginator = new Paginator(pageSize, (int) total);
        paginator.setPage(pageNum);
        return paginator;
    }
}
