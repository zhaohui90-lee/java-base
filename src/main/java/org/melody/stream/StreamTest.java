package org.melody.stream;

import org.melody.stream.pojo.Menu;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

/**
 * @author lizhaohui
 * @since 2023/12/28
 */
public class StreamTest {

    static List<Menu> menus = Arrays.asList(
            new Menu("pork", 800, Menu.Type.MEAT),
            new Menu("beef", 700, Menu.Type.MEAT),
            new Menu("chicken", 400, Menu.Type.MEAT),
            new Menu("french fries", 530, Menu.Type.OTHER),
            new Menu("rice", 350, Menu.Type.OTHER),
            new Menu("season fruit", 120, Menu.Type.OTHER),
            new Menu("pizza", 550, Menu.Type.OTHER),
            new Menu("prawns", 300, Menu.Type.FISH),
            new Menu("salmon", 450, Menu.Type.FISH)
    );

    public static void main(String[] args) {
        List<Menu> collect = menus.stream().filter(m -> m.getCalories() > 400)
                .sorted((m1, m2) -> m1.getCalories() - m2.getCalories()).collect(Collectors.toList());

        System.out.println(collect);
    }
}
