package org.melody.extend;

import cn.hutool.core.date.DateUtil;
import org.junit.jupiter.api.Test;

import java.math.BigDecimal;
import java.util.Date;

import static org.junit.jupiter.api.Assertions.*;

/**
 * @author lizhaohui
 * @since 2023/3/28
 */
class DateExtendTest {

    /**
     * 单元测试 getDiffTime
     */
    @Test
    void getDiffTime() {
        // 1. 测试输入参数为null
        BigDecimal diffTime = DateExtend.getDiffTime(null);
        assertEquals(new BigDecimal(0), diffTime);
        // 2. 测试输入参数为字符串
        diffTime = DateExtend.getDiffTime("2017-03-01 22:33:23");
        assertTrue(diffTime.compareTo(new BigDecimal(0)) > 0);
    }
}