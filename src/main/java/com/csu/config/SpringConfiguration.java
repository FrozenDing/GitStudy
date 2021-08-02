package com.csu.config;

import com.mchange.v2.c3p0.ComboPooledDataSource;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.*;

import javax.sql.DataSource;
import java.beans.PropertyVetoException;

//标志该类是spring的一个核心配置类
@Configuration

@ComponentScan("com.csu")//<context:component-scan base-package="com.csu">
                         //</context:component-scan>
@Import(DataSourceConfiguration.class)
public class SpringConfiguration {



}
