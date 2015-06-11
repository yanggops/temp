package egovframework.example.cmmn;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

public class CheckExceptionInterceptor extends HandlerInterceptorAdapter {

	private static Logger log = LoggerFactory.getLogger(CheckExceptionInterceptor.class);
	
	@Override
	public boolean preHandle(HttpServletRequest request,
			HttpServletResponse response, Object handler) throws Exception {
		log.debug("====================CheckExceptionInterceptor.preHandle");
		return super.preHandle(request, response, handler);
	}

	@Override
	public void afterCompletion(HttpServletRequest request,
			HttpServletResponse response, Object handler, Exception ex)
			throws Exception {
		log.debug("====================CheckExceptionInterceptor.afterCompletion");
		if(ex != null){
			log.debug("Excpetion:"+ex.getMessage());
		}else{
			Exception e = (Exception)request.getAttribute("exception");
			if(e != null){
				log.debug("request.Exception"+e.getMessage());
			}
		}
	}
	
}
