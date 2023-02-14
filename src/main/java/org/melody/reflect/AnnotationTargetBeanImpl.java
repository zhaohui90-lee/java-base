package org.melody.reflect;

/**
 * @author lizhaohui
 * @since 2023/2/13
 */
@AnnotationTargetBean(name = "bean", value = "myBean")
public class AnnotationTargetBeanImpl {

    @AnnotationTargetBean(name = "action", value = "helloWorld")
    public void doSomething() {

    }
}
