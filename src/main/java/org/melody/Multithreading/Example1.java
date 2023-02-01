package org.melody.Multithreading;

/**
 * @author lizhaohui
 * @since 2023/1/31
 */
public class Example1 implements Runnable {

    private boolean doStop = false;

    public synchronized void doStop() {
        this.doStop = true;
    }

    private synchronized boolean keepRunning() {
        return !this.doStop;
    }
    @Override
    public void run() {
        while (keepRunning()) {
            System.out.println("running...");

            try {
                Thread.sleep(3L * 1000L);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }
    }
}
