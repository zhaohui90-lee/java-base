package org.melody.util;

import cn.hutool.core.io.IORuntimeException;

import java.io.*;
import java.util.HashSet;
import java.util.Set;

/**
 * @author lizhaohui
 * @since 2023/3/6
 */
public class IoUtil {

    public static <T> T readObj(InputStream in) {
        return readObj(in, null);
    }

    public static <T> T readObj(InputStream in, Class<T> clazz) {
        try {
            return readObj((in instanceof ValidateObjectInputStream) ?
                    (ValidateObjectInputStream) in : new ValidateObjectInputStream(in), clazz);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    /**
     * 从流中读取对象，即对象的反序列化，读取后不关闭流
     *
     * @param in 输入流，使用{@link cn.hutool.core.io.ValidateObjectInputStream}中的黑白名单方式过滤类，用于避免反序列化漏洞
     * @param clazz 读取对象类型
     * @param <T> 读取对象的类型
     * @return 输出流
     */
    public static <T> T readObj(ValidateObjectInputStream in, Class<T> clazz) {
        if (in == null) {
            throw new IllegalArgumentException("The InputStream must not be null");
        }
        if (null != clazz) {
            in.accept();
        }
        try {
            return (T) in.readObject();
        } catch (IOException e) {
            throw new IORuntimeException(e);
        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        }
    }

    /**
     * @param out        输出流
     * @param isCloseOut 是否关闭资源
     * @param contents   写入的内容
     */
    public static void writeObjects(OutputStream out, boolean isCloseOut, Serializable... contents) {
        ObjectOutputStream ost = null;
        try {
            ost = out instanceof ObjectOutputStream ? (ObjectOutputStream)out: new ObjectOutputStream(out);
            for (Object content : contents) {
                if (content != null) {
                    ost.writeObject(content);
                }
            }
            ost.flush();
        } catch (IOException e) {
            throw new IORuntimeException(e);
        } finally {
            if (isCloseOut) {
                // 关闭流
                close(ost);
            }
        }
    }

    /**
     * 关闭<br>
     * 关闭失败不会抛出异常
     *
     * @param closeable 被关闭的资源
     */
    public static void close(Closeable closeable) {
        try {
            if (null != closeable) {
                closeable.close();
            }
        } catch (Exception e) {
            // 静默关闭
        }
    }

    /**
     * 带有验证功能的对象流
     */
    static class ValidateObjectInputStream extends ObjectInputStream {

        private Set<String> whiteClassSet;
        private Set<String> blackClassSet;

        /**
         * @param inputStream 流
         * @param acceptClasses 白名单的类
         * @throws IOException IO异常
         */
        public ValidateObjectInputStream(InputStream inputStream, Class<?>... acceptClasses) throws IOException {
            super(inputStream);
            accept(acceptClasses);
        }

        /**
         * 接受反序列化的类，用于反序列化验证
         *
         * @param acceptClasses 接受反序列化的类
         */
        public void accept(Class<?>... acceptClasses) {
            if (null == this.whiteClassSet) {
                this.whiteClassSet = new HashSet<>();
            }
            for (Class<?> acceptClass : acceptClasses) {
                this.whiteClassSet.add(acceptClass.getName());
            }
        }

        /**
         * 只允许反序列化SerialObject class
         *
         * @param desc an instance of class <code>ObjectStreamClass</code>
         * @return
         * @throws IOException IO异常
         * @throws ClassNotFoundException ClassNotFoundException
         */
        @Override
        protected Class<?> resolveClass(ObjectStreamClass desc) throws IOException, ClassNotFoundException {
            validateClassName(desc.getName());
            return super.resolveClass(desc);
        }

        private void validateClassName(String className) throws InvalidClassException {
            // 黑名单
            if (CollectionUtil.isNotEmpty(this.blackClassSet)) {
                if (this.blackClassSet.contains(className)) {
                    throw new InvalidClassException("Unauthorized deserialization attempt by black list", className);
                }
            }

            if (CollectionUtil.isEmpty(this.whiteClassSet)) {
                return;
            }
            if(className.startsWith("java.")){
                // java中的类默认在白名单中
                return;
            }
            if(this.whiteClassSet.contains(className)){
                return;
            }

            throw new InvalidClassException("Unauthorized deserialization attempt", className);
        }
    }
}
