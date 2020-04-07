package pl.romanek.webprojekt.temperature;

import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;
import javax.servlet.ServletException;
import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;

@Controller
public class tempController {

    @RequestMapping("checkTemp")
    public ModelAndView temp(@RequestParam("city")String city) throws IOException, MalformedURLException, ServletException {

        URL url = new URL("https://api.openweathermap.org/data/2.5/weather?q="+city+"&APPID=69c6903d6aa55a949b6e61ec65dd1608&units=metric");
        ObjectMapper mapper = new ObjectMapper();
        JsonNode rootNode = mapper.readTree(url).get("main").get("temp");
        double tempValue = rootNode.asDouble();

        mapper.configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES,false);

        Temp t1 = new Temp();
        t1.setTemp(tempValue);


        ModelAndView mv = new ModelAndView();
        mv.setViewName("checkTempView");
        mv.addObject("temperatura","Temperature in "+city+" is "+t1.getTemp()+ " Celsius!");

        return mv;
    }

    @RequestMapping("checkTempView")
    public ModelAndView checkTempView(){

        ModelAndView mv=new ModelAndView();
        mv.setViewName("checkTempView");

        return mv;
    }

}