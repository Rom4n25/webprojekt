
package pl.romanek.webprojekt.shop.validator;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import pl.romanek.webprojekt.shop.domain.Product;
import pl.romanek.webprojekt.shop.service.ProductService;

@Component
public class ProductIdValidator implements ConstraintValidator<ProductId,String>{

   @Autowired
    private ProductService productService;
    
    @Override
    public void initialize(ProductId constraintAnnotation) {
        //trzeba pozostawic puste bo inaczej nie dziala
    }

    
    
    @Override
    public boolean isValid(String t, ConstraintValidatorContext cvc) {
        
        Product product;
        
        try{
            
                    
            product= productService.getProductById(t);
            
        }catch(Exception e){
            
            return true;
        }
        
        if(product!=null){
            return false;
        }
        
        return true;
    }
    
    
    
}
