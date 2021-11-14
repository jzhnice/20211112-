package com.dzqc.Service.impl;

import com.dzqc.Dao.BaseDao;
import com.dzqc.Dao.impl.userDaoimpl;
import com.dzqc.Service.BaseService;
import com.dzqc.Service.UserService;
import com.dzqc.entity.User;

import java.util.List;

public class UserServiceImpl  implements UserService {
    private BaseDao dao = new userDaoimpl();

    @Override
    public List<User> querrAll() {
        try {
            return dao.select(null);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    @Override
    public List<User> querr(User user) {
        try {
            return dao.select(user);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    @Override
    public Long add(User user) {
        try {
            return dao.insert(user);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    @Override
    public Integer edit(User user) {
        try {
            return dao.update(user);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return 0;
    }

    @Override
    public Integer remove(User user) {
        try {
            return dao.delete(user);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    @Override
    public Integer getCount(User user) {
        try {
            return dao.getCount(user);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return 0;
    }
}
