package com.lq.ecommerce.annotations;
import com.lq.ecommerce.repository.BuyerRepository;
import jakarta.validation.ConstraintValidator;
import jakarta.validation.ConstraintValidatorContext;
import org.springframework.beans.factory.annotation.Autowired;

public class EmailUniqueValidator implements ConstraintValidator<EmailUnique, String> {

    @Autowired
    private BuyerRepository buyerRepository;


    @Override
    public void initialize(EmailUnique constraintAnnotation) {
    }

    @Override
    public boolean isValid(String email, ConstraintValidatorContext context) {
        if (email == null || email.isEmpty()) {
            return true; // Let @Email handle null or empty
        }
        return !buyerRepository.existsByEmail(email); // Check if the email exists
    }
}