package org.melody.extend;

import cn.hutool.core.date.DateTime;
import cn.hutool.core.date.DateUtil;

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
}
