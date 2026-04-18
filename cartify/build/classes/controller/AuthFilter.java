package controller;

import jakarta.servlet.Filter;

import jakarta.servlet.FilterChain;
import jakarta.servlet.FilterConfig;
import jakarta.servlet.ServletException;
import jakarta.servlet.ServletRequest;
import jakarta.servlet.ServletResponse;
import jakarta.servlet.annotation.WebFilter;
import jakarta.servlet.http.HttpFilter;
import java.io.IOException;
import jakarta.servlet.http.*;

/**
 * Servlet Filter implementation class AuthFilter
 */
@WebFilter("/*")
public class AuthFilter extends HttpFilter implements Filter {
       
   public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
		HttpServletRequest req=(HttpServletRequest)request;
		HttpServletResponse res=(HttpServletResponse)response;
		String path=req.getRequestURI();
		if (path.endsWith("login.jsp") || path.endsWith("register.jsp") 
			    || path.endsWith("/login") || path.endsWith("/register"))  {
			chain.doFilter(request, response);
			return;
		}

		HttpSession session=req.getSession(false);
		if(session!=null && session.getAttribute("user")!=null) {
		chain.doFilter(request, response);
		}else {
			res.sendRedirect(req.getContextPath()+"/jsp/login.jsp");
		}
}
}
