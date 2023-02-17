package org.melody.algorithm;

import java.util.Arrays;
import java.util.Random;

/**
 * @author lizhaohui
 * @since 2023/2/16
 */
public class BitArithmetic {

    public static void main(String[] args) {
        int i = -1;
        System.out.println(Integer.toBinaryString(i));
        i >>>= 10;
        System.out.println(Integer.toBinaryString(i));
        long l = -1;
        System.out.println(Long.toBinaryString(l));
        l >>>= 10;
        System.out.println(Long.toBinaryString(l));
        short s = -1;
        System.out.println(Integer.toBinaryString(s));
        s >>>= 10;
        System.out.println(Integer.toBinaryString(s));

        int k = 10; // 二进制表示 00000000 00000000 00000000 00001010
                    // 取反      11111111 11111111 11111111 11110101
        System.out.println(Integer.toBinaryString(k));
        System.out.println(Integer.toBinaryString(-11));
        System.out.println(~k);
        System.out.println(~k & 1);
    }

    /**
     * 位运算在分支预测器上的技巧<br/>
     * 在随机大小数据的环境下，能够有效地提升代码运行的效率<br/>
     * <code>
     *  int t = (data[c] - 128) >> 31;<br/>
     *  sum += ~t & data[c];
     * </code>
     */
    public static void count() {
        // Generate data
        int arraySize = 32768;
        int data[] = new int[arraySize];

        Random rnd = new Random(0);
        for (int c = 0; c < arraySize; ++c)
            data[c] = rnd.nextInt() % 256;

        // !!! With this, the next loop runs faster
        Arrays.sort(data);

        // Test
        long start = System.nanoTime();
        long sum = 0;
        for (int i = 0; i < 100000; ++i)
        {
            for (int c = 0; c < arraySize; ++c)
            {   // Primary loop.
//                if (data[c] >= 128)
//                    sum += data[c]; // 2.8(sort) 6.5(random)
                int t = (data[c] - 128) >> 31;
                sum += ~t & data[c]; // 1.69
            }
        }

        System.out.println((System.nanoTime() - start) / 1000000000.0);
        System.out.println("sum = " + sum);
    }
}
