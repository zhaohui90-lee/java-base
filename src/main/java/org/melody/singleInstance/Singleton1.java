package org.melody.singleInstance;

import java.io.Serializable;

/**
 * 单例模式(不推荐)
 *  双重校验锁 线程安全
 *  <b>使用了 volatile 关键字来保证变量的可见性，但是在 Java 5 之后，由于 JMM（Java 内存模型）的改进，double-checked locking 技巧不再需要使用 volatile 关键字。</b>
 *  <b>单例模式的初始化可能受到反射和序列化等技术的干扰，需要添加更多的保护机制来保护单例。</b>
 * @author lizhaohui
 * @since 2023/2/2
 */
public class Singleton1 implements Serializable {

    private static final long serialVersionUID = 6942033719614028677L;
    // volatile 关键字
    // 保证了变量的可见性（visibility）。被volatile关键字修饰的变量，如果值发生了变更，其他线程立马可见，避免出现脏读的现象
    private static volatile Singleton1 singleton;

    private Singleton1() {
        // 私有化构造函数并使用 throw new IllegalStateException() 防止通过反射创建实例。
        if (singleton != null) {
            throw new IllegalStateException("Already created.");
        }
    }

    /**
     * 实现 Serializable 接口并重写 readResolve 方法，以防止通过序列化创建多个实例。
     * @return singleton
     */
    private Object readResolve() {
        return singleton;
    }

    /**
     * 暴露在外部的静态方法
     * @return singleton
     */
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
