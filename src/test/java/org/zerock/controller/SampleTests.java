package org.zerock.controller;

import java.sql.Connection;

import javax.sql.DataSource;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.zerock.config.RootConfig;
import org.zerock.mapper.TimeMapper;
import org.zerock.service.SampleBean;

import lombok.Setter;
import lombok.extern.log4j.Log4j;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes= {RootConfig.class})
@Log4j
public class SampleTests {
	
	@Setter(onMethod_=@Autowired)
	private SampleBean bean;
	
	@Test
	public void testExist() {
		log.info("=================");
		log.info(bean.doA("AVCD:FD"));
		log.info("=================");
	}
	
	//jdbc 연결
	@Setter(onMethod_=@Autowired)
	private DataSource ds;
	
	@Test
	public void testCon() {
		try(Connection con = ds.getConnection()){
			log.info(con);
		}catch(Exception e) {
			e.printStackTrace();
		}
	}
	
	//메퍼
	@Setter(onMethod_=@Autowired)
	private TimeMapper mapper;
	
	
	@Test
	public void testTime() {
		log.info(mapper);
	}
	
	//트렌젝션
	@Test
	public void testTransaction() {
		String str = "이 책은 파이썬이란 언어";
		bean.doB(str);
	}
	
	
	

}
