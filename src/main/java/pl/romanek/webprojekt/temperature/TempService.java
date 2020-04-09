
package pl.romanek.webprojekt.temperature;

import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;
import org.springframework.stereotype.Service;

@Service
public class TempService {

    
    public String getTemperature(String city) throws MalformedURLException, IOException{
        
        URL url = new URL("https://api.openweathermap.org/data/2.5/weather?q=" + city + "&APPID=69c6903d6aa55a949b6e61ec65dd1608&units=metric");
        ObjectMapper mapper = new ObjectMapper();
        JsonNode rootNode = mapper.readTree(url).get("main").get("temp");
        double tempValue = rootNode.asDouble();

        mapper.configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false);

       return "Temperature in " + city + " is " + tempValue + " Celsius!";
        
                
    }
    
    
}
