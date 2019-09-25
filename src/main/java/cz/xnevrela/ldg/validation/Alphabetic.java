package cz.xnevrela.ldg.validation;

import javax.validation.Constraint;
import javax.validation.Payload;
import javax.validation.constraints.NotNull;
import java.lang.annotation.Documented;
import java.lang.annotation.Repeatable;
import java.lang.annotation.Retention;
import java.lang.annotation.Target;

import static java.lang.annotation.ElementType.*;
import static java.lang.annotation.ElementType.PARAMETER;
import static java.lang.annotation.ElementType.TYPE_USE;
import static java.lang.annotation.RetentionPolicy.RUNTIME;

/**
 * The annotated element must contain only alphabetic characters. Supports UNICODE alphabets.
 */
@Target({ METHOD, FIELD, ANNOTATION_TYPE, CONSTRUCTOR, PARAMETER, TYPE_USE })
@Retention(RUNTIME)
@Documented
@Constraint(validatedBy = {AlphabeticValidator.class})
public @interface Alphabetic {

    String message() default "{cz.xnevrela.ldg.validation.Alphabetic.message}";

    Class<?>[] groups() default { };

    Class<? extends Payload>[] payload() default { };
}
