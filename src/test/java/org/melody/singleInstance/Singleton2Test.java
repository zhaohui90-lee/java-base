package org.melody.singleInstance;

import org.junit.jupiter.api.Test;

import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;

import static org.junit.jupiter.api.Assertions.*;

/**
 * @author lizhaohui
 * @since 2023/2/7
 */
class Singleton2Test {

    @Test
    void getInstance() {

        Singleton2 instance = Singleton2.getInstance();

        System.out.println(instance);
//        try {
//
//            Class<Singleton2> clazz = Singleton2.class;
//            Constructor<Singleton2> constructor = clazz.getDeclaredConstructor();
//            constructor.setAccessible(true);
//            Singleton2 instance1 = constructor.newInstance();
//            Singleton2 instance2 = constructor.newInstance();
//            System.out.println(instance1 == instance2);
//        } catch (NoSuchMethodException | InvocationTargetException | InstantiationException | IllegalAccessException e) {
//            throw new RuntimeException(e);
//        }
    }
}