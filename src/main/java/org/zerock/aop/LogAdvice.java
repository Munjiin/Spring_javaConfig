package org.zerock.aop;

import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before; //임폴트 어스팩트 중요
import org.springframework.stereotype.Component;

import lombok.extern.log4j.Log4j;

@Aspect
@Component
@Log4j
public class LogAdvice {
	
	@Before("execution(* org.zerock.service.*.*(..))") //여기 밑에 있는 메소드들에 대한 설정이 들어감.
	public void logBefore() {
		log.info("--------------------------------------------------");
		log.info("--------------------------------------------------");
		log.info("--------------------------------------------------");
	}

}
