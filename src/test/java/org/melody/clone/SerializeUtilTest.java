package org.melody.clone;

import org.junit.jupiter.api.Test;
import org.melody.pojo.Person;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

/**
 * 浅拷贝只复制对象中的原始字段，而不复制任何引用类型字段。这意味着，
 * 如果原始对象中的引用类型字段指向的是相同的对象，则克隆对象中的引用类型字段也会指向相同的对象。<br>
 *
 * 深拷贝会复制整个对象，包括所有引用类型字段中的对象，这样每个克隆对象都有自己的对象实例。<br>
 *
 * @author lizhaohui
 * @since 2023/3/9
 */
class SerializeUtilTest {

    @Test
    void testClone() {

        Person p = new Person();
        p.setName("张三");
        p.setAge(20);
        p.setAddress("京海市奈何路强盛集团");
        List<String> houseProperties = new ArrayList<>(10);
        houseProperties.add("房产1");
        houseProperties.add("房产2");
        houseProperties.add("房产3");
        houseProperties.add("房产4");
        houseProperties.add("房产5");
        p.setHouseProperties(houseProperties);
        System.out.println(p);

        // 浅拷贝
        Person shallowClone = p.clone();
        System.out.println(shallowClone.getAge());
        System.out.println(shallowClone.getAddress());
        System.out.println(shallowClone.getName());
        System.out.println(p.getHouseProperties() == shallowClone.getHouseProperties()); // true



        // 深拷贝
        Person deepClone = SerializeUtil.clone(p);
        System.out.println(deepClone.getAge());
        System.out.println(deepClone.getAddress());
        System.out.println(deepClone.getName());

        System.out.println(p.getHouseProperties() == deepClone.getHouseProperties()); // false
    }
}