package org.melody.extend;

import cn.hutool.core.map.MapUtil;
import cn.hutool.core.util.StrUtil;

/**
 * @author lizhaohui
 * @since 2023/2/10
 */
public class StrFormat {

    public static String format(String target, String key, String value) {
        return StrUtil.format(target, MapUtil.builder(key, value));
    }
}
