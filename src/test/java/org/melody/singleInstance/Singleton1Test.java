package org.melody.singleInstance;

import org.junit.jupiter.api.Test;

import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;

/**
 * @author lizhaohui
 * @since 2023/2/7
 */
class Singleton1Test {

    @Test
    void getInstance1() {

//        Singleton1 instance = Singleton1.getInstance();
//        System.out.println(instance);
        try {

            Class<Singleton1> clazz = Singleton1.class;
            Constructor<Singleton1> constructor = clazz.getDeclaredConstructor();
            constructor.setAccessible(true);
            Singleton1 instance1 = constructor.newInstance();
            Singleton1 instance2 = constructor.newInstance();
            System.out.println(instance1 == instance2);
//            System.out.println(instance == instance2);
        } catch (NoSuchMethodException | InvocationTargetException | InstantiationException | IllegalAccessException e) {
            throw new RuntimeException(e);
        }
    }

}