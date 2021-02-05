package cn.itook.demo.springboot.utils;

import org.springframework.stereotype.Component;

import javax.validation.ConstraintViolation;
import javax.validation.Validation;
import javax.validation.Validator;
import java.util.Set;

/**
 * @author changyanan1
 */
@Component
public class ValidationUtils {
    static Validator validator = Validation.buildDefaultValidatorFactory().getValidator();

    public static <T> void validate(T t) throws Exception {
        Set<ConstraintViolation<T>> constraintViolations = validator
                .validate(t);
        if (constraintViolations.size() > 0) {
            String validateError = "";
            for (ConstraintViolation<T> constraintViolation : constraintViolations) {
                validateError += constraintViolation.getMessage() + ";";
            }
            throw new Exception(validateError);
        }
    }
}
