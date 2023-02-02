package org.melody.Multithreading.threadNotSafe;

/**
 * 对象成员变量(字段)与对象一起存储在堆中。因此，如果两个线程在同一个对象实例上调用一个方法，
 * 而这个方法更新了对象成员变量，那么这个方法就不是线程安全的。
 * @author lizhaohui
 * @since 2023/2/2
 */
public class Example1 {

    StringBuilder stringBuilder = new StringBuilder();

    public void add(String str) {
        this.stringBuilder.append(str);
    }
}
