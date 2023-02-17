package org.melody.collections;

/**
 * 1. ArrayList是通过调整动态数组大小来实现的<br/>
 * 2. LinkedList是通过双向链表来实现的<br/>
 *
 * ArrayList：
 *  <pre>
 *  1. <code>get(int index)</code> O(1)
 *  2. <code>add(E element)</code> 最佳时间为O(1)，但最坏情况是O(n)，因为数组必须调整大小和复制
 *  3. <code>add(int index, E element)</code> O(n) 平均时间复杂度为O(n/2)
 *  4. <code>remove(int index)</code> O(n) 平均时间复杂度为O(n/2)
 *  5. <code>Iterator.remove()</code> O(n) 平均时间复杂度为O(n/2)
 *  6. <code>ListIterator.add(E element)</code> O(n) 平均时间复杂度为O(n/2)
 *  </pre>
 *
 *  LinkedList：
 *  <pre>
 *  1. <code>get(int index)</code> O(n) 平均时间复杂度为O(n/4)，当index=0或者index=list.size()-1时，O(1)
 *  2. <code>add(int index, E element)</code> O(n) 平均时间复杂度为O(n/4)，当index=0或者index=list.size()-1时，O(1)
 *  3. <code>remove(int index)</code> O(n) 平均时间复杂度为O(n/4)，当index=0或者index=list.size()-1时，O(1)
 *  4. <code>Iterator.remove()</code> O(1)
 *  5. <code>ListIterator.add(E element)</code> O(1)
 *  </pre>
 * @author lizhaohui
 * @since 2023/2/17
 */
public class ArrayListAndLinkedList {
}
