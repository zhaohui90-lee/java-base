package org.melody.extend;

import cn.hutool.core.date.StopWatch;
import cn.hutool.dfa.FoundWord;
import cn.hutool.dfa.WordTree;
import org.junit.jupiter.api.Test;

import java.util.List;
import java.util.stream.Collectors;

import static org.junit.jupiter.api.Assertions.*;

/**
 * @author lizhaohui
 * @since 2023/2/20
 */
class AutomationTest {

    /**
     * 密集匹配 测试查找结果，并与WordTree对比效率
     */
    @Test
    void testFind() {
        Automaton automaton = new Automaton();
        WordTree wordTree = new WordTree();
        automaton.insert("say", "her", "he", "she", "shr");
        automaton.buildAc();
        wordTree.addWords("say", "her", "he", "she", "shr");

        StopWatch stopWatch = new StopWatch();
        String input = "sasherhsay";

        stopWatch.start("automaton_char_find");
        List<FoundWord> ans1 = automaton.find(input);
        stopWatch.stop();
        assertEquals("she,he,her,say", ans1.stream().map(FoundWord::getWord).collect(Collectors.joining(",")));
        assertEquals(Integer.valueOf(2), ans1.get(0).getStartIndex());
        assertEquals(Integer.valueOf(4), ans1.get(0).getEndIndex());
        assertEquals(Integer.valueOf(3), ans1.get(1).getStartIndex());
        assertEquals(Integer.valueOf(4), ans1.get(1).getEndIndex());
        assertEquals(Integer.valueOf(3), ans1.get(2).getStartIndex());
        assertEquals(Integer.valueOf(5), ans1.get(2).getEndIndex());
        assertEquals(Integer.valueOf(7), ans1.get(3).getStartIndex());
        assertEquals(Integer.valueOf(9), ans1.get(3).getEndIndex());

        stopWatch.start("wordtree_char_find");
        List<String> ans2 = wordTree.matchAll(input, -1, true, true);
        stopWatch.stop();
        assertEquals("she,he,her,say", String.join(",", ans2));

        System.out.println(stopWatch.prettyPrint());
    }

    /**
     * 非密集匹配 测试查找结果，并与WordTree对比效率
     */
    @Test
    public void testFindNotDensity() {
        Automaton automaton = new Automaton();
        WordTree wordTree = new WordTree();
        automaton.insert("say", "her", "he", "she", "shr");
        automaton.buildAc();
        wordTree.addWords("say", "her", "he", "she", "shr");

        StopWatch stopWatch = new StopWatch();
        String input = "sasherhsay";

        stopWatch.start("automaton_char_find_not_density");
        List<FoundWord> ans1 = automaton.find(input, false);
        stopWatch.stop();
        assertEquals("she,say", ans1.stream().map(FoundWord::getWord).collect(Collectors.joining(",")));
        assertEquals(Integer.valueOf(2), ans1.get(0).getStartIndex());
        assertEquals(Integer.valueOf(4), ans1.get(0).getEndIndex());
        assertEquals(Integer.valueOf(7), ans1.get(1).getStartIndex());
        assertEquals(Integer.valueOf(9), ans1.get(1).getEndIndex());

        stopWatch.start("wordtree_char_find_not_density");
        List<String> ans2 = wordTree.matchAll(input, -1, false, true);
        stopWatch.stop();
        assertEquals("she,say", String.join(",", ans2));

        System.out.println(stopWatch.prettyPrint());
    }
}