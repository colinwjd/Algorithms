package colin.base;

import java.util.Iterator;

/**
 * 基于后入先出策略的集合类型，链表实现
 * 
 * @author ColinWang{wjdwjd@mail.com}
 * @date Feb 11, 2015
 * @param <E>
 */
public class Stack<E> implements Iterable<E> {

	private Node top;
	private int size;

	private class Node {
		E element;
		Node next;
	}

	public boolean isEmpty() {
		return size == 0; // or top == null;
	}

	public int size() {
		return size;
	}

	public void push(E e) {
		Node oldTop = top;
		top = new Node();
		top.element = e;
		top.next = oldTop;
		size++;
	}

	public E pop() {
		E element = top.element;
		top = top.next;
		size--;
		return element;
	}

	public E peek() {
		return top.element;
	}

	@Override
	public Iterator<E> iterator() {
		return new StackIterator();
	}

	private class StackIterator implements Iterator<E> {

		private Node current = top;

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
