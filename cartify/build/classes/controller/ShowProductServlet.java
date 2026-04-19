package controller;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import dao.ProductDAO;
import model.Product;

import util.DBConnection;

@WebServlet("/products")
public class ShowProductServlet extends HttpServlet {
		public void doGet(HttpServletRequest req,HttpServletResponse res)throws IOException,ServletException {
			ProductDAO dao=new ProductDAO();
			
			req.setAttribute("products",dao.getAllProducts());
			req.getRequestDispatcher("/jsp/products.jsp").forward(req, res);
			
		}
}
