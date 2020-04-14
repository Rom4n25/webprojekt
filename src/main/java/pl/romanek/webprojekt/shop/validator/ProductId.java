package pl.romanek.webprojekt.shop.validator;


import java.lang.annotation.Documented;
import java.lang.annotation.Retention;
import java.lang.annotation.Target;

import static java.lang.annotation.ElementType.FIELD;
import static java.lang.annotation.RetentionPolicy.RUNTIME;

import javax.validation.Constraint;
import javax.validation.Payload;

@Documented
@Constraint(validatedBy = ProductIdValidator.class) //określam, która klasa będzie dokonywała walidacji
@Target({FIELD})
@Retention(RUNTIME)


//utworzyłem klasę walidująća
public @interface ProductId {

    String message() default "{shop.validator.ProductId.message}";

    
    //poniższe metody nie zostały wyjasnione
    Class<?>[] groups() default {};
    
    Class<? extends Payload>[] payload() default {};

}
