package org.melody.javaIO;

import cn.hutool.core.io.IORuntimeException;
import cn.hutool.core.util.CharsetUtil;
import cn.hutool.core.util.ObjectUtil;

import java.io.IOException;
import java.io.OutputStream;
import java.nio.charset.Charset;

/**
 * @author lizhaohui
 * @since 2023/3/8
 */
public class FastByteArrayOutputStream extends OutputStream {

    private final FastByteBuffer buffer;

    public FastByteArrayOutputStream() {
        this(1024);
    }

    public FastByteArrayOutputStream(int size) {
        this.buffer = new FastByteBuffer(size);
    }

    @Override
    public void write(byte[] b, int off, int len) throws IOException {
        buffer.append(b, off, len);
    }

    @Override
    public void write(int b) throws IOException {
        buffer.append((byte) b);
    }

    public int size() {
        return buffer.size();
    }

    @Override
    public void close() throws IOException {
        // nop
    }

    public void reset() {
        buffer.reset();
    }

    /**
     * 写出
     * @param out 输出流
     * @exception IORuntimeException IO异常
     */
    public void writeTo(OutputStream out) {
        final int index = buffer.index();
        if (index < 0) {
            // 无数据写入
            return;
        }
        byte[] buf;
        try {
            for (int i = 0; i < index; i++) {
                buf = buffer.array(i);
                out.write(buf);
            }
            out.write(buffer.array(index), 0, buffer.offset());
        } catch (IOException e) {
            throw new IORuntimeException(e);
        }
    }

    /**
     * 转为byte数组
     * @return Byte数组
     */
    public byte[] toByteArray() {
        return buffer.toArray();
    }

    @Override
    public String toString() {
        return toString(CharsetUtil.defaultCharset());
    }

    /**
     * 转为字符串
     *
     * @param charsetName 编码
     * @return 字符串
     */
    public String toString(String charsetName) {
        return toString(CharsetUtil.charset(charsetName));
    }

    /**
     * 转为字符串
     *
     * @param charset 编码，null表示默认编码
     * @return 字符串
     */
    public String toString(Charset charset) {
        return new String(toByteArray(), ObjectUtil.defaultIfNull(charset, CharsetUtil.defaultCharset()));
    }
}
