package org.melody.javaIO;

import org.junit.jupiter.api.Test;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;

import static org.junit.jupiter.api.Assertions.*;

/**
 * @author lizhaohui
 * @since 2023/1/9
 */
class ReusableBufferedInputStreamTest {

    @Test
    void read() throws IOException {
        String path = System.getProperty("user.dir") + "/src/main/resources/static/test.txt";

        ReusableBufferedInputStream reusableBufferedInputStream =
                new ReusableBufferedInputStream(new byte[1024 * 1024]).setSource(Files.newInputStream(Paths.get(path)));
        int read = reusableBufferedInputStream.read();

        while (read != -1) {
            System.out.println(read);

            read = reusableBufferedInputStream.read();
        }

        reusableBufferedInputStream.close();

        System.out.println("---------");

        String path1 = System.getProperty("user.dir") + "/src/main/resources/static/novel.txt";

        reusableBufferedInputStream.setSource(Files.newInputStream(Paths.get(path1)));

        read = reusableBufferedInputStream.read();

        while (read != -1) {
            System.out.println(read);

            read = reusableBufferedInputStream.read();
        }

        reusableBufferedInputStream.close();
    }
}