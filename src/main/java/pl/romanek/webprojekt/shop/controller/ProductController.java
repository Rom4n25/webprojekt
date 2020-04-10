package pl.romanek.webprojekt.shop.controller;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import javax.servlet.http.HttpServletRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.util.StringUtils;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.MatrixVariable;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;
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


    @RequestMapping("/product")
    public String getProductById(Model model, @RequestParam("id") String productId) {

        model.addAttribute("product", productService.getProductById(productId));

        return "product";
    }

    @RequestMapping("/{category}")
    public String getProductsByCategory(Model model, @PathVariable("category") String productCategory) {

        model.addAttribute("products", productService.getProductsByCategory(productCategory));
        model.addAttribute("category",productCategory);
        
        return "shop";
    }
    
    @RequestMapping("/price")
    public String getPrice(Model model, @RequestParam("low") String low, @RequestParam("high")String high, @RequestParam("category")String category){
       
         List<Product> productByCategory = new ArrayList<>();
        if(category.isEmpty()){
            
         
         productByCategory= productService.getAllProducts();
            
            
        }else{
            
          
        
         productByCategory =  productService.getProductsByCategory(category);
        
        }
        
        Map<String, String> filterParams = new HashMap<>();
        filterParams.put("low", low);
        filterParams.put("high", high);
        
        Set<Product> priceList = new HashSet<Product>();

        priceList.addAll(productService.getProductsByPriceFilter(filterParams));
        priceList.retainAll(productByCategory);
        
        model.addAttribute("products", priceList);
        model.addAttribute("category",category);
         
       
        return "shop";
    }
    
    
    
//    @RequestMapping("/{category}/{price}")
//    public String getProductsByCategoryAndPrice(Model model, @PathVariable("category") String productCategory,@MatrixVariable(pathVar = "price") Map<String, String> filterParams) {
//
//        
//        
//        List<Product> productByCategory =  productService.getProductsByCategory(productCategory);
//      
//        Set<Product> priceList = new HashSet<Product>();
//
//        priceList.addAll(productService.getProductsByPriceFilter(filterParams));
//     
//        priceList.retainAll(productByCategory);
//        
//        
//        model.addAttribute("products", priceList);
//        
//       
//              
//        return "shop";
//    }

    
    
    // INNE 
    
    
    
    
    
    
    
    
    
    
    @RequestMapping("/filter/{ByCriteria}")
    
    public String getProductsByFilter(Model model, @MatrixVariable(pathVar = "ByCriteria") Map<String, List<String>> filterParams) {
        System.out.println("ELO");
        model.addAttribute("products", productService.getProductsByFilter(filterParams));

        return "shop";

    }

//    @RequestMapping("/{category}/{price}")
//    public String filterProducts(Model model, @PathVariable("category") String productCategory, @MatrixVariable(pathVar = "price") Map<String, String> filterParams, @RequestParam("manufacturer") String manufacturer) {
//
//        System.out.println("ELO");
//        Set<Product> categoryList = new HashSet<>();
//        Set<Product> priceList = new HashSet<>();
//
//        categoryList.addAll(productService.getProductsByCategory(productCategory));
//        priceList.addAll(productService.getProductsByPriceFilter(filterParams));
//
//        categoryList.retainAll(priceList);
//
//        Set<Product> manufacturerList = new HashSet<Product>();
//
//        manufacturerList.addAll(productService.getProductsByManufacturer(manufacturer));
//
//        categoryList.retainAll(manufacturerList);
//      
//
//        model.addAttribute("products", categoryList);
//
//        return "shop";
//
//    }

//    @RequestMapping("/filters/{price}")
//            
//    public String filterProducts2(Model model, @MatrixVariable(pathVar = "price") Map<String, String> filterParams) {
//        System.out.println("ELO2");
//        Set<Product> priceList = new HashSet<Product>();
//
//        priceList.addAll(productService.getProductsByPriceFilter(filterParams));
//        System.out.println(priceList);
//
//        model.addAttribute("products", priceList);
//
//        return "shop";
//
//    }

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
    public String processAddNewProductForm(@ModelAttribute("newProduct") Product productToBeAdded, BindingResult result, HttpServletRequest request) throws IOException {

        String[] suppressedFields = result.getSuppressedFields();
        if (suppressedFields.length > 0) {
            throw new RuntimeException("Próba wiązania niedozwolonych pól:" + StringUtils.arrayToCommaDelimitedString(suppressedFields));
        }

        MultipartFile productImage = productToBeAdded.getProductImage();

        String rootDirectory = request.getSession().getServletContext().getRealPath("/");
        System.out.println(rootDirectory);
        // ---> rootDirectory   "C:/Users/Roman/Documents/NetBeansProjects/webprojekt/target/webprojekt/resources/images/"
        productImage.transferTo(new File(rootDirectory + "resources\\images\\" + productToBeAdded.getProductId() + ".jpg"));

        productService.addProduct(productToBeAdded);
        return "redirect:/shop";
    }

    @InitBinder
    public void initialiseBinder(WebDataBinder binder) {
        binder.setDisallowedFields("unitsInOrder", "discontinued");
    }

//    @GetMapping("/{ByCriteria}/{price}")
//    public String superFilterProducts(Model model, @MatrixVariable(pathVar = "ByCriteria") Map<String, List<String>> filterParams1, @MatrixVariable(pathVar = "price") Map<String, String> filterParams2, @RequestParam("manufacturer") String manufacturer) {
//
//        Set<Product> categoryList = new HashSet<Product>();
//        Set<Product> priceList = new HashSet<Product>();
//
//        categoryList.addAll(productService.getProductsByFilter(filterParams1));
//        priceList.addAll(productService.getProductsByPriceFilter(filterParams2));
//
//        categoryList.retainAll(priceList);
//
//        Set<Product> manufacturerList = new HashSet<Product>();
//
//        manufacturerList.addAll(productService.getProductsByManufacturer(manufacturer));
//
//        categoryList.retainAll(manufacturerList);
//
//        model.addAttribute("products", categoryList);
//
//        return "shop";
//
//    }

}
