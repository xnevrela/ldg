package cz.xnevrela.ldg.validation;

import javax.validation.Constraint;
import javax.validation.Payload;
import java.lang.annotation.Documented;
import java.lang.annotation.Retention;
import java.lang.annotation.Target;

import static java.lang.annotation.ElementType.*;
import static java.lang.annotation.RetentionPolicy.RUNTIME;

/**
 * The annotated element must contain only alphabetic or numeric characters. Supports UNICODE alphabets.
 */
@Target({ METHOD, FIELD, ANNOTATION_TYPE, CONSTRUCTOR, PARAMETER, TYPE_USE })
@Retention(RUNTIME)
@Documented
@Constraint(validatedBy = { AlphaNumericValidator.class })
public @interface AlphaNumeric {

    String message() default "{cz.xnevrela.ldg.validation.AlphaNumeric.message}";

    Class<?>[] groups() default { };

    Class<? extends Payload>[] payload() default { };
}
