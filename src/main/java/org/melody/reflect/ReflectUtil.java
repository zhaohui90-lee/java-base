package org.melody.reflect;


import java.lang.reflect.*;
import java.util.Arrays;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/**
 * 反射工具类
 *
 * @author lizhaohui
 * @since 2023/2/9
 */
public class ReflectUtil {


    private static final Map<Class<?>, Field[]> declaredFieldCache = new ConcurrentHashMap<>(256);

    /**
     * 通过反射获取类中的方法
     *
     * @param clazz      检查的目标类
     * @param methodName 方法名
     * @param paramTypes 方法所需要的参数
     * @return 返回类对象或者null
     */
    public static Method findMethods(Class<?> clazz, String methodName, Class<?>... paramTypes) {
        try {
            return clazz.getMethod(methodName, paramTypes);
        } catch (NoSuchMethodException e) {
            return findDeclaredMethod(clazz, methodName, paramTypes);
        }
    }

    /**
     * 使用递归找寻改类及其超类中的任意指定的方法
     * 在<code>paramTypes</code>,<code>methodName</code>设置容易不正确的时候容易内存溢出
     *
     * @param clazz      检查的目标类
     * @param methodName 方法名
     * @param paramTypes 方法所需要的参数
     * @return 返回类对象或者null
     */
    private static Method findDeclaredMethod(Class<?> clazz, String methodName, Class<?>[] paramTypes) {
        try {
            return clazz.getDeclaredMethod(methodName, paramTypes);
        } catch (NoSuchMethodException e) {
            // 目标类的超类里寻找
            if (clazz.getSuperclass() != null) {
                return findDeclaredMethod(clazz, methodName, paramTypes);
            }
            return null;
        }
    }

    /**
     * @param clazz 检查的类
     * @param name  类的成员变量名
     * @return 对应的字段对象，如果没有找到，则为null
     */
    public static Field findField(Class<?> clazz, String name) {
        return findField(clazz, name, null);
    }


    public static Field findField(Class<?> clazz, String name, Type type) {
//        Assert.checkNonNull(clazz, "Class不能为空");
//        Assert.check(name != null || type != null, "name或者type参数不能同时为空");
        Class<?> searchType = clazz;
        // 查询到Object说明已经查询完毕 跳出循环
        while (Object.class != clazz && searchType != null) {
            Field[] fields = getDeclaredFields(searchType);
            for (Field field : fields) {
                if ((name == null || name.equals(field.getName())) &&
                        (type == null || type.equals(field.getType()))) {
                    return field;
                }
            }
            // 继续向超类搜索
            searchType = searchType.getSuperclass();
        }
        return null;
    }

    private static Field[] getDeclaredFields(Class<?> clazz) {
//        Assert.checkNonNull(clazz, "Class不能为空");
        Field[] result = declaredFieldCache.get(clazz);
        if (result == null) {
            try {
                result = clazz.getDeclaredFields();
                declaredFieldCache.put(clazz, (result.length == 0) ? new Field[0] : result);
            } catch (Throwable e) {
                throw new IllegalStateException("Failed to introspect Class [" + clazz.getName() +
                        "] from ClassLoader [" + clazz.getClassLoader() + "]", e);
            }
        }
        return result;
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
