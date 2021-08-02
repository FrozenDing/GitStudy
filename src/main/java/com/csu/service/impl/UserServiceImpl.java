package com.csu.service.impl;

import com.csu.dao.UserDao;
import com.csu.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;
import javax.annotation.Resource;

//<bean id="userService" class = "com.csu.service.impl.UserServiceImpl">
//<property name="userDao" ref="userDao"></property>
//</bean>

//@Component("userService")

@Service("userService")
//@Scope("prototype")
//@Scope("singleton")
public class UserServiceImpl implements UserService {

    // 可以直接在容器当中获取key对应的值
    @Value("${jdbc.driver}")
    private String dirver;

    @Autowired //单独写Autowaired，按照数据类型从Spring容器中进行匹配
   // @Qualifier("userDao")  //按照id值从容器中进行匹配，但要结合@Autowired一起用
   //    @Resource("userDao") 相当于@Autowired + @Qualifier
    private UserDao userDao;

//    public void setUserDao(UserDao userDao) {
//        this.userDao = userDao;
//    }
    @Override
    public void save() {
        System.out.println(dirver);
        userDao.save();
    }
    @PostConstruct
    public void init(){
        System.out.println("userService初始化");
    }
    @PreDestroy
    public void destroy(){
        System.out.println("userService销毁");
    }

}
