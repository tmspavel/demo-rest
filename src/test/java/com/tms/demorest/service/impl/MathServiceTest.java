package com.tms.demorest.service.impl;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class MathServiceTest {

    private final MathService mathService = new MathService();

    @Test
    void testDevSuccess() {
        Integer result = mathService.dev(20, 5);
        Assertions.assertEquals(4, result);
    }

    @Test
    void testDevSuccess1() {
        Integer result = mathService.dev(0, 2);
        Assertions.assertEquals(4, result);
    }

    @Test
    void test_dev_by_zero_return_exception() {
        Assertions.assertThrows(ArithmeticException.class, () -> mathService.dev(20, 0));
    }
}
