package org.melody.Multithreading.threadNotSafe;

/**
 * @author lizhaohui
 * @since 2023/2/2
 */
public class MyRunnable implements Runnable {

    Example1 example1;

    public MyRunnable(Example1 example1) {
        this.example1 = example1;
    }

    @Override
    public void run() {
        this.example1.add("add text");
        System.out.println(this.example1.toString());
    }
}
