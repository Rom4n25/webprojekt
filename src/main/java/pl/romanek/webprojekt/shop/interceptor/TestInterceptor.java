
package pl.romanek.webprojekt.shop.interceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;


//moge też rozszerzać klasę HandlerInterceptor ale wtedy muszę nadpisać wszystkie
//3 interceptory (przechwytywacze) pre, post i after

//potem ten interceptor musze dodać do rejestru, który jest w klasie konfiguracyjnej AppConfig
public class TestInterceptor extends HandlerInterceptorAdapter {

    
    //metoda wywoływana kiedy żądanie zostało przetworzone i widok został wygenerowany
    @Override
    public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex) throws Exception {
        System.out.println("afterCompletion - working :)");
    }

    
    //metoda wywoływana  tuż po zakończeniu przetwarzania żądania ale też tuż przed wygenerowaniem widoku
    //możemy dodać jakieś dodatkowe atrybuty do modelu 
    
    @Override
    public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler, ModelAndView modelAndView) throws Exception {
        System.out.println("postHandle - working :)");
    }

    
    //metoda wywoływanwa przed przetworzeniem żądania
    //zwraca true aby przesłać żądanie dalej do controllera albo do innego przechwytywacza
    //zwraca false - wtedy spring traktuje, że żadanie zostało przetworzone i nie przesyła go nigdzie dalej
    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
       
        System.out.println("preHandle - working :)");
        
        return true;
    }
    
    
    
}
