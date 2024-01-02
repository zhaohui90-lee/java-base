package org.melody.newFeature;

import java.util.Arrays;
import java.util.List;

/**
 * @author lizhaohui
 * @since 2023/12/28
 */
public class Collection2Array {
    public static void main(String[] args) {
        List<String> list = Arrays.asList("java", "python", "javaScript");
        // ::new 表示构造器引用 jdk1.8
        String[] array = list.toArray(String[]::new);
        System.out.println(Arrays.toString(array));
    }
}
