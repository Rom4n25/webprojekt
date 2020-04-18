
package pl.romanek.webprojekt.shop.service;

import pl.romanek.webprojekt.shop.domain.Cart;


public interface CartService {

    Cart create(Cart cart);

    Cart read(String cartId);

    void update(String cartId, Cart cart);

    void delete(String cartId);

}
