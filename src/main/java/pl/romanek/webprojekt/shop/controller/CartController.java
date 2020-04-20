package pl.romanek.webprojekt.shop.controller;

import javax.servlet.http.HttpServletRequest;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/cart")
public class CartController {

    @RequestMapping
    public String get(HttpServletRequest request) { //za opomocą HttpServletRequest i obiekut request odczyuje ID Sesji --> na jego podstawie stworzę koszyk
                                                    //id sesji będzie id koszyka
        return "redirect:/cart/" + request.getSession().getId(); //przekierowuje do kontrolera poniżej 
    }

    @GetMapping("/{cartId}") // 
    public String getCart(Model model, @PathVariable("cartId") String cartId) {
        model.addAttribute("cartId", cartId); //dodaję do modelu ID Sesji w postaci Stringu
        return "cart"; //zwracam nazwę widoku cart
    }
}
