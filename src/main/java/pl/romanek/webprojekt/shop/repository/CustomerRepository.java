
package pl.romanek.webprojekt.shop.repository;

import java.util.List;
import pl.romanek.webprojekt.shop.domain.Customer;


public interface CustomerRepository {
    
    List<Customer> getAllCustomers();
    
}
