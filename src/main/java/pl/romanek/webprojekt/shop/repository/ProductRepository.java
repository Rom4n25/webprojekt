
package pl.romanek.webprojekt.shop.repository;

import java.util.List;
import java.util.Map;
import java.util.Set;
import pl.romanek.webprojekt.shop.domain.Product;


public interface ProductRepository {
    
    List<Product> getAllProducts();
    
    Product getProductById(String productId);
    
    List<Product> getProductByCategory(String category);
    
    List<Product> getProductByManufacturer(String manufacturer);
    
    Set<Product> getProducsByFilter(Map<String, List<String>> filterParams);
    
    Set<Product> getProductsByPriceFilter(Map<String, String> filterParams);
    
    void addProduct(Product product);
}
