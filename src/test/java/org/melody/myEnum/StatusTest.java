package org.melody.myEnum;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

/**
 * @author lizhaohui
 * @since 2023/2/7
 */
class StatusTest {

    @Test
    void getValue() {

        String returnCode = "0";

        if (returnCode.equals(Status.PAY_SUCCESS.getValue())) {
            System.out.println("PAY_SUCCESS...");
        }
    }
}