package org.melody.collections;

import java.util.*;
import java.util.stream.Collectors;

/**
 * 移除<code>hashMap中的重复元素</code>
 * @author lizhaohui
 * @since 2023/3/17
 */
public class MyHashMap {

    public static void main(String[] args) {
        Map<Integer, String> map = new HashMap<>();

        // 添加一些重复元素到 map 中
        map.put(1, "apple");
        map.put(2, "banana");
        map.put(3, "apple");
        map.put(4, "orange");
        map.put(5, "banana");

        System.out.println(map);

        // 遍历 HashMap 中的所有键值对
//        removeDuplicateValue(map);

        map = removeDuplicateValues(map);

        // 打印 HashMap 中的所有键值对
        for (Map.Entry<Integer, String> entry : map.entrySet()) {
            System.out.println(entry.getKey() + " : " + entry.getValue());
        }
    }

    public static <K, V> Map<K, V> removeDuplicateValue(Map<K, V> map) {
        Set<V> uniqueValues = new HashSet<>();
        Iterator<Map.Entry<K, V>> iterator = map.entrySet().iterator();

        while (iterator.hasNext()) {
            Map.Entry<K, V> entry = iterator.next();
            if (!uniqueValues.add(entry.getValue())) {
                iterator.remove();
            }
        }

        return map;
    }

    public static <K, V> Map<K, V> removeDuplicateValues(Map<K, V> map) {
        Map<V, K> reversedMap = new LinkedHashMap<>();
        map.forEach((key, value) -> reversedMap.put(value, key));

        return reversedMap.entrySet().stream()
                .collect(Collectors.toMap(
                        Map.Entry::getValue,
                        Map.Entry::getKey,
                        (e1, e2) -> e1,
                        HashMap::new
                ));

    }
}
