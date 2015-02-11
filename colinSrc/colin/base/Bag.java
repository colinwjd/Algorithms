package colin.base;

import java.util.Iterator;

/**
 * 不支持从中删除元素的集合数据类型，链表实现
 * 
 * @author ColinWang{wjdwjd@mail.com}
 * @date Feb 11, 2015
 * @param <E>
 */
public class Bag<E> implements Iterable<E> {

	private Node head;
	private int size;

	private class Node {
		E element;
		Node next;
	}

	public Bag() {
		head = null;
		size = 0;
	}

	public void add(E e) {
		Node oldHead = head;
		head = new Node();
		head.element = e;
		head.next = oldHead;
		size++;
	}

	public boolean isEmpty() {
		return head == null;
	}

	public int size() {
		return size;
	}

	@Override
	public Iterator<E> iterator() {
		return new BagIterator();
	}

	private class BagIterator implements Iterator<E> {

		private Node current = head;

		@Override
		public boolean hasNext() {
			return current.next != null;
		}

		@Override
		public E next() {
			E element = current.element;
			current = current.next;
			return element;
		}

	}

}
