package com.dzqc.test;

import com.dzqc.Dao.BaseDao;
import com.dzqc.Dao.impl.userDaoimpl;
import com.dzqc.entity.User;
import org.junit.Test;

import java.util.List;

public class Unitel {
    /**
     * 查看
     *
     * @throws Exception
     */
    @Test
    public void daoSel() throws Exception {
        BaseDao dao = new userDaoimpl();
        List select = dao.select(null);
        select.forEach(u -> {
            System.out.println(u);
        });
        System.out.println("---------------------");
        User user = new User();
        user.setUserName("user");
        List select1 = dao.select(user);
        select1.forEach(u -> {
            System.out.println(u);
        });
    }

    /**
     * 新增
     *
     * @throws Exception
     */
    @Test
    public void insTest() throws Exception {
        BaseDao dao = new userDaoimpl();
        User user = new User();
        user.setUserName("张三丰");
        user.setPassword("000000");
        user.setEmail("123@321");
        Long insert = dao.insert(user);
        user = new User();
        user.setId(insert);
        List select = dao.select(user);
        select.forEach(u -> {
            System.out.println(u);
        });
    }

    /**
     * 修改
     * @throws Exception
     */
    @Test
    public void updTest() throws Exception {
        BaseDao dao = new userDaoimpl();
        User user = new User();
        user.setId(13L);
        user.setEmail("10086@10010");
        dao.update(user);

        List select = dao.select(user);
        select.forEach(u -> {
            System.out.println(u);
        });


    }

@Test
    public void delTes() throws Exception {
    BaseDao dao = new userDaoimpl();
    User user = new User();
    user.setUserName("张三丰");

    dao.delete(user);







    }

}
