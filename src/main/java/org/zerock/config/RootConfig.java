package org.zerock.config;

import javax.sql.DataSource;

import org.apache.ibatis.session.SqlSessionFactory;
import org.mybatis.spring.SqlSessionFactoryBean;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.EnableAspectJAutoProxy;
import org.springframework.jdbc.datasource.DataSourceTransactionManager;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.transaction.annotation.EnableTransactionManagement;

import com.zaxxer.hikari.HikariConfig;
import com.zaxxer.hikari.HikariDataSource;

//root-context대신
@Configuration //스프링 관련 설정 시
@ComponentScan(basePackages= {"org.zerock.service","org.zerock.aop"})
@MapperScan(basePackages= {"org.zerock.mapper"})
@EnableAspectJAutoProxy
@EnableTransactionManagement
@EnableScheduling
public class RootConfig {
	//빈을 이제 xml에 잡지 않고 빈으로 빼게 됨.
	
	//트렌젝션
	@Bean
	public DataSourceTransactionManager dataSourceTransactionManager() {
		
		return new DataSourceTransactionManager(dataSource());
	}
	
	//마이바티즈
	@Bean
	public SqlSessionFactory sqlSessionFactory() throws Exception {
		
		SqlSessionFactoryBean factory = new SqlSessionFactoryBean();
		factory.setDataSource(dataSource());
		
		return factory.getObject();
	}

	//bean설정
	@Bean
	public DataSource dataSource() {
		//hikari
		HikariConfig config = new HikariConfig();
		
		config.setDriverClassName("com.mysql.cj.jdbc.Driver");
		//&amp; 아니고 & . 문자열이기 때문
		config.setJdbcUrl("jdbc:mysql://10.10.10.102:3306/jr?useSSL=false&serverTimezone=Asia/Seoul&allowPublicKeyRetrieval=true");
		config.setUsername("jiin");
		config.setPassword("12345678");
		
		HikariDataSource ds = new HikariDataSource(config);
		
		return ds;
	}
	
	
}
