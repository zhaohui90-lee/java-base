package org.melody.javaIO;

import java.io.ByteArrayInputStream;

/**
 * @author lizhaohui
 * @since 2023/1/8
 */
public class MyByteArrayInputStream {

    public static void main(String[] args) {
        byte[] bytes = "ckuscbubsdkcbdckuscbubsdkcbdckuscbubsdkcbdckuscbubsdkcbd".getBytes();

        // 偏移量
        int offset = 20;
        int length = 5;

        ByteArrayInputStream input = new ByteArrayInputStream(bytes, offset, length);
        System.out.println(input.read());
        int read = input.read();

        while (read != -1) {
            System.out.println(input.read());
            read = input.read();
        }
    }
}
