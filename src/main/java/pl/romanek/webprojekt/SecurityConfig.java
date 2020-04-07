
package pl.romanek.webprojekt;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;

@Configuration
@EnableWebSecurity
@ComponentScan({"pl.romanek.webprojekt"})
public class SecurityConfig  extends WebSecurityConfigurerAdapter{


    @Bean
    public UserDetailsService userDetailsService(){
        
        UserDetails userDetails = User.withDefaultPasswordEncoder()
                .username("user")
                .password("user")
                .roles("USER")
                .build();
        return new InMemoryUserDetailsManager(userDetails);
    }



    @Override
    protected void configure(HttpSecurity http) throws Exception {
        
        http.authorizeRequests()
                .antMatchers("/").permitAll()
                .anyRequest().hasRole("USER")
                .and()
                .formLogin()
                .loginProcessingUrl("/login")
                .loginPage("/").permitAll()
                .defaultSuccessUrl("/userPanel");
                http.csrf().disable();
              
               
    }
    
    
    
    
}
