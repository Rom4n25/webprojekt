package pl.romanek.webprojekt.shop.controller;

import javax.servlet.http.HttpServletRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;
import pl.romanek.webprojekt.shop.domain.Cart;
import pl.romanek.webprojekt.shop.domain.CartItem;
import pl.romanek.webprojekt.shop.domain.Product;
import pl.romanek.webprojekt.shop.service.CartService;
import pl.romanek.webprojekt.shop.service.ProductService;

@RestController
@RequestMapping("rest/cart")
public class CartRestController {

    @Autowired
    private CartService cartService;

    @Autowired
    private ProductService productService;

    //Nie musze dodawać @ResponseBody bo mam @RestController
    @PostMapping()
    public Cart create(@RequestBody Cart cart) {
        return cartService.create(cart);
    }

    @GetMapping("/{cartId}")
    public Cart read(@PathVariable("cartId") String cartId) {
        return cartService.read(cartId); //zwracam @ResponseBody w postaci JSONA
    }

    @PutMapping("/{cartId}")
    @ResponseStatus(value = HttpStatus.NO_CONTENT)
    public void update(@PathVariable("cartId") String cartId, @RequestBody Cart cart) {
        cartService.update(cartId, cart);
    }

    @RequestMapping(value = "/{cartId}", method=RequestMethod.DELETE)
    @ResponseStatus(value = HttpStatus.NO_CONTENT)
    public void delete(@PathVariable("cartId") String cartId) {
        cartService.delete(cartId);
    }

    @PutMapping("/add/{productId}") //tutaj trafia żądanie wywołane w kontrolerze controller.js z metody addToCart
    @ResponseStatus(value = HttpStatus.NO_CONTENT)
    public void addItem(@PathVariable("productId") String productId, HttpServletRequest request) { 
        String sessionId = request.getSession().getId(); //zapisuje do Stringa Session ID
        Cart cart = cartService.read(sessionId); //odczytuje z bazy obiekt cart na podstawie tego Session ID

        if (cart == null) { //jeżeli okaże się, że taki koszyk nie istnieje to go tworzę 
            cart = cartService.create(new Cart(sessionId));
        }

        Product product = productService.getProductById(productId); //odczytuje z bazy produkt na podsatwie id 

        if (product == null) {  //jeżeli nie ma takiego produktu to rzucam wyjątek
            throw new IllegalArgumentException(new Exception());
        }

        cart.addCartItem(new CartItem(product)); //do stworzonego koszyka dodaje nowy CartItem czyli produkt
        cartService.update(cart.getCartId(), cart);//aktualizuje koszyk - lista koszykow jest HashMapem gdzie kluczem jest ID koszyka czyli SessionID a vaulue to koszyk
    }

    @PutMapping("/remove/{productId}")
    @ResponseStatus(value = HttpStatus.NO_CONTENT)
    public void removeItem(@PathVariable("productId") String productId, HttpServletRequest request) {
        String sessionId = request.getSession().getId();
        Cart cart = cartService.read(sessionId);

        if (cart == null) {
            cart = cartService.create(new Cart(sessionId));
        }

        Product product = productService.getProductById(productId);

        if (product == null) {
            throw new IllegalArgumentException(new Exception());
        }

        cart.removeCartItem(new CartItem(product));
        cartService.update(sessionId, cart);
    }

    @ExceptionHandler(IllegalArgumentException.class)
    @ResponseStatus(value = HttpStatus.BAD_REQUEST, reason = "Niepoprawne żądanie, sprawdź przesyłane dane.")
    public void handleClientErrors(Exception ex) {
    }

    @ExceptionHandler(Exception.class)
    @ResponseStatus(value = HttpStatus.INTERNAL_SERVER_ERROR, reason = "Wewnętrzny błąd serwera.")
    public void handleServerErrors(Exception ex) {
    }
}
