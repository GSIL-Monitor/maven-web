package com.xxx.util.page;

import java.io.Serializable;

public class Paginator implements Serializable, Cloneable {

    public static final int DEFAULT_ITEMS_PRE_PAGE = 10;

    public static final int DEFAULT_SLIDER_SIZE = 7;

    public static final int UNKNOWN_ITEMS = Integer.MAX_VALUE;


    private int page;


    private int items;

    private int itemsPerPage;

    @Override
    public String toString() {
        return "Paginator{" +
                "page=" + page +
                ", items=" + items +
                ", itemsPerPage=" + itemsPerPage +
                '}';
    }

    public Paginator() {
        this(0);
    }

    public Paginator(int itemsPerPage) {
        this(itemsPerPage, UNKNOWN_ITEMS);
    }

    public Paginator(int itemsPerPage, int items) {
        this.items = (items >= 0) ? items : 0;
        this.itemsPerPage = (itemsPerPage > 0) ? itemsPerPage : DEFAULT_ITEMS_PRE_PAGE;
        this.page = calcPage(0);
    }

    public int getPages() {
        return (int) Math.ceil((double) items / itemsPerPage);
    }

    public int getPage() {
        return page;
    }

    public int setPage(int page) {
        return (this.page = calcPage(page));
    }

    public int getItems() {
        return items;
    }

    public int setItems(int items) {
        this.items = (items > 0) ? items : 0;
        setPage(page);
        return this.items;
    }

    public int getItemsPerPage() {
        return itemsPerPage;
    }

    public int setItemsPerPage(int itemsPerPage) {
        int tmp = this.itemsPerPage;
        this.itemsPerPage = (itemsPerPage > 0) ? itemsPerPage : DEFAULT_ITEMS_PRE_PAGE;
        if (page > 0) {
            setPage((int) (((double) (page - 1) * tmp) / this.itemsPerPage) + 1);
        }
        return this.itemsPerPage;
    }

    public int getOffset() {
        return (page > 0) ? (itemsPerPage * (page - 1)) : 0;
    }

    public int getLength() {
        if (page > 0) {
            return Math.min(itemsPerPage * page, items) - (itemsPerPage * (page - 1));
        } else {
            return 0;
        }
    }

    public int getBeginIndex() {
        if (page > 0) {
            return Math.min(itemsPerPage * page, items);
        } else {
            return 0;
        }
    }

    public int setItem(int itemOffset) {
        return setPage((itemOffset / itemsPerPage) + 1);
    }

    public int getFirstPage() {
        return calcPage(1);
    }

    public int getLastPage() {
        return calcPage(getPages());
    }

    public int getPreviousPage() {
        return calcPage(page - 1);
    }

    public int getPreviousPage(int n) {
        return calcPage(page - n);
    }

    public boolean isDisabledPage(int page) {
        return ((page < 1) || (page > getPages()) || (page == this.page));
    }

    public int[] getSlider() {
        return getSlider(DEFAULT_ITEMS_PRE_PAGE);
    }

    public int[] getSlider(int width) {
        int pages = getPages();
        if (pages < 1 || width < 1) {
            return new int[0];
        } else {
            if (width > pages) {
                width = pages;
            }

            int[] slider = new int[width];
            int first = page - ((width - 1) / 2);

            if (first < 1) {
                first = 1;
            }

            if (((first + width) - 1) > pages) {
                first = pages - width + 1;
            }

            for (int i = 0; i < width; i++) {
                slider[i] = first + i;
            }
            return slider;

        }
    }

    private int calcPage(int page) {
        int pages = getPages();
        if (pages > 0) {
            return (page < 1) ? 1 : ((page > pages) ? pages : page);
        } else {
            return 0;
        }
    }

    public Object clone() {
        try {
            return super.clone();
        } catch (CloneNotSupportedException e) {
            return null;
        }
    }
}
