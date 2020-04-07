
package pl.romanek.webprojekt.shop.service;


public interface OrderService {
    
    void processOrder(String productId, int count);
    
}
