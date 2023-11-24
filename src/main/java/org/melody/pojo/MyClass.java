package org.melody.pojo;

/**
 * @author lizhaohui
 * @since 2023/11/24
 */
public class MyClass {

    private int value;

    // 私有构造函数，防止直接实例化
    private MyClass(int value) {
        this.value = value;
    }

    // 静态构造方法，创建对象
    public static MyClass createInstance(int value) {
        return new MyClass(value);
    }

    public int getValue() {
        return value;
    }

    public void setValue(int value) {
        this.value = value;
    }
}
