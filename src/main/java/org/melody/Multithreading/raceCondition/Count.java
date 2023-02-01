package org.melody.Multithreading.raceCondition;

/**
 * @author lizhaohui
 * @since 2023/2/1
 */
public class Count {

    protected int count = 0;

    public void add(int addVal) {
        this.count += addVal;
    }
}
