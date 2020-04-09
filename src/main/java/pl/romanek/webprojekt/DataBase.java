package pl.romanek.webprojekt;

import org.springframework.stereotype.Component;
import java.util.HashMap;

//STARY SYSTEM LOGOWANIA - KLASA NIEUŻYWANA

@Component
public class DataBase {

    public HashMap<String,String> userlist;

    public DataBase() {
        this.userlist = new HashMap<>();
        this.userlist.put("Mateusz","123");
        this.userlist.put("Dagmara","2411");
    }

    public HashMap<String, String> getUserlist() {
        return userlist;
    }

    public boolean validate(String login, String password){

        boolean flag = false;
        if(this.userlist.keySet().contains(login)&&this.userlist.get(login).equals(password)){

            flag = true;
        }
        return flag;
    }

}