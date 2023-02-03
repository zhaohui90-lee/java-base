package org.melody.singleInstance;

import java.io.Serializable;

/**
 * @author lizhaohui
 * @since 2023/2/3
 */
public enum Singleton3 {

    INSTANCE;

    private int value;

    public int getValue() {
        return value;
    }

    public void setValue(int value) {
        this.value = value;
    }

    public void doSomething() {
        // todo something
        System.out.println("do something...");
    }

}
