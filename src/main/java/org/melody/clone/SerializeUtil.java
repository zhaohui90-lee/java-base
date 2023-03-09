package org.melody.clone;

import org.melody.javaIO.FastByteArrayOutputStream;
import org.melody.util.IoUtil;

import java.io.ByteArrayInputStream;
import java.io.Serializable;

/**
 * 序列化工具类
 * @author lizhaohui
 * @since 2023/3/3
 */
public class SerializeUtil {

    public static <T> T clone(T obj) {
        if (!(obj instanceof Serializable)) {
            return null;
        }
        return deserialize(serialize(obj));
    }

    public static <T> byte[] serialize(T obj) {
        if (!(obj instanceof Serializable)) {
            return null;
        }
        final FastByteArrayOutputStream byteOut = new FastByteArrayOutputStream();
        IoUtil.writeObjects(byteOut, false, (Serializable) obj);
        return byteOut.toByteArray();
    }

    public static <T> T deserialize(byte[] bytes) {
        return IoUtil.readObj(new ByteArrayInputStream(bytes));
    }
}
