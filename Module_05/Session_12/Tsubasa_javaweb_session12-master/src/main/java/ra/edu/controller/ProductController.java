package ra.edu.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;
import ra.edu.model.entity.Product;
import ra.edu.service.ProductService;

import java.util.List;

@Controller
@RequestMapping(value = {"/","/products"})
public class ProductController {
    @Autowired
    private ProductService productService;

    @GetMapping
    public String listProducts(Model model){
        List<Product> products = productService.getProducts();
        model.addAttribute("products",products);
        return "list_products";
    }

    @GetMapping("/add")
    public String add(Model model){
        model.addAttribute("product",new Product());
        return "add_product";
    }

    @PostMapping("/add")
    public String insertProduct(@ModelAttribute("product") Product product){
        productService.insertProduct(product);
        return "redirect:/products";
    }

    @GetMapping("/update/{productId}")
    public String updateProduct(@PathVariable("productId")Integer productId,Model model){
        Product product = productService.getProductById(productId);
        model.addAttribute("product",product);
        return "update_product";
    }

    @PostMapping("/update")
    public String updateProduct(@ModelAttribute("product") Product product){
        productService.updateProduct(product, product.getProductId());
        return "redirect:/products";
    }

    @GetMapping("/delete/{productId}")
    public String deleteProduct(@PathVariable("productId")Integer productId,Model model, RedirectAttributes redirectAttributes){
        productService.deleteProduct(productId);
//        List<Product> products = productService.getProducts();
//        model.addAttribute("products",products);
//        model.addAttribute("success","Delete Success for product id: "+productId);
//        return "list_products";
        redirectAttributes.addFlashAttribute("success","Delete successfully for product id: "+productId);
        return "redirect:/products";
    }

    @GetMapping("/search")
    public String search(@RequestParam(name = "productName")String proName, Model model){
        List<Product> products = productService.getProductsByName(proName);
        model.addAttribute("products",products);
        return "list_products";
    }
}
