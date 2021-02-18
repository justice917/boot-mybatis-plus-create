package com.boot.create.api.controller.interceptor;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.web.context.support.SpringBeanAutowiringSupport;

import com.boot.create.api.constants.Constants;

import lombok.extern.slf4j.Slf4j;

/**
 * 
 * @author admin、、
 *
 */


@WebFilter(filterName = "userFilter",urlPatterns = {"/user/*"})
@Slf4j
//@Component
public class UserFilter implements Filter {
	
	@Autowired
	private StringRedisTemplate redisTemplate;

    @Override	
    public void init(FilterConfig filterConfig) throws ServletException {
        SpringBeanAutowiringSupport.processInjectionBasedOnCurrentContext(this);
    }

    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
            throws IOException, ServletException {
    	log.info("aaa");
    	//检查header中有误token
    	HttpServletRequest httpServletRequest = (HttpServletRequest) request;
    	String token = httpServletRequest.getHeader(Constants.TOKEN);
    	String userId = httpServletRequest.getHeader(Constants.USER);
    	
    	//查看redis里是否有user，并且对比token
    	String redisToken = redisTemplate.opsForValue().get(userTokenKey(userId));
    	log.info("redisToken:"+redisToken);        
    	chain.doFilter(request, response);        
    }

    private String userTokenKey(String userId){
    	return "demo_user_token:"+userId;
    }
    
    @Override
    public void destroy() {

    }

}
