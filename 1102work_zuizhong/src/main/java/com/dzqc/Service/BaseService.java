package com.dzqc.Service;

import java.util.List;

public interface BaseService<E> {
    /**
     * 全查
     * @return
     */
    List<E> querrAll();

    /**
     * 条件查询
     * @param e
     * @return
     */
    List<E> querr(E e);

    /**
     * 新增方法
     * @param e
     * @return
     */
    Long add(E e);

    /**
     * 修改方法
     * @param e
     * @return
     */
    Integer edit(E e);

    /**
     * 删除方法
     * @param e
     * @return
     */
    Integer remove(E e);

    /**
     * 获取条数的方法
     * @param e
     * @return
     */
    Integer getCount(E e);
}
