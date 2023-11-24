package org.melody.myEnum;

import java.util.HashMap;
import java.util.Map;

/**
 * Enum defining various PayStatus types and their integer mappings.
 * Each PayStatus type has an associated integer value which can be accessed via {@link #getStatusValue()}.
 * To find a PayStatus for a specific integer value, use {@link #fromValue(int)}.
 * @author lizhaohui
 * @since 2023/2/7
 */
public enum PayStatus {

    SUCCESS(1),
    IN_PROGRESS(2),
    FAILED(4),
    REFUND(8),
    COMPLETED(16),
    CANCELLED(32),
    UNKNOWN(-99);

    private final int statusValue;
    private static final Map<Integer, PayStatus>
            BY_VALUE_MAP = new HashMap<>();

    static {
        for (PayStatus status : values()) {
            BY_VALUE_MAP.put(status.statusValue, status);
        }
    }

    PayStatus(int statusValue) {
        this.statusValue = statusValue;
    }

    /**
     * Returns the integer value associated with this status.
     *
     * @return The integer value of this status.
     */
    public int getStatusValue() {
        return this.statusValue;
    }

    /**
     * Returns the PayStatus associated with the provided integer value.
     * If the value doesn't match any existing PayStatus, {@link #UNKNOWN} will be returned.
     *
     * @return The PayStatus associated with the provided value.
     */
    public static PayStatus fromValue(int value) {
        return BY_VALUE_MAP.getOrDefault(value, UNKNOWN);
    }
}
