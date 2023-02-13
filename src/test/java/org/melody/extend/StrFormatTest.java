package org.melody.extend;

import cn.hutool.core.map.MapUtil;
import cn.hutool.core.util.StrUtil;
import org.junit.jupiter.api.Test;

/**
 * @author lizhaohui
 * @since 2023/2/10
 */
class StrFormatTest {

    @Test
    void format() {

        String s = StrUtil.format("siot/sys/{productKey}/{deviceKey}/property/get",
                MapUtil.builder().put("productKey", "11").put("deviceKey", "22").build());
        System.out.println(s);
    }
}