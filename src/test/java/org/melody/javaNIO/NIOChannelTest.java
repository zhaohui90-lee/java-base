package org.melody.javaNIO;

import org.junit.jupiter.api.Test;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.RandomAccessFile;
import java.nio.ByteBuffer;
import java.nio.channels.FileChannel;

import static org.junit.jupiter.api.Assertions.*;

/**
 * @author lizhaohui
 * @since 2023/1/8
 */
class NIOChannelTest {

    @Test
    void fileChannel() throws IOException {
        String p = System.getProperty("user.dir") + "/src/main/resources/static/test.txt";
        RandomAccessFile accessFile = new RandomAccessFile(p, "rw");
        FileChannel channel = accessFile.getChannel();

        ByteBuffer byteBuffer = ByteBuffer.allocate(48);
        int read = channel.read(byteBuffer);
        while (read != -1) {
            System.out.println("read " + read);
            byteBuffer.flip();

            while (byteBuffer.hasRemaining()) {
                System.out.println(byteBuffer.get());
            }
            byteBuffer.clear();
            read = channel.read(byteBuffer);

        }

        accessFile.close();
    }
}