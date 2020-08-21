package com.random.address.util;

import org.springframework.stereotype.Component;

import java.util.concurrent.ThreadLocalRandom;

/**
 * Reusable util class to get random boolean value.
 */
@Component
public class RandomBoolean {

   /**
     * @return boolean value generated from ThreadLocalRandom
     */
    public boolean getNextBoolean() {
        return ThreadLocalRandom.current().nextBoolean();
    }
}
