package org.melody.javaIO;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.util.Arrays;

/**
 * @author lizhaohui
 * @since 2023/1/8
 */
public class MyByteArrayOutputStream {

    public static void main(String[] args) throws IOException {
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();

        // write data
        // todo write data to byteArrayOutputStream
        byteArrayOutputStream.write("asdfghjk".getBytes());

        byte[] bytes = byteArrayOutputStream.toByteArray();

        System.out.println(Arrays.toString(bytes));

        byteArrayOutputStream.close();
    }
}
