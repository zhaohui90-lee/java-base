package org.melody.Multithreading.raceCondition;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

/**
 * @author lizhaohui
 * @since 2023/2/1
 */
class CounterTest {

    @Test
    void run() {
        Count count = new Count();

        Counter counter1 = new Counter(count, 2);
        new Thread(counter1).start();

        Counter counter2 = new Counter(count, 3);
        new Thread(counter2).start();
    }
}