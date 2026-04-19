package dao;
import util.DBConnection;
import java.sql.*;
import model.Product;
import java.util.*
;public class ProductDAO {
	public boolean addProduct(Product product) {
		boolean result=false;
		try {
			Connection con=DBConnection.getConnection();
			String sql="insert into products(product_name,price,quantity,image,brand,description)values(?,?,?,?,?,?)";
			PreparedStatement ps=con.prepareStatement(sql);
			ps.setString(1, product.getProductName());
			ps.setDouble(2,product.getPrice());
			ps.setInt(3, product.getQuantity());
			ps.setString(4, product.getImage());
			ps.setString(5, product.getBrand());
			ps.setString(6, product.getDescription());
			int rows=ps.executeUpdate();
			if(rows>0) {
				result=true;
			}	
			con.close();
			ps.close();
		}
		
		catch(Exception e) {
			e.printStackTrace();
		}
		return result;
	
	}
	
	public List<Product> getAllProducts(){
		List<Product> list=new ArrayList<>();
		try {
			Connection con=DBConnection.getConnection();
			 String sql="select * from Products " ;
			 PreparedStatement ps=con.prepareStatement(sql);
			 ResultSet rs=ps.executeQuery();
			 while(rs.next()) {
				 int id=rs.getInt("productId");
				 String name=rs.getString("product_name");
				 double price=rs.getDouble("price");
				 int quantity=rs.getInt("quantity");
				 String image=rs.getString("image");
				 String brand=rs.getString("brand");
				 String description=rs.getString("description");
				 Product p=new Product();
				 p.setProductId(id);
				 p.setProductName(name);
				 p.setPrice(price);
				 p.setQuantity(quantity);
				 p.setImage(image);
				 p.setBrand(brand);
				 p.setDescription(description);
				 
				 list.add(p);
			 }
			 
		
			 
		}
		catch(Exception e) {
			e.printStackTrace();
		}
		return list;
	}
	public Product getProductById(int ProductId) {
		Product product=null;
		try {
		Connection	con=DBConnection.getConnection();
		String sql="select * from products where productId=?";
		PreparedStatement ps=con.prepareStatement(sql);
		ps.setInt(1, ProductId);
		ResultSet rs=ps.executeQuery();

		if(rs.next()) {
			product =new Product();
			String name=rs.getString("product_name");
			 double price=rs.getDouble("price");
			 int quantity=rs.getInt("quantity");
			 String image=rs.getString("image");
			 String brand=rs.getString("brand");
			 String description=rs.getString("description");
			 product.setProductId(rs.getInt("productId"));
			 product.setProductName(name);
			 product.setPrice(price);
			 product.setQuantity(quantity);
			 product.setImage(image);
			 product.setBrand(brand);
			 product.setDescription(description);
			
		}
		
		return product;
				}
		catch(Exception e) {
			e.printStackTrace();
		}
		return null;
	}


}
