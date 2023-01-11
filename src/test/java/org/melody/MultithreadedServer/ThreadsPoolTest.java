package org.melody.MultithreadedServer;

import org.junit.jupiter.api.Test;

/**
 * @author lizhaohui
 * @since 2023/1/11
 */
class ThreadsPoolTest {

    @Test
    void run() {

        ThreadsPool threadsPool = new ThreadsPool(9000);
        new Thread(threadsPool).start();

        try {
            Thread.sleep(20 * 1000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        System.out.println("stopping server");
        threadsPool.stop();
    }
}