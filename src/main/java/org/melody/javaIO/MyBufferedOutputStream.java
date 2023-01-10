package org.melody.javaIO;

import java.io.BufferedOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;

/**
 * @author lizhaohui
 * @since 2023/1/9
 */
public class MyBufferedOutputStream {

    public static void main(String[] args) throws IOException {

        String path = System.getProperty("user.dir") + "/src/main/resources/static/novel.txt";

        int bufferSize = 8192;

        OutputStream outputStream = new BufferedOutputStream(Files.newOutputStream(Paths.get(path), StandardOpenOption.APPEND), bufferSize);

        outputStream.write("这里是添加的内容...".getBytes());

        outputStream.close();

        outputStream.flush();
    }
}
