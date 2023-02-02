package org.melody.Multithreading.threadSafe;

/**
 * 线程安全的一些例子
 * @author lizhaohui
 * @since 2023/2/2
 */
public class ThreadSafeExample {


    /**
     * 局部变量是线程安全的
     */
    public void someMethod() {

        long threadSafeInt = 0;

        threadSafeInt++;
    }

    /**
     * 执行someMethod1这个方法时都会创建一个自己的<code>Calculator</code>实例，
     * 因此也是线程安全的。
     * 将<code>cal</code>作为参数传递给同一个类或其他类中的其他方法，使用它也是线程安全的。
     */
    public void someMethod1() {
        Calculator cal = new Calculator();
        cal.add(10);
        method2(cal);
    }

    private void method2(Calculator cal) {
        ImmutableValue value = cal.getValue();
        System.out.println(value);
    }
}
