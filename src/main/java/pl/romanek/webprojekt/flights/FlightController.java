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
    public String flightView(Model model) {
     
        model.addAttribute(new Flight()); //do modelu zostaje przekazany @Bean o nazwie flight
                                          //domyślnie Beany maja takie nazwy: klasa -  Flight - bean - flight
        return "flightView";              //                                  klasa -  MyFlight - bean - myFlight
                                          //na stronie flightView korzystam z Beana flight(formularz) więc muszę go dostarczyć bo inaczej będzie błąd
    }                                     //w modelu form:form modelAttribute przekazuje wlasnie flight - tego Beana będzie używał formularz
                                          //będzie również działać jak parametrze metody dam tylko Flight flight
                                          //Jeżeli natomaist dodam w parametrze metody @ModelAttribute("newFlight") Flight flight to w flightView również ten Bean tak sie musi nazywać
                                          //czyli form:form modelAttribute="newFlight"

    @PostMapping("/flight")
    public String checkFlights(Model model, @Valid Flight flight, BindingResult result) throws IOException {
            //nazwa obiektu Flight flight nie musi się wcale zgadzać z tym co mam na stronie flightView w modelAtribute
            //@Bean z flightView zostaje poprostu włożony?(czy poprostu zostają przepisane wartości pól?) do metody checkFlights() jako paramter.
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
