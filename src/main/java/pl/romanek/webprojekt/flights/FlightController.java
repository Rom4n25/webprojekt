package pl.romanek.webprojekt.flights;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestParam;
import java.io.IOException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class FlightController {

    @Autowired
    FlightService flightService;

    @PostMapping("/flight")
    public String checkFlights(Model model, @RequestParam("date") String date, @RequestParam("time1") String time1, @RequestParam("time2") String time2, @RequestParam("airportname") String airport) throws IOException {

        Boolean flag = true;
        flightService.checkFligt(date, time1, time2, airport);

        model.addAttribute("depAirports", flightService.getDepAirports());
        model.addAttribute("depDate", flightService.getDepDates());
        model.addAttribute("arrDate", flightService.getArrDates());
        model.addAttribute("callsign", flightService.getCallsigns());
        model.addAttribute("flag",flag);

        return "flightView";
    }

    @GetMapping("/flight")
    public String flightView(Model model) {

        return "flightView";
    }

}
