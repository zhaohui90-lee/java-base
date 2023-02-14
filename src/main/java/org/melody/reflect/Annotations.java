package org.melody.reflect;

import java.lang.annotation.Annotation;
import java.lang.reflect.Method;

/**
 * @author lizhaohui
 * @since 2023/2/13
 */
public class Annotations {

    public void getClassAnnotations() {
        Class<?> beanClass = AnnotationTargetBeanImpl.class;
        Annotation[] annotations = beanClass.getAnnotations();

        for (Annotation annotation : annotations) {
            if (annotation instanceof AnnotationTargetBean) {
                AnnotationTargetBean myAnnotation = (AnnotationTargetBean) annotation;
                System.out.println("name: " + myAnnotation.name());
                System.out.println("value: " + myAnnotation.value());
            }
        }
    }

    public void getMethodAnnotations() throws NoSuchMethodException {
        Method method = AnnotationTargetBeanImpl.class.getDeclaredMethod("doSomething");
        Annotation[] annotations = method.getAnnotations();

        for (Annotation annotation : annotations) {
            if (annotation instanceof AnnotationTargetBean) {
                AnnotationTargetBean myAnnotation = (AnnotationTargetBean) annotation;
                System.out.println("name: " + myAnnotation.name());
                System.out.println("value: " + myAnnotation.value());
            }
        }
    }
}
