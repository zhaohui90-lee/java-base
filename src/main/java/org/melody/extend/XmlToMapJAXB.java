package org.melody.extend;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Unmarshaller;
import javax.xml.bind.annotation.XmlRootElement;
import java.io.File;
import java.util.HashMap;

/**
 * @author lizhaohui
 * @since 2023/2/8
 */
public class XmlToMapJAXB {

    @XmlRootElement(name = "root")
    static class Customer {
        private String name;
        private int age;

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


    public static void main(String[] args) throws JAXBException {
        JAXBContext jaxbContext = JAXBContext.newInstance(Customer.class);
        Unmarshaller jaxbUnmarshaller = jaxbContext.createUnmarshaller();
        Customer customer = (Customer) jaxbUnmarshaller.unmarshal(new File("customer.xml"));
        HashMap<String, Object> map = new HashMap<>();
        map.put("name", customer.getName());
        map.put("age", customer.getAge());
        System.out.println(map);
    }
}
