package com.mes.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.EnableAspectJAutoProxy;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;

import com.mes.aop.AspectOriented;
import com.mes.dao.MesErpDao;
import com.mes.dao.impl.MesErpDaoImpl;

@Configuration 
@ComponentScan("com.mes") 
@EnableWebMvc 
@EnableAspectJAutoProxy(proxyTargetClass=true)
public class AppConfig {

	
	
	
}
