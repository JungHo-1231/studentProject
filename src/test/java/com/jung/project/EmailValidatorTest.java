package com.jung.project;

import org.junit.jupiter.api.Test;
import static org.assertj.core.api.Assertions.assertThat;

class EmailValidatorTest {

    private final EmailValidator underTest = new EmailValidator();

    @Test
    void itShouldValidateCorrectEmail() {
       assertThat(underTest.test("hello@gamil.com")).isTrue();
    }

    @Test
    void itShouldValidateInCorrectEmail() {
        assertThat(underTest.test("hellogamil.com")).isFalse();
    }

    @Test
    void itShouldValidateCorrectEmailWithoutDotAtTheEnd() {
        assertThat(underTest.test("hello@gamil")).isFalse();
    }
}