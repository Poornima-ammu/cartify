package controller;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import dao.UserDAO;
import model.User;
import util.DBConnection;
import jakarta.servlet.http.HttpSession;


@WebServlet("/logout")
public class LogoutServlet extends HttpServlet{
	public void doGet(HttpServletRequest req,HttpServletResponse res)throws IOException ,ServletException {
		HttpSession session=req.getSession(false);
		if(session!=null) {
		
			session.invalidate();
		}
		res.sendRedirect(req.getContextPath()+"jsp/login.jsp");
	}
}