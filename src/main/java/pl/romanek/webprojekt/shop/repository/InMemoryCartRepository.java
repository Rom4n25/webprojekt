package pl.romanek.webprojekt.shop.repository;

import java.util.HashMap;
import java.util.Map;
import org.springframework.stereotype.Repository;
import pl.romanek.webprojekt.shop.domain.Cart;

@Repository
public class InMemoryCartRepository implements CartRepository {

    private Map<String, Cart> listOfCarts;

    public InMemoryCartRepository(Map<String, Cart> listOfCarts) {
        this.listOfCarts = new HashMap<>();
    }

    @Override
    public Cart create(Cart cart) {

        if (listOfCarts.keySet().contains(cart.getCartId())) {
            throw new IllegalArgumentException(String.format("Nie można utworzyć koszyka. Koszyk o wskazanym id (%) już istnieje.", cart.getCartId()));
        }
        listOfCarts.put(cart.getCartId(), cart);
              return cart;
    }

    @Override
    public Cart read(String cartId) {

        return listOfCarts.get(cartId);
    }

    @Override
    public void update(String cartId, Cart cart) {
        if (!listOfCarts.keySet().contains(cartId)) {
            throw new IllegalArgumentException(String.format("Nie można zaktualizować koszyka. Koszyk o wskazanym id (%) nieistnieje.", cartId));

        }
        listOfCarts.put(cartId, cart);
    }

    @Override
    public void delete(String cartId) {
        if (!listOfCarts.keySet().contains(cartId)) {
            throw new IllegalArgumentException(String.format("Nie można usunąć koszyka.Koszyk o wskazanym id (%) nie istnieje.", cartId));
        }
        listOfCarts.remove(cartId);
    }
}


