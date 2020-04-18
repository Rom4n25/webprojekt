
package pl.romanek.webprojekt.shop.repository;

import pl.romanek.webprojekt.shop.domain.Cart;

public interface CartRepository {
    
    Cart create(Cart cart);
    Cart read(String cartId);
    void update(String cartId, Cart cart);
    void delete(String cartId);
    
}
