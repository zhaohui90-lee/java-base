package org.melody.singleInstance;

/**
 * 单例模式 静态内部类
 *  静态内部类，线程安全，主动调用时才实例化，延迟加载效率高
 * @author lizhaohui
 * @since 2023/2/2
 */
public class Singleton2 {

    private static class SingletonHolder {
        private static final Singleton2 INSTANCE = new Singleton2();
    }

    private Singleton2() {}

    public static final Singleton2 getInstance() {
        return SingletonHolder.INSTANCE;
    }
}
