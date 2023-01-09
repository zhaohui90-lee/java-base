package org.melody.javaIO;

import java.io.BufferedInputStream;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;

/**
 * The Java BufferedInputStream class, java.io.BufferedInputStream,
 * provides transparent reading of chunks of bytes and buffering for
 * a Java InputStream, including any subclasses of InputStream.
 * Reading larger chunks of bytes and buffering them can speed up IO quite a bit.
 * Rather than read one byte at a time from the network or disk,
 * the BufferedInputStream reads a larger block at a time into an internal buffer.
 * When you read a byte from the Java BufferedInputStream you are
 * therefore reading it from its internal buffer. When the buffer is fully read,
 * the BufferedInputStream reads another larger block of data into the buffer.
 * This is typically much faster than reading a single byte at a time from an InputStream,
 * especially for disk access and larger data amounts.
 *
 * @author lizhaohui
 * @since 2023/1/9
 */
public class MyBufferedInputStream {

    public static void main(String[] args) throws IOException {
        String path = System.getProperty("user.dir") + "/src/main/resources/static/test.txt";

        // 默认的buffer size是 8 * 1024
        // 如何选取最佳的缓冲区：一般是根据实际使用的硬盘特性，需要找到硬盘读取的块大小，还有它的缓存大小，将
        // 缓冲取设置为它的整数倍
        int bufferSize = 2 << 12;
        BufferedInputStream bufferedInputStream = new BufferedInputStream(Files.newInputStream(Paths.get(path)), bufferSize);

        while (bufferedInputStream.read() != -1) {
            System.out.println(bufferedInputStream.read());
        }

        bufferedInputStream.close();


    }
}
