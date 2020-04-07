package pl.romanek.webprojekt.currency;

import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;
import java.io.IOException;
import java.net.URL;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class currencyController {

@RequestMapping("waluta2")
    public ModelAndView currency(@RequestParam("currency1")String currency1,@RequestParam("currency2")String currency2,@RequestParam("amount")String amount) throws IOException {
        
        double doubleAmount = Double.parseDouble(amount);
        URL url = new URL("https://api.exchangeratesapi.io/latest?base="+currency1+"&symbols="+currency2);
  
        ObjectMapper mapper = new ObjectMapper();
        mapper.configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES,false);
        JsonNode node= mapper.readTree(url);
        
       
        float przelicznik = node.get("rates").get(currency2).floatValue();
        double value = Math.round(przelicznik*doubleAmount*100.0)/100.0;

        String msg = amount + " "+currency1+" = "+value+" "+currency2;
     
         ModelAndView mv = new ModelAndView();
         mv.setViewName("newcurrencyView");
         mv.addObject("msg",msg);
         
       
        return mv;

    }
    
    
      @RequestMapping("newCurrency")
    public ModelAndView checkTempView(){

        ModelAndView mv=new ModelAndView();
        mv.setViewName("newcurrencyView");

        return mv;
    }



}
