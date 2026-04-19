package controller;

import jakarta.servlet.Filter;
import jakarta.servlet.http.*;
import jakarta.servlet.FilterChain;
import jakarta.servlet.FilterConfig;
import jakarta.servlet.ServletException;
import jakarta.servlet.ServletRequest;
import jakarta.servlet.ServletResponse;
import jakarta.servlet.annotation.WebFilter;
import jakarta.servlet.http.HttpFilter;
import model.User;

import java.io.IOException;

/**
 * Servlet Filter implementation class AdminFilter
 */
@WebFilter({"/addProduct", "/jsp/addProduct.jsp"})
public class AdminFilter extends HttpFilter implements Filter {
       
  
	/**
	 * @see Filter#doFilter(ServletRequest, ServletResponse, FilterChain)
	 */
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
		// TODO Auto-generated method stub
		// place your code here
		HttpServletRequest req=(HttpServletRequest)request;
		HttpServletResponse res=(HttpServletResponse)response;
		HttpSession session=req.getSession(false);
		if(session==null ) {
			res.sendRedirect(req.getContextPath()+"/jsp/login.jsp");
			return;
		}
		User user=(User)session.getAttribute("user");
		if(user==null || !user.getRole().equals("admin")) {
			res.sendRedirect(req.getContextPath()+"/jsp/home.jsp");
			return;
		}
		
		// pass the request along the filter chain
		chain.doFilter(request, response);
	}

	/**
	 * @see Filter#init(FilterConfig)
	 */
}
