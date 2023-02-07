package org.melody.singleInstance;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

/**
 * @author lizhaohui
 * @since 2023/2/7
 */
class Singleton1Test {

    @Test
    void getInstance() {

        Singleton1 instance = Singleton1.getInstance();

    }
}