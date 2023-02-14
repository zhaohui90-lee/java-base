package org.melody.reflect;

import java.lang.reflect.Array;

/**
 * @author lizhaohui
 * @since 2023/2/13
 */
public class ArraysRe {

    public static void main(String[] args) throws ClassNotFoundException {
        int[] intArray = (int[]) Array.newInstance(int.class, 4);

        Array.set(intArray, 0, 123);
        Array.set(intArray, 2, 456);
        Array.set(intArray, 3, 789);


        Class<?> type = intArray.getClass().getComponentType();
        System.out.println(type); // int

//        System.out.println("intArray[0] = " + Array.get(intArray, 0));
//        System.out.println("intArray[1] = " + Array.get(intArray, 1));
//        System.out.println("intArray[2] = " + Array.get(intArray, 2));
//        System.out.println("intArray[3] = " + Array.get(intArray, 3));

        Class<?> aClass = getClass("org.melody.reflect.TargetBean");
        System.out.println(aClass); // class org.melody.reflect.TargetBean
        Class<?> stringArrayClass = Array.newInstance(aClass, 0).getClass();
        System.out.println("is array: " + stringArrayClass.isArray());
    }

    /**
     * @param className 类名包括具体的路径
     * @return 获取类
     */
    public static Class<?> getClass(String className) throws ClassNotFoundException {
        if("int" .equals(className)) return int.class;
        if("long".equals(className)) return long.class;

        return Class.forName(className);
    }
}
