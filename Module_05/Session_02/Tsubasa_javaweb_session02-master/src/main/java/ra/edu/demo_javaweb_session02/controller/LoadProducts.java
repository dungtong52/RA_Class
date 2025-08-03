package ra.edu.demo_javaweb_session02.controller;

import jakarta.servlet.ServletContext;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import ra.edu.demo_javaweb_session02.entiy.Product;
import ra.edu.demo_javaweb_session02.service.ProductService;

import java.io.IOException;
import java.util.List;

@WebServlet(urlPatterns = "/LoadProducts")
public class LoadProducts extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        List<Product> list =  new ProductService().getProducts();
        req.setAttribute("list", list);

        req.getRequestDispatcher("listProduct.jsp").forward(req,resp);
    }
}
