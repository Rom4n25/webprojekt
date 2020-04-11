package pl.romanek.webprojekt.temperature;


import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestParam;
import javax.servlet.ServletException;
import java.io.IOException;
import java.net.MalformedURLException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class TempController {

    @Autowired
    TempService tempService;
    @PostMapping("/temperature")
    public String temperature (Model model,@RequestParam("city")String city) throws IOException, MalformedURLException, ServletException {

       Boolean flag = true;
       
       model.addAttribute("flag",flag);
       model.addAttribute("temperatura",tempService.getTemperature(city));

       return "temperatureView";
    }

    @GetMapping("/temperature")
    public String temperatureView(){

        
        return "temperatureView";
    }

}