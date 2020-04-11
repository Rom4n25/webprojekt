package pl.romanek.webprojekt.currency;


import org.springframework.stereotype.Controller;
import java.io.IOException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class CurrencyController {

    @Autowired
    CurrencyService currencyService;

    @PostMapping("/currency")
    public String currency(Model model, @RequestParam("currency1") String currency1, @RequestParam("currency2") String currency2, @RequestParam("amount") String amount) throws IOException {

        Boolean flag = true;

        model.addAttribute("flag", flag);
        model.addAttribute("currency", currencyService.convertCurrency(currency1, currency2, amount));

        return "currencyView";

    }

    @GetMapping("/currency")
    public String currencyView() {

        return "currencyView";
    }
    

    

    
    
    
}
