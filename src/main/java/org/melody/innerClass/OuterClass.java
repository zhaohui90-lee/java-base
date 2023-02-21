package org.melody.innerClass;

/**
 * 外部类和内部类
 * @author lizhaohui
 * @since 2023/2/20
 */
public class OuterClass {

    private String name;

    public void speak() {
        System.out.println("this is a outer class...");
    }

    class InnerClass {

        public void innerSpeak() {
            System.out.println("this is a inner class...");
        }
    }

    static class NestedClass {

        public void nestedClassSpeak() {
            System.out.println("this is a nested class...");
        }
    }

    public static void main(String[] args) {
        OuterClass outerClass = new OuterClass();
        OuterClass.InnerClass innerClass = outerClass.new InnerClass();
        innerClass.innerSpeak();

        NestedClass nestedClass = new NestedClass();
        nestedClass.nestedClassSpeak();
    }
}
