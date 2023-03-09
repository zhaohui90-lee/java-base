package org.melody.util;

import java.util.Collection;

/**
 * 集合工具类
 *
 * @author lizhaohui
 * @since 2023/3/6
 */
public class CollectionUtil {

    public static boolean isNotEmpty(Collection<?> collection) {
        return !isEmpty(collection);
    }

    public static boolean isEmpty(Collection<?> collection) {
        return collection == null || collection.isEmpty();
    }
}
