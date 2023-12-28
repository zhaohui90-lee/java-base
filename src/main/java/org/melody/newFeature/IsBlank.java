package org.melody.newFeature;

import java.util.stream.Collectors;

/**
 * @author lizhaohui
 * @since 2023/12/28
 */
public class IsBlank {

    public static void main(String[] args) {
        Example example = new Example();
        // isBank() 判断字符串是否为空白
        System.out.println(example.str.isBlank());
        // lines() 返回一个流，其元素为此字符串，按照换行符分割
        System.out.println(example.str1.lines().collect(Collectors.toList()));
        // repeat(int count) 返回一个字符串，其值为此字符串重复count次
        System.out.println(example.str2.repeat(5));
        // strip() 返回一个字符串，其值为此字符串，去除了前后空格
        System.out.println("   hi  ".strip());
        // stripLeading() 返回一个字符串，其值为此字符串，去除了前导空格
        System.out.println("   hi  ".stripLeading());
        // stripTrailing() 返回一个字符串，其值为此字符串，去除了尾部空格
        System.out.println("   hi  ".stripTrailing());
    }

    static class Example {
        private String str = "";
        private String str1 = "Hi\nHello\nNamaste";
        private String str2 = "1";
    }
}
