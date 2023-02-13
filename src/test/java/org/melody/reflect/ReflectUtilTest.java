package org.melody.reflect;

import org.junit.jupiter.api.Test;

import java.lang.reflect.*;
import java.util.Arrays;

import static org.junit.jupiter.api.Assertions.*;

/**
 * @author lizhaohui
 * @since 2023/2/9
 */
class ReflectUtilTest {

    @Test
    void getMethods() throws NoSuchMethodException {

        Method[] methods = TargetBean.class.getMethods();

        Method method1 = TargetBean.class.getMethod("setVersion", int.class);
        System.out.println(method1);

        for (Method method : methods) {
            System.out.println("method: " + method.getName());
        }
    }

    @Test
    void getFields() throws NoSuchFieldException, IllegalAccessException {
        Class<TargetBean> targetBeanClass = TargetBean.class;
        // class name
        String className = targetBeanClass.getName();
        System.out.println(className);
        String classSimpleName = targetBeanClass.getSimpleName();
        System.out.println(classSimpleName);

        // modifiers
        int modifiers = targetBeanClass.getModifiers();
        System.out.println(modifiers);
        boolean aFinal = Modifier.isFinal(modifiers);
        System.out.println(aFinal);

        // package
        Package classPackage = targetBeanClass.getPackage();
        String packageName = classPackage.getName();
        System.out.println(packageName);

        // superClass
        Class<? super TargetBean> superclass = targetBeanClass.getSuperclass();
        String superclassName = superclass.getName();
        System.out.println(superclassName);

        // Implemented Interfaces
        // 只会返回明确声明的接口类 接口类的超类需要递归去实现返回
        Class<?>[] interfaces = targetBeanClass.getInterfaces();
        System.out.println(Arrays.stream(interfaces).map(item -> {
            System.out.println(item);
            return null;
        }));

        // 返回直接声明的超类
//        Type type = getClass().getGenericSuperclass();
//        ((ParameterizedType) type).getActualTypeArguments();
//        System.out.println("types: " + type);

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


        Field[] fields = targetBeanClass.getFields();

        for (Field field : fields) {
            System.out.println("field: " + field);
        }

    }
}