package org.melody.newFeature;

import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

/**
 * @author lizhaohui
 * @since 2023/12/28
 */
class Collection2ArrayTest {

    /**
     * Test method for {@link Collection2Array#main(java.lang.String[])}.
     * Compare this snippet from src/main/java/org/melody/newFeature/Collection2Array.java:
     * package org.melody.newFeature;
     */
    @Test
    public void convertTest() {
        List<String> list = Arrays.asList("java", "python", "javaScript");
        String[] array = list.toArray(String[]::new);
        // 使用junit库比较list和array中的元素是否相同
        assertArrayEquals(list.toArray(), array);
    }
}