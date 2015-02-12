package colin.base;

import java.util.Iterator;

/**
 * 基于先入先出策略的集合类型，链表实现
 * 
 * @author ColinWang{wjdwjd@mail.com}
 * @date Feb 11, 2015
 * @param <E>
 */
public class Queue<E> implements Iterable<E> {

	private Node first;
	private Node last;
	private int size;

	private class Node {
		E element;
		Node next;
	}

	public boolean isEmpty() {
		return size == 0;
	}

	public int size() {
		return size;
	}

	/**
	 * 入队
	 * 
	 * @param e
	 */
	public void enqueue(E e) {
		Node oldLast = last;
		last = new Node();
		last.element = e;
		last.next = null;
		if (isEmpty()) {
			first = last;
		} else {
			oldLast.next = last;
		}
		size++;
	}

	/**
	 * 出队
	 * 
	 * @return
	 */
	public E dequeue() {
		E element = first.element;
		first = first.next;
		size--;
		if (isEmpty()) {
			last = null;
		}
		return element;
	}

	/**
	 * 查看队头元素
	 * 
	 * @return
	 */
	public E peek() {
		return first.element;
	}

	@Override
	public Iterator<E> iterator() {
		return new QueueIterator();
	}

	private class QueueIterator implements Iterator<E> {

		private Node current = first;

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
