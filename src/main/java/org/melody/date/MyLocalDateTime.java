package org.melody.date;

import java.time.Instant;
import java.time.LocalDateTime;
import java.time.ZoneId;

/**
 * @author lizhaohui
 * @since 2023/2/21
 */
public class MyLocalDateTime {

    public static void main(String[] args) {
        Instant now = Instant.now();

        LocalDateTime time = LocalDateTime.ofInstant(now, ZoneId.of("Asia/Shanghai"));
        System.out.println(time);
    }
}
