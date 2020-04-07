package pl.romanek.webprojekt.sumTwo;

import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult; 
import org.springframework.web.bind.annotation.ModelAttribute; 
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;
import javax.servlet.ServletException;
import java.io.IOException;



@Controller  //musze określić, że klasa jest Controllerem, któego będzie wyszukiwał spring
public class addController { //nazywam go sobie dowolnie, nie ma to znaczenia

    @RequestMapping("dodaj") //jeżeli zostanie wywołane mapowanie "dodaj" na stronie .jsp to wtedy zostanie tutaj obsłużone
    public ModelAndView dodaj(@ModelAttribute("dodawanie") sumLogic dodawanie, BindingResult result) throws IOException, ServletException {
            //tworzę metodę ModelAndView i określam za pomocą @ModelAttribute jaka klasa ma zostać wypełniona danymi
            //towrzy się obiekt "dodawanie" klasy sumLogic
            //ta klasa musi posiadać takie same nazwy zmiennych jakie są podawane na stronie jsp
            // Ogólnie:
            // Używamy @ModelAttribute jako Parameter: Use it on a parameter when you want to bind data from the request and add it to the model implicitly(niejawnie)
            //          @ModelAttribute jako metoda:  If you need the model for a particular controller to be always populated with certain attributes the method level @ModelAttribute makes more sense. 
            //   
            //          @ModelAttribute("person")
            //          public Person getPerson(){
            //          return new Person();
            //          }
            //          This annotated method will allow access to the Person object in your View, since it gets automatically added to the Models by Spring. 
           
           
            //tworzę także obiekt "result" klasy BindingResult, który informować będzie o tym jak przebiegło przypisywanie wartości
            //jeżeli coś się nie udało np. błędne wartości, nieuzupełnione pola to obiekt "result" będzie przechowywał błąd
            
 
            
        ModelAndView mv = new ModelAndView();
        //tworzę obiekt mv z klasy ModelAndView

        
        if(result.hasErrors()){
            mv.setViewName("addView");
            mv.addObject("result","You are not provided numbers!");
           return mv;
        }
        // jeżeli coś poszło nie tak i result będzie miał błędy to zamiiast wyniku pokazuje się komunikat
        

        mv.setViewName("addView");
        mv.addObject("result",dodawanie.sum());

        return mv;

    }

    @RequestMapping("sumTwoApp")
    public ModelAndView sumTwo(){

        ModelAndView mv = new ModelAndView();
        mv.setViewName("addView");
        return mv;
    }

}