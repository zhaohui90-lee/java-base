package org.melody.pojo;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

/**
 * @author lizhaohui
 * @since 2023/2/6
 */
public class Person implements Serializable, Cloneable {

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

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Person person = (Person) o;

        if (age != person.age) return false;
        if (!Objects.equals(name, person.name)) return false;
        return Objects.equals(address, person.address);
    }

    @Override
    public int hashCode() {
        int result = name != null ? name.hashCode() : 0;
        result = 31 * result + age;
        result = 31 * result + (address != null ? address.hashCode() : 0);
        return result;
    }

    @Override
    public Person clone() {
        try {
            return (Person) super.clone();
        } catch (CloneNotSupportedException e) {
            throw new AssertionError();
        }
    }
}
