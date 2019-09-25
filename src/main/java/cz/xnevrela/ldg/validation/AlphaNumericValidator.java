package cz.xnevrela.ldg.validation;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;
import java.util.regex.Pattern;

/**
 * Validates {@link AlphaNumeric} constraint
 */
public class AlphaNumericValidator implements ConstraintValidator<AlphaNumeric, String> {
    private static final Pattern pattern = Pattern.compile("^(?U)[\\p{Alpha}\\d]*");

    @Override
    public void initialize(AlphaNumeric constraintAnnotation) {

    }

    @Override
    public boolean isValid(String value, ConstraintValidatorContext context) {
        return pattern.matcher(value).matches();
    }
}
