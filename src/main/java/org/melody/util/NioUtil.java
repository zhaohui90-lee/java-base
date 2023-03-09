package org.melody.util;

/**
 * NIO相关工具类封装 主要针对Channel读写、拷贝等<br/>
 *  代码来源: <a href="https://github.com/dromara/hutool/blob/v5-master/hutool-core/src/main/java/cn/hutool/core/io/NioUtil.java">...</a>
 * @author lizhaohui
 * @since 2023/3/6
 */
public class NioUtil {

    /**
     * 默认缓存大小 8192
     */
    public static final int DEFAULT_BUFFER_SIZE = 2 << 12;

    /**
     * 默认中等缓存大小 16384
     */
    public static final int DEFAULT_MIDDLE_BUFFER_SIZE = 2 << 13;

    /**
     * 默认大缓存大小 32768
     */
    public static final int DEFAULT_LARGE_BUFFER_SIZE = 2 << 14;

    /**
     * 数据类末尾
     */
    public static final int EOF = -1;


}
