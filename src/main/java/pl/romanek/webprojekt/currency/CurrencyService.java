package pl.romanek.webprojekt.currency;

import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;
import org.springframework.stereotype.Service;


@Service
public class CurrencyService {

    public String convertCurrency(String currency1, String currency2, String amount) throws MalformedURLException, IOException {

        double doubleAmount = Double.parseDouble(amount);
        URL url = new URL("https://api.exchangeratesapi.io/latest?base=" + currency1 + "&symbols=" + currency2);

        ObjectMapper mapper = new ObjectMapper();
        mapper.configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false);
        JsonNode node = mapper.readTree(url);

        float przelicznik = node.get("rates").get(currency2).floatValue();
        double value = Math.round(przelicznik * doubleAmount * 100.0) / 100.0;

        return amount + " " + currency1 + " = " + value + " " + currency2;

    }
}
