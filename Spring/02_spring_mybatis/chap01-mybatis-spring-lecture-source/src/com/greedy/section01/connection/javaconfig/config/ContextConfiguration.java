package com.greedy.section01.connection.javaconfig.config;

import org.apache.commons.dbcp.BasicDataSource;
import org.apache.ibatis.session.SqlSessionFactory;
import org.mybatis.spring.SqlSessionFactoryBean;
import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;

@Configuration
@ComponentScan("com.greedy.section01.connection.javaconfig")
@PropertySource("connection-info.properties")
public class ContextConfiguration {

	@Value("${oracle.dev.driver}")
	private String driver;
	@Value("${oracle.dev.url}")
	private String url;
	@Value("${oracle.dev.username}")
	private String username;
	@Value("${oracle.dev.password}")
	private String password;
	
	// BasicDataSource를 사용하려면
	// commons-dbcp 라이브러리 추가
	// commons-pool이 의존관계에 있기 때문에 다시한번 추가
	@Bean(destroyMethod = "close")
	public BasicDataSource dataSource() {
		
		BasicDataSource dataSource = new BasicDataSource();
		
//		dataSource.setDriverClassName("oracle.jdbc.driver.OracleDriver");
//	    dataSource.setUrl("jdbc:log4jdbc:oracle:thin:@localhost:1521:xe");
//	    dataSource.setUsername("GREEDY");
//	    dataSource.setPassword("GREEDY");
//	    dataSource.setDefaultAutoCommit(false);   // 수동 커밋
		
		dataSource.setDriverClassName(driver);
	    dataSource.setUrl(url);
	    dataSource.setUsername(username);
	    dataSource.setPassword(password);
	    dataSource.setDefaultAutoCommit(false);
	    
	    return dataSource;
		
	}
	
	@Bean
	public SqlSessionFactory sqlSessionFactory(ApplicationContext context) throws Exception {
		
		// SqlSessionFactoryBean은 mybatis-spring 라이브러리 추가
		SqlSessionFactoryBean factoryBean = new SqlSessionFactoryBean();
		factoryBean.setDataSource(dataSource());
		
		// mybatis 설정값 추가
		factoryBean.setConfigLocation(context.getResource("com/greedy/section01/connection/javaconfig/config/mybatis-config.xml")); //xml을 가져올때는 폴더(/사용),  자바파일은 패키지(.사용)로 가져옴..?
		
		return factoryBean.getObject();
	}
	
	@Bean
	public SqlSessionTemplate sqlSessionTemplate(ApplicationContext context) throws Exception {
		
		// 추가 라이브러리가 존재
		// spring-jdbc 라이브러리 추가
		return new SqlSessionTemplate(sqlSessionFactory(context));
	}
}
