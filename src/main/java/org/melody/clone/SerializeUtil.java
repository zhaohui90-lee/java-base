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

    /**
     * 通过序列化实现深拷贝
     * @param obj 需要拷贝的对象
     * @param <T> 对象类型
     * @return 拷贝后的对象
     */
    public static <T> T clone(T obj) {
        // 判断对象是否实现了序列化接口
        if (!(obj instanceof Serializable)) {
            return null;
        }
        return deserialize(serialize(obj));
    }

    /**
     * 序列化
     * @param obj 需要序列化的对象
     * @param <T> 对象类型
     * @return 序列化后的字节数组
     */
    public static <T> byte[] serialize(T obj) {
        if (!(obj instanceof Serializable)) {
            return null;
        }
        final FastByteArrayOutputStream byteOut = new FastByteArrayOutputStream();
        IoUtil.writeObjects(byteOut, false, (Serializable) obj);
        return byteOut.toByteArray();
    }

    /**
     * 反序列化
     * @param bytes 需要反序列化的字节数组
     * @param <T> 对象类型
     * @return 反序列化后的对象
     */
    public static <T> T deserialize(byte[] bytes) {
        return IoUtil.readObj(new ByteArrayInputStream(bytes));
    }
}
