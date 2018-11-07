package org.zerock.service;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.zerock.mapper.TimeMapper;

import lombok.AllArgsConstructor;
import lombok.extern.log4j.Log4j;

@Service
@AllArgsConstructor
@Log4j
public class SampleBean {
	
	private TimeMapper mapper;
	
	public String doA(String name) { //여기에 aop적용
		
		return new StringBuffer(name).reverse().toString();
	}
	
	@Transactional //이걸 넣으면 둘 다 안들어가짐
public void doB(String str) { //여기에 aop적용
		
		int result1 = mapper.insert1(str);
		
		int result2 = mapper.insert2(str);
		
		log.info(result1 + " : " + result2);
		
	}

}
