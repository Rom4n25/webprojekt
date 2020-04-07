package pl.romanek.webprojekt;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.PathMatchConfigurer;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.ViewResolverRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;
import org.springframework.web.servlet.resource.PathResourceResolver;
import org.springframework.web.util.UrlPathHelper;


@EnableWebMvc //mam zdefiniowany plik konfiguracyjny w root więc musze @EnableWebMvc
@Configuration //określam, że jest to klasa konfiguracyjna
@ComponentScan({"pl.romanek.webprojekt"}) // podaje gdzie ma szukać kontrolerów
public class AppConfig implements WebMvcConfigurer {

    // klasa implementuje interfejs WebMvcConfigurer, który pozwala na nadpisanie ustawień za pomocą metod
    
	@Override
	public void configureViewResolvers(ViewResolverRegistry registry) {
		registry.jsp("/WEB-INF/",".jsp");
	}
        // określam ViewResolver - podaje, że widoki są w folderze WEB-INF i mają rozszerzenie .jsp
        
        
        @Override
        public void addResourceHandlers(ResourceHandlerRegistry registry){
            
            registry
                    .addResourceHandler("/resources/**")
                    .addResourceLocations("/resources/")
                    .setCachePeriod(3600)
                    .resourceChain(true)
                    .addResolver(new PathResourceResolver());
            
        }
        
        // określam ładowanie statycznych elementów
        // folder resources stworzony pod Web-Pages jest domyśłny
        // statyczny kontent nie powinien być serwowany przez springa bo wtedy czas się wydłuża
        // po co ma wszystko przechodzić przez DispatcherServlet, kontrolery itp...
        
        @Override
        public void configurePathMatch(PathMatchConfigurer configurer) {
        UrlPathHelper urlPathHelper = new UrlPathHelper();
        urlPathHelper.setRemoveSemicolonContent(false);
        configurer.setUrlPathHelper(urlPathHelper);
        
        //tutaj jest konfiguracja aby MatrixVariables mozna bylo obslugiwac(filtrowanie wszyukiwania produktow)
    }
        
}

