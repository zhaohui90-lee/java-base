package org.melody.myEnum;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

/**
 * @author lizhaohui
 * @since 2023/2/7
 */
class PayStatusTest {

    @Test
    void getValue() {

        Assertions.assertEquals(PayStatus.COMPLETED, PayStatus.fromValue(16));
        Assertions.assertEquals(4, PayStatus.FAILED.getStatusValue());
        Assertions.assertEquals(8, PayStatus.REFUND.getStatusValue());
        Assertions.assertEquals(16, PayStatus.COMPLETED.getStatusValue());
    }
}