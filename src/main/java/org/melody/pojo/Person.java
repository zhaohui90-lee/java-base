package org.melody.pojo;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

/**
 * @author lizhaohui
 * @since 2023/2/6
 */
public class Person implements Serializable {

    private static final long serialVersionUID = 7189211921572930511L;

    private String name;

    private int age;

    private String address;

    private List<String> properties = new ArrayList<>();

    public List<String> getHouseProperties() {
        return properties;
    }

    public void setHouseProperties(List<String> houseProperties) {
        this.properties = houseProperties;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public Person() {
    }

    // 复制构造函数
    public Person(Person original) {
        this.name = original.name;
        this.age = original.age;
        this.address = original.address;
        this.properties = original.properties;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Person person = (Person) o;

        return age == person.age &&
                Objects.equals(name, person.name) &&
                Objects.equals(address, person.address);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, age, address);
    }
}
