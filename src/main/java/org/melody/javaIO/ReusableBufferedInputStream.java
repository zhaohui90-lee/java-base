package org.melody.javaIO;

import java.io.IOException;
import java.io.InputStream;

/**
 * 为了解决<code>BufferedInputStream</code>只能使用一次的弱点
 * 在业务需要大量的<code>BufferedInputStream</code>的情况，减少java
 * 垃圾回收的压力
 * code by Jakob Jenkov
 * @author lizhaohui
 * @since 2023/1/9
 */
public class ReusableBufferedInputStream extends InputStream {

    private final byte[] buffer;
    private int writeIndex;
    private int readIndex;
    private InputStream source;

    public ReusableBufferedInputStream(byte[] buffer) {
        this.buffer = buffer;
    }

    public ReusableBufferedInputStream setSource(InputStream source) {
        this.source = source;
        this.writeIndex = 0;
        this.readIndex = 0;
        return this;
    }

    @Override
    public int read() throws IOException {

        if (writeIndex == readIndex) {
            if (writeIndex == buffer.length) {
                // 写入结束
                writeIndex = 0;
                readIndex = 0;
            }
            // data should be read into buffer.
            int bytesRead = readBytesIntoBuffer();
            while (bytesRead == 0) {
                // continue until you actually get some bytes !
                bytesRead = readBytesIntoBuffer();
            }
            // if no more data could be read in, return -1;
            if (bytesRead == -1) {
                return -1;
            }
        }

        return 0xff & this.buffer[readIndex++];
    }

    private int readBytesIntoBuffer() throws IOException {
        int bytesRead = this.source.read(this.buffer, this.writeIndex, this.buffer.length - this.writeIndex);
        writeIndex += bytesRead;
        return bytesRead;
    }

    @Override
    public void close() throws IOException {
        this.source.close();
    }
}
