package egovframework.example.cmmn;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.AfterThrowing;
import org.aspectj.lang.annotation.Aspect;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

@Aspect
public class TestAOP {
	
	private static Logger log = LoggerFactory.getLogger(TestAOP.class);
	
	@AfterThrowing(pointcut="execution(* egovframework.example..web.*Controller.*(..))", throwing="ex")
	public void test(JoinPoint jp, Exception ex) throws Exception{
		log.debug(jp.getClass()+":"+ex.getMessage());
	}
}
