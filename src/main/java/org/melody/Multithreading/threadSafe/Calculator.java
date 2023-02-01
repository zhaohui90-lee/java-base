package org.melody.Multithreading.threadSafe;

/**
 * 虽然在内部使用了不可变对象 但是此对象本身并不是不可变的，因此不是线程安全的
 * @author lizhaohui
 * @since 2023/2/1
 */
public class Calculator {

    private ImmutableValue currentValue = null;

    public ImmutableValue getValue() {
        return this.currentValue;
    }

    public void setValue(ImmutableValue newValue) {
        this.currentValue = newValue;
    }

    public void add(int addValue) {
        this.currentValue = currentValue.add(addValue);
    }
}
