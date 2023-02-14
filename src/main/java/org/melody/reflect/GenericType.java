package org.melody.reflect;

import java.lang.reflect.Method;
import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;
import java.util.List;

/**
 * @author lizhaohui
 * @since 2023/2/13
 */
public class GenericType {

    static class MyClass {
        protected List<String> stringList;

        public void setStringList(List<String> list) {
            this.stringList = list;
        }
    }

    /**
     * 在java运行期间确定泛型的类型
     */
    public void accessGenericType() throws NoSuchMethodException {
        Method method = MyClass.class.getMethod("setStringList", List.class);

        Type[] genericParameterTypes = method.getGenericParameterTypes();
        for (Type genericParameterType : genericParameterTypes) {
            if (genericParameterType instanceof ParameterizedType) {
                ParameterizedType parameterizedType = (ParameterizedType) genericParameterType;
                Type[] actualTypeArguments = parameterizedType.getActualTypeArguments();
                for (Type actualTypeArgument : actualTypeArguments) {
                    Class<?> clazz = (Class<?>) actualTypeArgument;
                    System.out.println("actualTypeArgument: " + clazz);
                }
            }
        }
    }
}
