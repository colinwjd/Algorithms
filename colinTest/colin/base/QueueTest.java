/**
 * 
 */
package colin.base;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

/**
 * @author ColinWang{wjdwjd@live.cn}
 * @date Feb 23, 2015
 */
public class QueueTest {

	private Queue<String> queue;
	/**
	 * @throws java.lang.Exception
	 */
	@Before
	public void setUp() throws Exception {
		queue = new Queue<>();
	}

	/**
	 * Test method for {@link colin.base.Queue#isEmpty()}.
	 */
	@Test
	public void testIsEmpty() {
		assertTrue(queue.isEmpty());
		queue.enqueue("hello");
		queue.enqueue("colin");
		assertFalse(queue.isEmpty());
	}

	/**
	 * Test method for {@link colin.base.Queue#size()}.
	 */
	@Test
	public void testSize() {
		assertTrue(queue.size() == 0);
		queue.enqueue("hello");
		assertTrue(queue.size() == 1);
		queue.enqueue("colin");
		assertTrue(queue.size() == 2);
	}

	/**
	 * Test method for {@link colin.base.Queue#enqueue(java.lang.Object)}.
	 */
	@Test
	public void testEnqueue() {
		queue.enqueue("hello");
		queue.enqueue("colin");
		assertEquals("hello", queue.peek());
		queue.dequeue();
		assertEquals("colin", queue.peek());
	}

	/**
	 * Test method for {@link colin.base.Queue#dequeue()}.
	 */
	@Test
	public void testDequeue() {
		queue.enqueue("hello");
		queue.enqueue("colin");
		queue.enqueue("wang");
		assertEquals("hello", queue.dequeue());
		assertEquals("colin", queue.dequeue());
		assertEquals("wang", queue.dequeue());
	}

	/**
	 * Test method for {@link colin.base.Queue#peek()}.
	 */
	@Test
	public void testPeek() {
		queue.enqueue("hello");
		queue.enqueue("colin");
		assertEquals("hello", queue.peek());
		queue.dequeue();
		assertEquals("colin", queue.peek());
	}

	/**
	 * Test method for {@link colin.base.Queue#iterator()}.
	 */
	@Test
	public void testIterator() {
		queue.enqueue("hello");
		queue.enqueue("colin");
		queue.enqueue("wang");
		for (String string : queue) {
			System.out.println(string);
		}
	}

}
