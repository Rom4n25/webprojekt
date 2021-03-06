package pl.romanek.webprojekt.shop.controller;

import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.MatrixVariable;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import pl.romanek.webprojekt.shop.domain.Product;
import pl.romanek.webprojekt.shop.service.ProductService;

@Controller
@RequestMapping("/shop")
public class ProductController {

    @Autowired
    private ProductService productService;

    @RequestMapping
    public String list(Model model) {

        model.addAttribute("products", productService.getAllProducts());
        return "shop";

    }

    
    @RequestMapping("/all")
    public String allProducts(Model model) {
        model.addAttribute("products", productService.getAllProducts());
        return "shop";
    }
    
    
    @RequestMapping("/product")
    public String getProductById(Model model, @RequestParam("id") String productId) {

        model.addAttribute("product", productService.getProductById(productId));

        return "product";
    }
    
           
    @RequestMapping("/{category}")
    public String getProductsByCategory(Model model, @PathVariable("category") String productCategory) {

        model.addAttribute("products", productService.getProductsByCategory(productCategory));
        return "shop";
    }

    
    @RequestMapping("/filter/{ByCriteria}")
    public String getProductsByFilter(Model model, @MatrixVariable(pathVar = "ByCriteria") Map<String, List<String>> filterParams) {

        model.addAttribute("products", productService.getProductsByFilter(filterParams));

        return "shop";

    }

       
    @RequestMapping("/{category}/{price}")
    public String filterProducts(Model model, @PathVariable("category") String productCategory, @MatrixVariable(pathVar = "price") Map<String, String> filterParams, @RequestParam("manufacturer") String manufacturer) {

        Set<Product> categoryList = new HashSet<Product>();
        Set<Product> priceList = new HashSet<Product>();

        categoryList.addAll(productService.getProductsByCategory(productCategory));
        priceList.addAll(productService.getProductsByPriceFilter(filterParams));

        categoryList.retainAll(priceList);

        Set<Product> manufacturerList = new HashSet<Product>();

        manufacturerList.addAll(productService.getProductsByManufacturer(manufacturer));

        categoryList.retainAll(manufacturerList);

        model.addAttribute("products", categoryList);

        return "shop";

    }

    
   // mozna tez tak...
   // @GetMapping("/add")
   // public String getAddNewProductForm(Model model) {

   // Product newProduct = new Product();
   // model.addAttribute("newProduct", newProduct);
   // return "addProduct";

   // }

    @GetMapping("/add")
    public String getAddNewProductForm(@ModelAttribute("newProduct") Product newProduct) {
        return "addProduct";
    }
    
    
    @PostMapping("/add")
    public String processAddNewProductForm(@ModelAttribute("newProduct") Product productToBeAdded) {

        productService.addProduct(productToBeAdded);
        return "redirect:/shop";
    }

    @GetMapping("/{ByCriteria}/{price}")
    public String superFilterProducts(Model model, @MatrixVariable(pathVar = "ByCriteria") Map<String, List<String>> filterParams1, @MatrixVariable(pathVar = "price") Map<String, String> filterParams2, @RequestParam("manufacturer") String manufacturer) {

        Set<Product> categoryList = new HashSet<Product>();
        Set<Product> priceList = new HashSet<Product>();

        categoryList.addAll(productService.getProductsByFilter(filterParams1));
        priceList.addAll(productService.getProductsByPriceFilter(filterParams2));

        categoryList.retainAll(priceList);

        Set<Product> manufacturerList = new HashSet<Product>();

        manufacturerList.addAll(productService.getProductsByManufacturer(manufacturer));

        categoryList.retainAll(manufacturerList);

        model.addAttribute("products", categoryList);

        return "shop";

    }
    
    
    
}
