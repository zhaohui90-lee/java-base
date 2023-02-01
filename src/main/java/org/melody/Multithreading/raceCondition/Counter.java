package org.melody.Multithreading.raceCondition;

/**
 * @author lizhaohui
 * @since 2023/2/1
 */
public class Counter implements Runnable {

    protected Count c;

    private int addVal;

    public Counter(Count count, int addVal) {
        this.c = count;
        this.addVal = addVal;
    }

    @Override
    public void run() {
        synchronized (this) {
            for (int i = 0; i < 10; i++) {
                c.add(this.addVal);
                System.out.println("add value " + this.addVal + " to register");
                System.out.println("now count is " + c.count);
            }

        }

    }
}
