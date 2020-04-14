package pl.romanek.webprojekt;

import java.util.Locale;
import org.springframework.context.MessageSource;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.support.ReloadableResourceBundleMessageSource;
import org.springframework.validation.beanvalidation.LocalValidatorFactoryBean;
import org.springframework.web.multipart.commons.CommonsMultipartResolver;
import org.springframework.web.servlet.LocaleResolver;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.PathMatchConfigurer;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.ViewResolverRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;
import org.springframework.web.servlet.i18n.LocaleChangeInterceptor;
import org.springframework.web.servlet.i18n.SessionLocaleResolver;
import org.springframework.web.servlet.resource.PathResourceResolver;
import org.springframework.web.util.UrlPathHelper;
import pl.romanek.webprojekt.shop.interceptor.TestInterceptor;

@EnableWebMvc //mam zdefiniowany plik konfiguracyjny w root więc musze @EnableWebMvc
@Configuration //określam, że jest to klasa konfiguracyjna
@ComponentScan({"pl.romanek.webprojekt"}) // podaje gdzie ma szukać kontrolerów

// klasa implementuje interfejs WebMvcConfigurer, który pozwala na nadpisanie ustawień za pomocą metod
public class AppConfig implements WebMvcConfigurer {

    // określam ViewResolver - podaje, że widoki są w folderze WEB-INF i mają rozszerzenie .jsp
    @Override
    public void configureViewResolvers(ViewResolverRegistry registry) {
        registry.jsp("/WEB-INF/", ".jsp");
    }
    
    
    // określam ładowanie statycznych elementów
    // folder resources stworzony pod Web-Pages jest domyśłny
    @Override
    public void addResourceHandlers(ResourceHandlerRegistry registry) {

        registry
                .addResourceHandler("/resources/**")
                .addResourceLocations("/resources/")
                .setCachePeriod(3600)
                .resourceChain(true)
                .addResolver(new PathResourceResolver());
    }

   
    //konfiguracja aby można było obsługiwać MatrixVariables (filtrowanie wszyukiwania produktow)
    @Override
    public void configurePathMatch(PathMatchConfigurer configurer) {
        UrlPathHelper urlPathHelper = new UrlPathHelper();
        urlPathHelper.setRemoveSemicolonContent(false);
        configurer.setUrlPathHelper(urlPathHelper);
    }

    
    //konfiguracja aby można było ładować pliki 
    //określenie maksymalnego rozmiaru pliku
    @Bean(name = "multipartResolver")
    public CommonsMultipartResolver multipartResolver() {
        CommonsMultipartResolver multipartResolver = new CommonsMultipartResolver();
        multipartResolver.setMaxUploadSize(100000);
        return multipartResolver;
    }
    

    //ponizej konfiguracja aby dzialala zmiana jezyka
    //ustawiam domyslne ustawienia jeyzka - US
    @Bean(name = "localeResolver")
    public LocaleResolver localeResolver() {
        SessionLocaleResolver slr = new SessionLocaleResolver();
        slr.setDefaultLocale(Locale.US);
        return slr;
    }

    //tworzę (tak naprawdę on istnieje - dostarczony przez Springa) przechwytywacz, ustalam pod jaka sciezka bedzie zmiana jezyka 
    //?language=pl
    @Bean
    public LocaleChangeInterceptor localeChangeInterceptor() {
        LocaleChangeInterceptor lci = new LocaleChangeInterceptor();
        lci.setParamName("language");
        return lci;
    }

    
    //metoda poniżej dodaje przechwytywacze do rejestru
    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        registry.addInterceptor(localeChangeInterceptor());
        registry.addInterceptor(new TestInterceptor()).addPathPatterns("/shop");
        //dodaje utworzony przeczwytywacz TestInterceptor oraz ustalam ścieżkę, pod którą będzie działał
    }

    
    //określam gdzie beda sie znajdowac pliki properties z jezykami
    @Bean(name = "messageSource")
    public MessageSource messageSource() {
        ReloadableResourceBundleMessageSource messageSource = new ReloadableResourceBundleMessageSource();
        messageSource.setBasename("/WEB-INF/messages/messages");
        messageSource.setCacheSeconds(10); //reload messages every 10 seconds
        return messageSource;
    }

    
    // WALIDATOR - definiuje gdzie znajduje się źródło komunikatów błędów. Jest w tym samym miejscu co ustawienia jezyka więc używam wcześniej utworzonego beana
    @Bean
    public LocalValidatorFactoryBean getValidator() {
        LocalValidatorFactoryBean bean = new LocalValidatorFactoryBean();
        bean.setValidationMessageSource(messageSource());
        return bean;
    }
}
