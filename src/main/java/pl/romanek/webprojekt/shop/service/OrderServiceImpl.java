
package pl.romanek.webprojekt.shop.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pl.romanek.webprojekt.shop.domain.Product;
import pl.romanek.webprojekt.shop.repository.ProductRepository;

@Service
public class OrderServiceImpl implements OrderService {

    @Autowired
    private ProductRepository productRepository;
    

    
    @Override
    public void processOrder(String productId, int count) {
       
        Product productById = productRepository.getProductById(productId);
        
        if(productById.getUnitsInStock() <count){
            
            throw new IllegalArgumentException("Zbyt mało towaru w magazynie");
        }
        
        productById.setUnitsInStock(productById.getUnitsInStock()-count);
    }
    
}
