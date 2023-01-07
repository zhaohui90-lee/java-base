package org.melody.javaIO;

import java.io.*;
import java.nio.file.Files;
import java.nio.file.Paths;

/**
 * @author lizhaohui
 * @since 2023/1/6
 */
public class MyFileInputStream {

    /**
     * The Java FileInputStream class, java.io.FileInputStream, makes it possible to read the contents of a file as a stream of bytes.
     * The Java FileInputStream class is a subclass of Java InputStream. This means that you use the Java FileInputStream
     * as an InputStream (FileInputStream behaves like an InputStream).
     */
    public static void main(String[] args) {
        String path = System.getProperty("user.dir") + "/src/main/resources/static/test.txt";
        try (FileInputStream inputStream = new FileInputStream(path)){
            while (inputStream.read() != -1) {
                System.out.println(inputStream.read());
            }
            System.out.println("-----------");
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

        // 两种构造方式
        // FileInputStream stream = new FileInputStream(path);
        // FileInputStream stream = new FileInputStream(new File(path));


        // read
        try (FileInputStream inputStream = new FileInputStream(path)){
            byte[] bytes = new byte[1024];
            int read = inputStream.read(bytes, 0, bytes.length);
            while (read != -1) {
                System.out.println(read);
                read = inputStream.read(bytes, 0, bytes.length);
            }
            System.out.println("-------");
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

        // 通过BufferedInputStream实现透明缓冲
        try (InputStream input = new BufferedInputStream(new FileInputStream(path))){
            // buffered size is 1024 * 1024
            System.out.println(input);
            while (input.read() != -1) {
                System.out.println(input.read());
            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

        // Convert FileInputStream to Reader
        try {
            FileInputStream input = new FileInputStream(path);
            InputStreamReader reader = new InputStreamReader(input);

        } catch (IOException e) {
            throw new RuntimeException(e);
        }

    }
}
