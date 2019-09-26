package cz.xnevrela.ldg.validation;

import org.assertj.core.api.Assertions;
import org.junit.Test;

import static org.junit.Assert.*;

public class AlphabeticValidatorTest {

    private AlphabeticValidator testSubject = new AlphabeticValidator();

    @Test
    public void whenNullValue_returnsValid() {
        boolean result = testSubject.isValid(null, null);
        Assertions.assertThat(result).isTrue();
    }

    @Test
    public void whenAlphabeticOnly_returnsValid() {
        boolean result = testSubject.isValid("OnlyAlpha", null);
        Assertions.assertThat(result).isTrue();
    }

    @Test
    public void whenAlphaNumericValue_returnsInvalid() {
        boolean result = testSubject.isValid("a1a", null);
        Assertions.assertThat(result).isFalse();
    }

    @Test
    public void whenContainsSpecialCharacter_returnsInvalid() {
        boolean result = testSubject.isValid("b,b", null);
        Assertions.assertThat(result).isFalse();
    }

}
