package ra.com.controller;

import ra.com.entity.Category;
import ra.com.service.CategoryService;
import ra.com.service.imp.CategoryServiceImp;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.util.List;

@WebServlet(name = "CategoryController", value = "/CategoryController")
public class CategoryController extends HttpServlet {
    private CategoryService categoryService;

    public CategoryController() {
        categoryService = new CategoryServiceImp();
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String action = request.getParameter("action");
        if (action.equals("findAll")) {
            findAllCategory(request, response);
        } else if (action.equals("initUpdate")) {
            int catalogId = Integer.parseInt(request.getParameter("catalogId"));
            Category catalog = categoryService.findById(catalogId);
            request.setAttribute("catalog", catalog);
            request.getRequestDispatcher("views/updateCatalog.jsp").forward(request, response);
        } else if (action.equals("Delete")) {
            int catalogId = Integer.parseInt(request.getParameter("catalogId"));
            boolean result = categoryService.deleteCategory(catalogId);
            if (result) {
                findAllCategory(request, response);
            } else {
                request.getRequestDispatcher("views/error.jsp").forward(request, response);
            }
        }
    }

    public void findAllCategory(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        List<Category> categories = categoryService.findAll();
        //add categories vào request
        request.setAttribute("categories", categories);
        //Chuyển request và response sang view
        request.getRequestDispatcher("/views/categories.jsp").forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("UTF-8");
        String action = request.getParameter("action");
        if (action.equals("Create")) {
            //Thực hiện thêm mới
            //1. Lấy dữ liệu submit từ form trong request
            Category catalog = new Category();
            catalog.setCatalogName(request.getParameter("catalogName"));
            catalog.setDescription(request.getParameter("description"));
            catalog.setStatus(Boolean.parseBoolean(request.getParameter("status")));
            //2. Gọi sang service thực hiện thêm mới
            boolean result = categoryService.createCategory(catalog);
            //3. Xử lý kết quả service trả về
            if (result) {
                findAllCategory(request, response);
            } else {
                request.getRequestDispatcher("views/error.jsp").forward(request, response);
            }
        } else if (action.equals("Update")) {
            //Thực hiện cập nhật danh mục
            //1. Lấy dữ liệu trên form
            Category catalog = new Category();
            catalog.setCatalogId(Integer.parseInt(request.getParameter("catalogId")));
            catalog.setCatalogName(request.getParameter("catalogName"));
            catalog.setDescription(request.getParameter("description"));
            catalog.setStatus(Boolean.parseBoolean(request.getParameter("status")));
            //2. Gọi service thực hiện cập nhật
            boolean result = categoryService.updateCategory(catalog);
            //3. Xử lý kết quả
            if (result) {
                findAllCategory(request, response);
            } else {
                request.getRequestDispatcher("views/error.jsp").forward(request, response);
            }
        }
    }
}