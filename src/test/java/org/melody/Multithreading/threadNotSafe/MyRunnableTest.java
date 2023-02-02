package org.melody.Multithreading.threadNotSafe;

import org.junit.jupiter.api.Test;

/**
 * @author lizhaohui
 * @since 2023/2/2
 */
class MyRunnableTest {

    @Test
    void run() {
        Example1 example1 = new Example1();
        new Thread(new MyRunnable(example1)).start();
        new Thread(new MyRunnable(new Example1())).start();

    }
}