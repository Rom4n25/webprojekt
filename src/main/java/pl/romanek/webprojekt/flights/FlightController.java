package pl.romanek.webprojekt.flights;

import org.springframework.stereotype.Controller;
import java.io.IOException;
import javax.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class FlightController {

    @Autowired
    FlightService flightService;

    @GetMapping("/flight")
    public String flightView(Model model, @ModelAttribute("flight") Flight flight) {

        return "flightView";
    }

    @PostMapping("/flight")
    public String checkFlights(Model model, @Valid @ModelAttribute("flight") Flight flight, BindingResult result) throws IOException {

        if (result.hasErrors()) {

            return "flightView";
        }

        if (flightService.checkFligt(flight) == false) {
            
            Boolean error = true;
            model.addAttribute("noFlight",error);
            return "flightView";

        }

        Boolean flag = true;
        flightService.checkFligt(flight);

        model.addAttribute("depAirports", flightService.getDepAirports());
        model.addAttribute("depDate", flightService.getDepDates());
        model.addAttribute("arrDate", flightService.getArrDates());
        model.addAttribute("callsign", flightService.getCallsigns());
        model.addAttribute("flag", flag);

        return "flightView";
    }

}
