
package pl.romanek.webprojekt.shop.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import pl.romanek.webprojekt.shop.service.CustomerService;

@Controller
public class CustomerController {
    
    @Autowired
    private CustomerService customerService;
    
    
    @RequestMapping("/customers")
    public String customer1(Model model){
        
        model.addAttribute("client",customerService.getAllCustomers());
        
        return "customers";
    }
    
    
    
}
