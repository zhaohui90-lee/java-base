package org.melody.clone;

import java.io.Serializable;

/**
 * 通过返序列化实现深拷贝
 *  <pre>
 *      java序列化是将java在JVM中的对象转化为字节序列的过程，实现对象数据的持久化<br/>
 *      反序列化就是将字节序列转化为对象的过程，这一过程会为对象重新开辟一个新的内存空间<br/>
 *      通过反序列化实现深拷贝的思路就是：通过序列化将对象中的变量和方法转化为字节，然后通过反序列化重新生成一个全新的对象，从而实现和源对象脱离
 *  </pre>
 * @author lizhaohui
 * @since 2023/3/2
 */
public class DeepCopy implements Serializable {

    /**
     * {@code serialVersionUID}是序列化时会生成的一个版本号（没有显示声明的话，JVM会隐式生成一个），在反序列化会自动取检测这个
     * 版本号，不一致就会导致反序列化失败{@code InvalidClassException}
     */
    private static final long serialVersionUID = -6065753366525422846L;
}
