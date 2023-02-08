package org.melody.myEnum;

/**
 * @author lizhaohui
 * @since 2023/2/7
 */
public enum Status {

    PAY_SUCCESS("0"),
    PAY_ING("1"),
    PAY_FAIL("2"),
    PAY_REFUND("3"),
    PAY_COMPLETED("4"),
    PAY_CANCEL("5"),
    PAY_UNKNOWN("-99");

    private final String value;

    Status(String value) {
        this.value = value;
    }

    public String getValue() {
        return this.value;
    }
}
