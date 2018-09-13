package com.zc.interceptor;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import com.zc.MyWebMvcConfig;

public class UserInterceptor implements HandlerInterceptor {

	@Override
	public void afterCompletion(HttpServletRequest arg0,
			HttpServletResponse arg1, Object arg2, Exception arg3)
			throws Exception {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void postHandle(HttpServletRequest arg0, HttpServletResponse arg1,
			Object arg2, ModelAndView arg3) throws Exception {
		// TODO Auto-generated method stub
		
	}

	@Override
	public boolean preHandle(HttpServletRequest request, HttpServletResponse response,
			Object obj) throws Exception {
		
		System.out.println("request.getContextPath()------------" + request.getContextPath());
		
		System.out.println("自定义注解------------");
		
		HttpSession session = request.getSession();
		/*Cookie[] cookies = request.getCookies();
		for(Cookie c : cookies){
			System.out.println("cookie:" + c.getName() + "\t" + c.getValue());
		}*/
		System.out.println("session:" + session.getAttribute(new MyWebMvcConfig().SESSION_KEY));
		if(session.getAttribute(MyWebMvcConfig.SESSION_KEY) != null){
			return true;
		}else{
			
			// 跳转登录
			String url = "/login.html";
			response.sendRedirect(url);
			return false;
		}
	}

}
