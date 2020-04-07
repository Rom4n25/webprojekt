package pl.romanek.webprojekt;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import org.springframework.web.bind.annotation.GetMapping;


@Controller
public class LogInController {

    @Autowired
    DataBase dataBase;

    @RequestMapping("/")  //moge miec strone index.jsp w pliku WEB-INF i jak laduje sie spring to wczytuje automatycznie strone startowa
    public String home(){
        return "index";
    }


    
   @GetMapping("userPanel")
    public String userpanel(){
        return "userPanel";
    }

    
    @GetMapping("backToUserPanel")
    public String backToUserPanel(){
        return "userPanel";
    }
 
    
   // ########################################################
    
  // INNY SPOSOB NA MAPOWANIE ZA POMOCA ModelAndView
  // @RequestMapping("backToUserPanel")
  // public ModelAndView backToUserPanel(){

  //      ModelAndView mv = new ModelAndView();
  //      mv.setViewName("userPanel");

  //      return mv;
  //  }

   // ######################################################## 
    
   // STARE LOGOWANIE z klasa DataBase
   // @PostMapping("userPanel")
   // public ModelAndView zaloguj (@RequestParam("login") String login,@RequestParam("password") String password) throws IOException {

   //  ModelAndView mv = new ModelAndView();
   //     if(dataBase.validate(login,password)){
   //        writeToFile();
   //        mv.setViewName("userPanel");
   //        mv.addObject("loginSucces",login);

   //     }else{
   //        mv.setViewName("index");
   //        mv.addObject("loginNotSucces","WRONG USERNAME OR PASSWORD!");
   //     }

   //    return mv;
   //  }
    
   // ########################################################
    
   //   public void writeToFile() throws IOException {
   //      File file = new File("C:/Users/Mateusz/Desktop/ProjektyJava/webstrona/src/main/webapp/WEB-INF/logi.txt");
   //      FileWriter writer = new FileWriter(file,true);
   //      DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy/MM/dd HH:mm:ss");
   //      LocalDateTime now = LocalDateTime.now();
   //      writer.write("LOGOWANIE POPRAWNE "+dtf.format(now));
   //      writer.write("\n");
   //      writer.flush();
   //      writer.close();
   //    }

}