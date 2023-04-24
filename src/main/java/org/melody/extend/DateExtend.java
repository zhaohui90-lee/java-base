package org.melody.extend;

import cn.hutool.core.date.DateException;
import cn.hutool.core.date.DateTime;
import cn.hutool.core.date.DateUtil;

import java.math.BigDecimal;
import java.util.Date;

/**
 * @author lizhaohui
 * @since 2023/2/23
 */
public class DateExtend {

    public static void main(String[] args) {
        // 这里使用Date去接收变量而不是DateTime类型
        Date date = DateUtil.date();
        int year = DateUtil.year(date);
        System.out.println("year: " + year);

        String dateStr = "2017-03-01 22:33:23";
        Date time = DateUtil.parse(dateStr);

        // 一天的开始
        Date beginOfDay = DateUtil.beginOfDay(time);
        System.out.println(beginOfDay);
    }

    /**
     * 实现计算当前时间和输入字符串表示的日期的时间差,返回计算结果
     * @param dateString 输入日期
     * @return 时间差
     */
    public static BigDecimal getDiffTime(String dateString) throws DateException {
        // 1. 判断输入参数是否为null
        if (dateString == null) {
            return new BigDecimal(0);
        }
        // 2. 将输入的字符串转换为Date类型
        Date date = DateUtil.parse(dateString);
        // 3. 获取当前时间
        Date now = DateUtil.date();
        // 4. 计算时间差
        long diff = now.getTime() - date.getTime();
        // 5. 将时间差转换为秒
        // 6. 返回计算结果
        return new BigDecimal(diff / 1000);
    }


}
