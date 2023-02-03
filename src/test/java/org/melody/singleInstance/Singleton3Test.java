package org.melody.singleInstance;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

/**
 * @author lizhaohui
 * @since 2023/2/3
 */
class Singleton3Test {

    @Test
    void doSomething() {

        Singleton3 instance = Singleton3.INSTANCE;
        new Thread(new MyRunnable(instance)).start();
        new Thread(new MyRunnable(instance)).start();
        new Thread(new MyRunnable(instance)).start();
    }
}