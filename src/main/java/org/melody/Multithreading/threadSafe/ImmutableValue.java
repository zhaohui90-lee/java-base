package org.melody.Multithreading.threadSafe;

/**
 * ImmutableValue本身是线程安全的 但是对它的引用却不一定是线程安全的
 * @author lizhaohui
 * @since 2023/2/1
 */
public class ImmutableValue {

    private int value = 0;

    public ImmutableValue(int value) {
        this.value = value;
    }

    public int getValue() {
        return this.value;
    }

    public ImmutableValue add(int addValue) {
        return new ImmutableValue(this.value + addValue);
    }
}
