package com.random.address.util;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.anyOf;
import static org.hamcrest.Matchers.is;
@SpringBootTest
class RandomBooleanTest {
    @Autowired
    RandomBoolean randomBoolean;

    @Test
    void getNextBoolean() {
        assertThat(randomBoolean.getNextBoolean(), anyOf(is(true),is(false)));
    }
}