package com.csu.dao.impl;

import com.csu.dao.UserDao;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;

//       <bean id="userDao" class = "com.csu.dao.impl.UserDaoImpl">

//@Component("userDao")
@Repository("userDao")
public class UserDaoImpl implements UserDao {

    @Override
    public void save() {
        System.out.println("saving");
    }
}
