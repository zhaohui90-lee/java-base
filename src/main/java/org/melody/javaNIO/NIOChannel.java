package org.melody.javaNIO;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.RandomAccessFile;
import java.nio.ByteBuffer;
import java.nio.channels.FileChannel;

/**
 * Java NIO Channels are similar to streams with a few differences:
 *  You can both read and write to a Channels. Streams are typically one-way (read or write).<br>
 *  Channels can be read and written asynchronously.<br>
 *  Channels always read to, or write from, a Buffer.<br>
 *  <b>Java NIO: Channels read data into Buffers, and Buffers write data into Channels</b>
 * @author lizhaohui
 * @since 2023/1/8
 */
public class NIOChannel {

    public void fileChannel() throws IOException {
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
