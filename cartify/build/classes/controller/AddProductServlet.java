package controller;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import dao.ProductDAO;
import model.Product;
@WebServlet("/addProduct")

public class AddProductServlet  extends HttpServlet{
	public void doPost(HttpServletRequest req,HttpServletResponse res)throws IOException,ServletException{
		
		String name=req.getParameter("productName");
		double price=Double.parseDouble(req.getParameter("price"));
		int quantity=Integer.parseInt(req.getParameter("quantity"));
		String image=req.getParameter("image");
		String brand=req.getParameter("brand");
		String description=req.getParameter("description");
		Product p=new Product(name,price,quantity,image,brand,description);
		ProductDAO dao=new ProductDAO();
		boolean status=dao.addProduct(p);
		if(status) {
			res.sendRedirect(req.getContextPath()+"/jsp/home.jsp");
		}
		else {
			res.getWriter().println("Product not added");
		}
	}

}
