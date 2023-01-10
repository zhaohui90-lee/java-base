package org.melody.Multithreaded;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

/**
 * @author lizhaohui
 * @since 2023/1/10
 */
class SingleThreadedServerTest {

    @Test
    void run() {

        SingleThreadedServer server = new SingleThreadedServer(9000);

        new Thread(server).start();

        try {
            Thread.sleep(20 * 1000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        System.out.println("stopping server");
        server.stop();
    }
}