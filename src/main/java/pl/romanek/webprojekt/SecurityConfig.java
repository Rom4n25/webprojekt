package pl.romanek.webprojekt;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.builders.WebSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;
import org.springframework.security.web.firewall.HttpFirewall;
import org.springframework.security.web.firewall.StrictHttpFirewall;

@Configuration
@EnableWebSecurity
@ComponentScan({"pl.romanek.webprojekt"})
public class SecurityConfig extends WebSecurityConfigurerAdapter {


    
    
    @Bean
    public UserDetailsService userDetailsService() {

        UserDetails userDetails = User.withDefaultPasswordEncoder()
                .username("user")
                .password("user")
                .roles("USER")
                .build();

        UserDetails adminDetails = User.withDefaultPasswordEncoder()
                .username("admin")
                .password("admin")
                .roles("ADMIN")
                .build();

        return new InMemoryUserDetailsManager(userDetails, adminDetails);
    }

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http.httpBasic();
        http.authorizeRequests()
                .antMatchers("/login/*").permitAll()
                .antMatchers("/shop/add").hasRole("ADMIN")
                .anyRequest().hasAnyRole("USER", "ADMIN")
                .and()
                .formLogin()
                .loginProcessingUrl("/login") //tutaj musi byc to samo co jest w index.jsp ---> action="/login"
                .loginPage("/").permitAll()
                .defaultSuccessUrl("/menu")
                .failureUrl("/error")
                .and()
                .logout()
                .logoutUrl("/logout") //tutaj musi byc to samo co jest w stronach jsp w przyciskach ---> action="/logout"
                .logoutSuccessUrl("/");

        http.csrf().disable();

    }


    
    // PONIZEJ METODY ABY MOZNA BYLO UZYWAC ";" W URL --- PO WPROWADZENIU SPRING SECURITY WYSKAKIWAL BLAD
    // The request was rejected because the URL contained a potentially malicious String ";
    @Bean
    public HttpFirewall allowUrlEncodedSlashHttpFirewall() {
        StrictHttpFirewall firewall = new StrictHttpFirewall();
        firewall.setAllowUrlEncodedSlash(true);
        firewall.setAllowSemicolon(true);
      
       
        return firewall;
    }

    @Override
    public void configure(WebSecurity web) throws Exception {
        super.configure(web);
        web.httpFirewall(allowUrlEncodedSlashHttpFirewall());
    }


}
