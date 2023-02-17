package org.melody.clone;

/**
 * @author lizhaohui
 * @since 2023/2/17
 */
public class ValueAndReference {

    public static void main(String[] args) {
        Dog dog = new Dog("MAX");
        System.out.println(dog);
        foo(dog);
        System.out.println(dog.getName().equals("Bard"));
    }

    public static void foo(Dog d) {
        System.out.println(d);
        d = new Dog("Bard"); // 指向了新的对象
        System.out.println(d);
    }

    static class Dog {
        private String name;

        public Dog(String name) {
            this.name = name;
        }

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }
    }
}
