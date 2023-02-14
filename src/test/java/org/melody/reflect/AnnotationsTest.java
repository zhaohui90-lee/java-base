package org.melody.reflect;

import org.junit.jupiter.api.Test;

import java.lang.annotation.Annotation;
import java.lang.reflect.Method;

import static org.junit.jupiter.api.Assertions.*;

/**
 * @author lizhaohui
 * @since 2023/2/13
 */
class AnnotationsTest {

    @Test
    void getClassAnnotations() {

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

    @Test
    void getMethodAnnotations() throws NoSuchMethodException {

        Method method = AnnotationTargetBeanImpl.class.getDeclaredMethod("doSomething");
        Annotation annotation = method.getAnnotation(AnnotationTargetBean.class);

        if (annotation instanceof AnnotationTargetBean) {
            AnnotationTargetBean myAnnotation = (AnnotationTargetBean) annotation;
            System.out.println("name: " + myAnnotation.name());
            System.out.println("value: " + myAnnotation.value());
        }
    }
}