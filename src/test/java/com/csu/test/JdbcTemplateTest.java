package com.csu.test;

import com.csu.domain.Account;
import com.mchange.v2.c3p0.ComboPooledDataSource;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.web.context.support.WebApplicationContextUtils;

import javax.naming.CompositeName;
import java.beans.PropertyVetoException;
import java.util.List;

public class JdbcTemplateTest {

//    测试jdbc模板
    @Test
    public void Test1() throws PropertyVetoException {

        ComboPooledDataSource dataSource = new ComboPooledDataSource();
        dataSource.setDriverClass("com.mysql.cj.jdbc.Driver");
        dataSource.setUser("root");
        dataSource.setPassword("admin");
        dataSource.setJdbcUrl("jdbc:mysql://localhost:3306/ding?useUnicode=true&characterEncoding=utf-8&useSSL=false&serverTimezone=UTC");
        JdbcTemplate jdbcTemplate = new JdbcTemplate();
        jdbcTemplate.setDataSource(dataSource);
        int row=jdbcTemplate.update("insert into account values(?,?)","丁锐",5000.5);
        System.out.println(row);

    }

    @Test
    public void Test2() throws PropertyVetoException {

        ApplicationContext app = new ClassPathXmlApplicationContext("applicationContext.xml");
        JdbcTemplate jdbcTemplate = (JdbcTemplate) app.getBean("jdbcTemplate");
        //增、删、改都用jdbcTemplate.update（sql）
//        int row=jdbcTemplate.update("insert into account values(?,?)","邓琪",5000.56);
//        int row = jdbcTemplate.update("update account set money=? where username =?",10000,"丁锐");
//        int row = jdbcTemplate.update("delete from account where username =?","丁锐");

        //查询多个对象
        List<Account> row = jdbcTemplate.query("select * from account",new BeanPropertyRowMapper<Account>(Account.class));
        System.out.println(row);
        //查询单个对象
        Account account = jdbcTemplate.queryForObject("select * from account where username=?",new BeanPropertyRowMapper<Account>(Account.class),"邓琪");
        System.out.println(account);
        //聚合查询,返回简单类型
        double count=  jdbcTemplate.queryForObject("select count(*) from account",double.class);
        System.out.println(count);

    }
}
