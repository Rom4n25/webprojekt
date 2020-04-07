
package pl.romanek.webprojekt.shop.service;

import java.util.List;
import java.util.Map;
import java.util.Set;
import pl.romanek.webprojekt.shop.domain.Product;


public interface ProductService {
    
    List<Product> getAllProducts();
    List<Product> getProductsByCategory(String category);
    List<Product> getProductsByManufacturer(String manufacturer);
    Set<Product> getProductsByFilter(Map <String, List<String>> filterParams);
    Product getProductById(String productById);
    Set<Product> getProductsByPriceFilter(Map <String, String> filterParams);
    void addProduct (Product product);
  
    
}
