package pl.romanek.webprojekt.sumThree;


import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.ServletException;
import java.io.IOException;

@Controller
public class addThreeController {

    @RequestMapping("suma3")
    public ModelAndView dodaj(@ModelAttribute("dodawanie2") sumLogic3 dodawanie2, BindingResult result) throws IOException, ServletException {


        ModelAndView mv = new ModelAndView();

        
        if(result.hasErrors()){
            mv.setViewName("addThreeView");
            mv.addObject("result","You are not provided numbers!");
           return mv;
        }

        mv.setViewName("addThreeView");
        mv.addObject("result",dodawanie2.sumowanie3());

        return mv;

    }

    @RequestMapping("sumThreeApp")
    public ModelAndView sumThree(){

        ModelAndView mv = new ModelAndView();
        mv.setViewName("addThreeView");
        return mv;
    }

}