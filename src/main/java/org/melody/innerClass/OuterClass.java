package org.melody.innerClass;

/**
 * 外部类和内部类
 * @author lizhaohui
 * @since 2023/2/20
 */
public class OuterClass {

    private String outerClassName = "outerClassName";

    public void speak() {
        System.out.println("this is a outer class...");
    }

    /**
     * non-static inner class
     */
    class InnerClass {

        private String innerClassName = "innerClassName";

        public void innerSpeak() {
            System.out.println("this is a inner class...");
            System.out.println("this is a outer class value: " + outerClassName);
            outerClassName = "changeValue";
            System.out.println("change outer class param value: " + outerClassName);
        }
    }

    /**
     * static inner class
     */
    static class NestedClass {

        public void nestedClassSpeak() {
            System.out.println("this is a nested class...");
        }
    }

    class Dog {}

    public void invoke() {

        // 局部内部类
        class Cat {
            private String name = "kite";
        }
        Dog dog = new Dog() {
            private String name;
        };

        OuterClass outerClass = new OuterClass();
        OuterClass.InnerClass innerClass = outerClass.new InnerClass();
        innerClass.innerSpeak();
        String className = innerClass.innerClassName;
        System.out.println(className);
        System.out.println(new Cat().name);
//        System.out.println(dog.name); // 匿名内部类不可访问属性
    }

    public static void main(String[] args) {
        new OuterClass().invoke();
    }
}
