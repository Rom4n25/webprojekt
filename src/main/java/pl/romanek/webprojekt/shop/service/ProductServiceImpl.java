package pl.romanek.webprojekt.shop.service;

import java.util.List;
import java.util.Map;
import java.util.Set;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pl.romanek.webprojekt.shop.domain.Product;
import pl.romanek.webprojekt.shop.repository.ProductRepository;

@Service
public class ProductServiceImpl implements ProductService {

    @Override
    public void addProduct(Product prdct) {
        
        productRepository.addProduct(prdct);
    }

    @Override
    public Set<Product> getProductsByPriceFilter(Map<String, String> map) {
        return productRepository.getProductsByPriceFilter(map);
    }
 
    @Autowired
    ProductRepository productRepository;
    
    
    @Override
    public List<Product> getProductsByManufacturer(String manufacturer) {
       
        return productRepository.getProductByManufacturer(manufacturer);
    }

    
    
    @Override
    public Product getProductById(String productById) {
        
        return productRepository.getProductById(productById);
       
          }

   
    
    @Override
    public Set<Product> getProductsByFilter(Map<String, List<String>> filterParams) {
        
        return productRepository.getProducsByFilter(filterParams);
    }

    @Override
    public List<Product> getProductsByCategory(String category) {

        return productRepository.getProductByCategory(category);

    }

   

    @Override
    public List<Product> getAllProducts() {

        return productRepository.getAllProducts();
    }

}
