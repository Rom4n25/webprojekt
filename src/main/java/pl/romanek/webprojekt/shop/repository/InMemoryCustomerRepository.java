
package pl.romanek.webprojekt.shop.repository;

import java.util.ArrayList;
import java.util.List;
import org.springframework.stereotype.Repository;
import pl.romanek.webprojekt.shop.domain.Customer;

@Repository
public class InMemoryCustomerRepository implements CustomerRepository {

    private List<Customer> listOfCustomers = new ArrayList<>();
    
    
    
    public InMemoryCustomerRepository() {
        
        Customer customerNo1 = new Customer("C1","Mateusz","Stawowa 11",0);
        Customer customerNo2 = new Customer("C2","Dagmara","Zygmuntowska 9",3);
        Customer customerNo3 = new Customer("C3","Leszek","Basztowa 12",6);
        
        listOfCustomers.add(customerNo1);
        listOfCustomers.add(customerNo2);
        listOfCustomers.add(customerNo3);
        
        
    }
    
    
    
    
    @Override
    public List<Customer> getAllCustomers() {
       
        return listOfCustomers;
    }
    
}
