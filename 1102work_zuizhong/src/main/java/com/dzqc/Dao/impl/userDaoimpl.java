package com.dzqc.Dao.impl;

import com.dzqc.Dao.UserDao;
import com.dzqc.entity.User;
import com.dzqc.until.JDBCUtil;

import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanListHandler;
import org.apache.commons.dbutils.handlers.ScalarHandler;
import org.jetbrains.annotations.NotNull;

import java.math.BigInteger;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class userDaoimpl implements UserDao {
    /**
     * 全查和条件查询
     *
     * @param user
     * @return
     * @throws Exception
     */
    @Override
    public List<User> select(User user) throws Exception {
        String sql = "select*from news_user where 1=1";
        List<Object> params = new ArrayList<>();
        Connection conn;
        conn = JDBCUtil.getConn();
        if (null != user) {
            if (user.getUserName() != null && !"".equals(user.getUserName())) {
                sql += "  and  userName =  ? ";
                params.add(user.getUserName());
            }

            if (user.getPassword() != null && !"".equals(user.getPassword())) {
                sql += " and  Password = ?";
                params.add(user.getPassword());
            }
            if (user.getEmail() != null && !"".equals(user.getEmail())) {
                sql += " and  Email = ?";
                params.add(user.getEmail());
            }
            if (user.getId() != null && user.getId().longValue() != 0L) {
                sql += " and  Id = ?";
                params.add(user.getId());
            }
            if (user.getPage() != null && user.getPageSize() != null) {
                sql += " limit ?,?";
                params.add(user.getBeginCount());
                params.add(user.getPageSize());
            }
            List<User> query = new QueryRunner().query(conn, sql, new BeanListHandler<>(User.class), params.toArray());
            return query;


        } else {
            List<User> query = new QueryRunner().query(conn, sql, new BeanListHandler<>(User.class));
            return query;
        }
    }

    /**
     * 新增
     *
     * @param user
     * @return
     * @throws Exception
     */
    @Override
    public Long insert(@NotNull User user) throws Exception {
        if (user.getUserName() == null || user.getPassword() == null || user.getEmail() == null
                || "".equals(user.getUserName()) || "".equals(user.getPassword()) || "".equals(user.getEmail())) {
            throw new NullPointerException("关键属性不能为空");
        }
        String sql = "insert into news_user( userName,password,email ) values( ? , ? , ? )";
        Object[] params = new Object[3];
        params[0] = user.getUserName();
        params[1] = user.getPassword();
        params[2] = user.getEmail();
        Connection conn = JDBCUtil.getConn();
        long l = new QueryRunner().insert(conn, sql, new ScalarHandler<BigInteger>(), params).longValue();
        return l;
    }


    /**
     * 修改
     *
     * @param user
     * @return
     * @throws Exception
     */
    @Override
    public int update(User user) throws Exception {
        if (user.getId() == null) {
            throw new NullPointerException("修改时主键ID不能为空");
        }
        String sql = "update news_user set";
        List<Object> params = new ArrayList<>();
        if (user.getUserName() != null && !"".equals(user.getUserName())) {
            sql += "    userName =  ?, ";
            params.add(user.getUserName());
        }

        if (user.getPassword() != null && !"".equals(user.getPassword())) {
            sql += "   Password = ?,";
            params.add(user.getPassword());
        }
        if (user.getEmail() != null && !"".equals(user.getEmail())) {
            sql += "   Email = ?,";
            params.add(user.getEmail());
        }
        sql = sql.substring(0, sql.lastIndexOf(","));
        sql += "where id = ? ";
        params.add(user.getId());
        Connection conn = JDBCUtil.getConn();
        int update = new QueryRunner().update(conn, sql, params.toArray());
        return update;
    }

    /**
     * 删除
     *
     * @param user
     * @return
     * @throws Exception
     */
    @Override
    public int delete(@NotNull User user) throws Exception {
        if (user.getUserName() == null || "".equals(user.getUserName())) {
            throw new NullPointerException("删除的用户名不能为空");
        }
        String sql = "delete from news_user where userName = ?";
        Connection conn = JDBCUtil.getConn();
        int update = new QueryRunner().update(conn, sql, user.getUserName());
        return update;
    }

    /**
     * 分页查询的页数
     *
     * @param user
     * @return
     * @throws Exception
     */
    @Override
    public int getCount(User user) throws Exception {
        String sql = "select count(*)from news_user where 1=1";
        List<Object> params = new ArrayList<>();
        Connection conn;
        conn = JDBCUtil.getConn();
        if (null != user) {
            if (user.getUserName() != null && !"".equals(user.getUserName())) {
                sql += "  and  userName =  ? ";
                params.add(user.getUserName());
            }

            if (user.getPassword() != null && !"".equals(user.getPassword())) {
                sql += " and  Password = ?";
                params.add(user.getPassword());
            }
            if (user.getEmail() != null && !"".equals(user.getEmail())) {
                sql += " and  Email = ?";
                params.add(user.getEmail());
            }
            if (user.getId() != null && user.getId().longValue() != 0L) {
                sql += " and  Id = ?";
                params.add(user.getId());
            }
            if (user.getPage() != null && user.getPageSize() != null) {
                sql += " limit ?,?";
                params.add(user.getBeginCount());
                params.add(user.getPageSize());
            }
            Integer count = new QueryRunner().query(conn, sql, new ScalarHandler<Integer>(), params.toArray());
            return count;


        } else {
            Integer count = new QueryRunner().query(conn, sql, new ScalarHandler<Integer>(), params.toArray());
            return count;
        }

    }


}
