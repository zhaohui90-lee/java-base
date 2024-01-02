package org.melody.stream.pojo;

/**
 * @author lizhaohui
 * @since 2023/12/28
 */
public class Menu {

    private String name;
    private int calories;
    private Type type;

    public Menu(String name, int calories, Type type) {
        this.name = name;
        this.calories = calories;
        this.type = type;
    }

    public String getName() {
        return name;
    }

    public int getCalories() {
        return calories;
    }

    public Type getType() {
        return type;
    }

    public enum Type {
        MEAT, FISH, OTHER
    }

    @Override
    public String toString() {
        return "Menu{" +
                "name='" + name + '\'' +
                ", calories=" + calories +
                ", type=" + type +
                '}';
    }
}
