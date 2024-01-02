package org.melody.gson.pojo;

/**
 *
 * @author lizhaohui
 * @since 2023/12/27
 */
public interface PersonApi {

    default Long createId() {
        return System.currentTimeMillis();
    }

    String getName();
}
