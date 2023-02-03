package org.melody.singleInstance;

/**
 * @author lizhaohui
 * @since 2023/2/3
 */
public class MyRunnable implements Runnable {

    private final Singleton3 singleton3;


    public MyRunnable(Singleton3 singleton3) {
        this.singleton3 = singleton3;
    }

    @Override
    public void run() {
        this.singleton3.doSomething();
    }
}
