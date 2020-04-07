package pl.romanek.webprojekt.game;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class GameController {

//@Autowired
//Hero hero;

    @RequestMapping("herocreate")
    public ModelAndView getFormView(){

        ModelAndView mv = new ModelAndView("formView");
        return mv;

    }

    @RequestMapping("createmyhero")

        public ModelAndView createhero(@ModelAttribute("hero1") Hero hero){

        //mozna tez uzywac @RequestParam ale wtedy musze sam przypisywac wartosci do Obiektu --> najpierw musze go jednak stworzyc na gorze
        //public ModelAndView createhero(@RequestParam("vehicletype") String vehicletype, @RequestParam("weapontype") String weapontype, @RequestParam("name") String name){

        //hero.setName(name);
        //hero.getVehicle().setType(vehicletype);
        //hero.getWeapon().setType(weapontype);

        ModelAndView mv = new ModelAndView("heroDetailsView");

       // mv.addObject("result",hero.getVehicle().getType());
      //  mv.addObject("result2",hero.getWeapon().getType());
       // mv.addObject("result3",hero.getName());

        return mv;
        }

    }

