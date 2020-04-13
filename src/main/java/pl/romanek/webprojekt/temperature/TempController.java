package pl.romanek.webprojekt.temperature;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestParam;
import javax.servlet.ServletException;
import java.io.IOException;
import java.net.MalformedURLException;
import javax.validation.Valid;
import javax.validation.constraints.NotBlank;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class TempController {

    @Autowired
    TempService tempService;

    @PostMapping("/temperature")
    public String temperature(Model model,@RequestParam("city") String city) throws IOException, MalformedURLException, ServletException {
        Boolean flag_return = true;
        Boolean flag_error_blank = false;
        Boolean flag_error_notfound = false;
       
        if(city.isBlank()){
            
            
            flag_error_blank = true;
            model.addAttribute("flag_error_blank", flag_error_blank);
            return "temperatureView";
        }
        
      
       if(tempService.getTemperature(city)==1000){
           
           flag_error_notfound = true;
           model.addAttribute("flag_error_notfound",flag_error_notfound);
           return "temperatureView";
       }
        
        

        model.addAttribute("flag_return", flag_return);
        model.addAttribute("city",city);
        model.addAttribute("temperatura", tempService.getTemperature(city));

        return "temperatureView";
    }

    @GetMapping("/temperature")
    public String temperatureView() {

        return "temperatureView";
    }

}
