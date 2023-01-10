package org.melody.Serializable;

import org.junit.jupiter.api.Test;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;

/**
 * @author lizhaohui
 * @since 2023/1/10
 */
class PersonTest {

    @Test
    void writePerson() throws IOException {
        String path = System.getProperty("user.dir") + "/src/main/resources/static/person.txt";

        Person person = new Person();
        person.setAge(20);
        person.setName("张三");
        person.setIdCard("330106199002122716");

        ObjectOutputStream outputStream = new ObjectOutputStream(Files.newOutputStream(Paths.get(path), StandardOpenOption.WRITE));
        outputStream.writeObject(person);

        // 这里不会再被写入流
        person.setName("李四");
        outputStream.writeObject(person);
        outputStream.close();
    }

    @Test
    void readPerson() throws IOException, ClassNotFoundException {
        String path = System.getProperty("user.dir") + "/src/main/resources/static/person.txt";

        ObjectInputStream inputStream = new ObjectInputStream(Files.newInputStream(Paths.get(path)));

        Person person = (Person) inputStream.readObject();

        System.out.println("person: " + person.getName() + "," + person.getAge() + "," + person.getIdCard());

        inputStream.close();
    }
}