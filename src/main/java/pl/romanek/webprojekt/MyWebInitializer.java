package pl.romanek.webprojekt;
//paczka w jakiej znajduje sie klasa

import org.springframework.web.servlet.support.AbstractAnnotationConfigDispatcherServletInitializer;
//zaimportowana paczka, która zawiera gotowe klasy abstrakcyjne springa


public class MyWebInitializer extends AbstractAnnotationConfigDispatcherServletInitializer {
//tworzę klasę (MyWebInitializer), która dziedziczy po klasie abstrakcyjnej (AbstractAnnotationConfigDispatcherServletInitializer)
    
    //poniżej metody, które nadpisuję aby dokonać konfiguracji
    
	@Override
	protected Class<?>[] getRootConfigClasses() {
		// TODO Auto-generated method stub
		return new Class[] {AppConfig.class,SecurityConfig.class};
	}
        
        //      podpinam klasę konfiguracyjną - w prostych aplikacjach mogę mieć wszystko tutaj

	@Override
	protected Class<?>[] getServletConfigClasses() {
		// TODO Auto-generated method stub
		return null;
	}
        
        //      mogę zostawić puste - to się przydaje gdy mam kilka DispatcherServletów, któe są różne ale mają wspólne Beany
        //      (pobierane z getRootConfigClasses())

	@Override
	protected String[] getServletMappings() {
		// TODO Auto-generated method stub
		return new String[] {"/"};
	}
        //definiowane jest mapowanie do DispatcherServletu
        
        // "/" - to jest domyślne mapowanie default servlet na tomcacie (do obłsugi statycznych zadań)
        //       jeżeli w mapowaniu (getServletMappings) ustawimy tak samo
        //       to ten default servlet na tomcacie zostanie zastąpiony springiem
        //       UWAGA! - nie nadpisujemy servletu jsp (do ładowania widoków)
        //       można ten default włączyć metodą DefaultServletHandlerConfigurer
        
        // "/*"- jeżeli takie mapowanie ustawimy w metodzie, to zostaną nadpisane
        //       wszystkie inne servlety (default servlet oraz jsp servlet)
        //       Wszystko bedzie obsługiwane przez springa, musimy określić ViewResolver w konfigu
        
        
        // "/spring/*" - tak też można mapować ale wtedy musimy okreśłić ViewResolver w konfigu bo inaczej pojawia się błąd....
        //               servlet nie wie skąd ma wziąć widoki (strony .jsp) ponieważ został nadpisany defaultowy servlet jsp, którego nie ustawiliśmy
        //               wtedy w requescie dajemy ("/spring/zaloguj") a w kontrolerze ("zaloguj")
        
        
        //"/spring/" - wtedy w requescie musi być tylko ("/spring/") i w kontrolerze też ("/spring/") bo innego url nie obsłuży
        //             
        
        
        
}
