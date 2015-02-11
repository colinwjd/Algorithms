package colin.base;

import java.util.Iterator;

/**
 * 基于数组的栈
 * 
 * @author ColinWang{wjdwjd@mail.com}
 * @date Feb 11, 2015
 * @param <E>
 */
public class ArrayBasedStack<E> implements Iterable<E> {
	private E[] elements;
	private int top;

	private static final int DEFAULT_CAPACITY = 5;

	@SuppressWarnings("unchecked")
	public ArrayBasedStack(int cap) {
		elements = (E[]) new Object[cap];
	}

	public ArrayBasedStack() {
		this(DEFAULT_CAPACITY);
	}

	public void push(E e) {
		// 压栈时，如果栈已满，则扩容两倍
		if (top == elements.length) {
			int newSize = top << 1;
			resize(newSize);
		}
		elements[top++] = e;
	}

	public E pop() {
		E element = elements[--top];
		// 避免对象游离，便于垃圾回收
		elements[top] = null;
		// 元素出栈后，如果数组利用率不足1/4，则将数组缩小一半
		if (top > 0 && top << 2 <= elements.length) {
			resize(elements.length >> 1);
		}
		return element;
	}

	public boolean isEmpty() {
		return top == 0;
	}

	public int size() {
		return top;
	}

	@SuppressWarnings("unchecked")
	private void resize(int max) {
		E[] temp = (E[]) new Object[max];
		for (int i = 0; i < top; i++) {
			temp[i] = elements[i];
		}
		elements = temp;
	}

	@Override
	public Iterator<E> iterator() {
		return new ReverseArrayIterator();
	}

	// 实现按照后进先出的顺序遍历栈
	private class ReverseArrayIterator implements Iterator<E> {
		private int size = top;

		@Override
		public boolean hasNext() {
			return size > 0;
		}

		@Override
		public E next() {
			return elements[--size];
		}

	}

}
