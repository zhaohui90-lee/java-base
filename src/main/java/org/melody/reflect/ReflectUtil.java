package org.melody.reflect;

import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.lang.reflect.Modifier;
import java.util.Arrays;

/**
 * 反射工具类
 * @author lizhaohui
 * @since 2023/2/9
 */
public class ReflectUtil {

    /**
     * 通过反射获取javaBean的方法名
     */
    public static void getMethods() throws NoSuchMethodException {
        Method[] methods = TargetBean.class.getMethods();

        Method method1 = TargetBean.class.getMethod("getVersion");
        System.out.println(method1);

        for (Method method : methods) {
            System.out.println("method: " + method.getName());
        }
    }

    /**
     * Field是一个类，位于java.lang.reflect包下。在Java反射中Field类描述的是类的属性信息
     * 参考资料：<a href="https://blog.csdn.net/sinat_34241861/article/details/107822424">资料地址</a>
     */
    public static void getFields() throws NoSuchFieldException, IllegalAccessException {
        Class<?> targetBeanClass = TargetBean.class;
        Field[] fields = targetBeanClass.getFields();

        for (Field field : fields) {
            System.out.println("fields: " + field.getName());
        }

        // constructors
        Constructor<?>[] constructors = targetBeanClass.getConstructors();
        System.out.println(Arrays.stream(constructors).map(Constructor::getName));

        // 获取私有成员变量
        Field privateField = targetBeanClass.getDeclaredField("name");
        privateField.setAccessible(true);

        TargetBean targetBean = new TargetBean();
        targetBean.setName("张三");
        String name = (String) privateField.get(targetBean);

        System.out.println("name = " + name);

        // modifiers
        int modifiers = targetBeanClass.getModifiers();
        System.out.println(modifiers);
        boolean aFinal = Modifier.isFinal(modifiers);
        System.out.println(aFinal);

        // package
        Package classPackage = targetBeanClass.getPackage();
        String packageName = classPackage.getName();
        System.out.println(packageName);
    }


}
