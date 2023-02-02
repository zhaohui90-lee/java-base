package org.melody.singleInstance;

/**
 * 单例模式
 *  双重校验锁 线程安全
 * @author lizhaohui
 * @since 2023/2/2
 */
public class Singleton1 {

    // volatile 关键字
    // 保证了变量的可见性（visibility）。被volatile关键字修饰的变量，如果值发生了变更，其他线程立马可见，避免出现脏读的现象
    private static volatile Singleton1 singleton;

    private Singleton1() {
    }

    public static Singleton1 getInstance() {
        if (singleton == null) {
            synchronized (Singleton1.class) {
                if (singleton == null) {
                    singleton = new Singleton1();
                }
            }
        }
        return singleton;
    }
}
