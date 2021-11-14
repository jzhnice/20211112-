package com.dzqc.Dao;

import java.util.List;

public interface BaseDao<E> {
    /**
     * 查询
     * @param e
     * @return
     */
    List<E> select(E e) throws  Exception;

    /**
     * 新增
     * @param e
     * @return
     */
    Long insert(E e)  throws  Exception;

    /**
     * 修改
     * @param e
     * @return
     */
    int update(E e)  throws  Exception;

    /**
     * 删除
     * @param e
     * @return
     */
    int delete(E e)  throws  Exception;

    /**
     * 获取数据条数
     * @param e
     * @return
     */
    int getCount(E e)  throws  Exception;
}
