package ra.edu.demo_javaweb_session02.controller;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import ra.edu.demo_javaweb_session02.entiy.Product;
import ra.edu.demo_javaweb_session02.service.ProductService;

import java.io.IOException;
import java.util.List;

@WebServlet(urlPatterns = "/ProductInsert")
public class ProductInsert extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String name  = req.getParameter("name");
        Double price = Double.parseDouble(req.getParameter("price"));

        Product p = new Product();
        p.setName(name);
        p.setPrice(price);

        boolean bl = new ProductService().addProduct(p);
        if(bl){
            req.setAttribute("message","Product added");
            List<Product> list =  new ProductService().getProducts();
            req.setAttribute("list", list);

            req.getRequestDispatcher("listProduct.jsp").forward(req,resp);
        }else{
            req.setAttribute("error","Product not added");
            req.getRequestDispatcher("addProduct.jsp").forward(req,resp);
        }
    }
}
