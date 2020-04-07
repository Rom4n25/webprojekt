
package pl.romanek.webprojekt.shop.service;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pl.romanek.webprojekt.shop.domain.Customer;
import pl.romanek.webprojekt.shop.repository.CustomerRepository;

@Service
public class CustomerServiceImpl implements CustomerService{

    @Autowired
    CustomerRepository customerRepository;
    
    
    @Override
    public List<Customer> getAllCustomers() {
       
        return customerRepository.getAllCustomers();
        
    }
    
}
