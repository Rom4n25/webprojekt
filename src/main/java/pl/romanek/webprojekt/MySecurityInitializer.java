package pl.romanek.webprojekt;

import org.springframework.context.annotation.Bean;
import org.springframework.security.config.annotation.web.builders.WebSecurity;
import org.springframework.security.web.context.AbstractSecurityWebApplicationInitializer;
import org.springframework.security.web.firewall.HttpFirewall;
import org.springframework.security.web.firewall.StrictHttpFirewall;

public class MySecurityInitializer extends AbstractSecurityWebApplicationInitializer {

    //muszę stworzyć taką klasę bo inaczej spring security nie zadziała

}
