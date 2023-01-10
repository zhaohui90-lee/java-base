package org.melody.Serializable;

import java.io.Serializable;

/**
 * @author lizhaohui
 * @since 2023/1/9
 */
public class Person implements Serializable{

    private static final long serialVersionUID = -6850977154469998837L;

    private transient String idCard;

    private String name;
    private int age;

    public String getIdCard() {
        return idCard;
    }

    public void setIdCard(String idCard) {
        this.idCard = idCard;
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
}
