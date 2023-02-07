package org.melody.singleInstance;

import org.junit.jupiter.api.Test;

import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;

import static org.junit.jupiter.api.Assertions.*;

/**
 * @author lizhaohui
 * @since 2023/2/3
 */
class Singleton3Test {

    @Test
    void doSomething() {

        Singleton3 instance = Singleton3.INSTANCE;
        new Thread(new MyRunnable(instance)).start();
        new Thread(new MyRunnable(instance)).start();
        new Thread(new MyRunnable(instance)).start();
    }

    @Test
    void testDoSomething() {

        Class<Singleton3> clazz = Singleton3.class;
        try {
            Constructor<Singleton3> constructor = clazz.getDeclaredConstructor();
            constructor.setAccessible(true);
            Singleton3 instance1 = constructor.newInstance();
            System.out.println(instance1);
//            Singleton3 instance2 = constructor.newInstance();
//            System.out.println(instance1 == instance2);
        } catch (NoSuchMethodException | InvocationTargetException | InstantiationException | IllegalAccessException e) {
            throw new RuntimeException(e);
        }
    }
}