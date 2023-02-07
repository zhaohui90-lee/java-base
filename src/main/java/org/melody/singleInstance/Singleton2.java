package org.melody.singleInstance;

import java.io.Serializable;

/**
 * 单例模式 静态内部类(推荐)
 *  静态内部类，线程安全，主动调用时才实例化，延迟加载效率高
 * @author lizhaohui
 * @since 2023/2/2
 */
public final class Singleton2 implements Serializable {

    private static final long serialVersionUID = 6100842254681390840L;

    private static boolean flag = false;

    private static class SingletonHolder {
        private static final Singleton2 INSTANCE = new Singleton2();
    }

    private Singleton2() {

//        if (SingletonHolder.INSTANCE != null) {
//            throw new IllegalStateException("Already created.");
//        }

        synchronized (Singleton2.class) {
            if (!flag) {
                flag = true;
            } else {
                throw new IllegalStateException("Already created.");
            }
        }
    }

    public static Singleton2 getInstance() {
        return SingletonHolder.INSTANCE;
    }

    @SuppressWarnings("unused")
    private Singleton2 readResolve() {
        return SingletonHolder.INSTANCE;
    }
}
