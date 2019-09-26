package cz.xnevrela.ldg.validation;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;
import java.util.regex.Pattern;

/**
 * Validates {@link Alphabetic} constraint
 */
public class AlphabeticValidator implements ConstraintValidator<Alphabetic, String> {
    private static final Pattern pattern = Pattern.compile("^(?U)[\\p{Alpha}]*");

    @Override
    public void initialize(Alphabetic constraintAnnotation) {

    }

    @Override
    public boolean isValid(String value, ConstraintValidatorContext context) {
        if (value == null) {
            return true;
        }

        return pattern.matcher(value).matches();
    }
}
