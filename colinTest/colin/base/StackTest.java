/**
 * 
 */
package colin.base;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import org.junit.Before;
import org.junit.Test;

/**
 * @author ColinWang{wjdwjd@live.cn}
 * @date Feb 23, 2015
 */
public class StackTest {

	private Stack<String> stack;

	/**
	 * @throws java.lang.Exception
	 */
	@Before
	public void setUp() throws Exception {
		stack = new Stack<>();
	}

	/**
	 * Test method for {@link colin.base.Stack#isEmpty()}.
	 */
	@Test
	public void testIsEmpty() {
		assertTrue(stack.isEmpty());
		stack.push("hello");
		assertFalse(stack.isEmpty());
	}

	/**
	 * Test method for {@link colin.base.Stack#size()}.
	 */
	@Test
	public void testSize() {
		assertTrue(stack.size() == 0);
		stack.push("colin");
		assertTrue(stack.size() == 1);
		stack.push("nice");
		assertTrue(stack.size() == 2);
	}

	/**
	 * Test method for {@link colin.base.Stack#push(java.lang.Object)}.
	 */
	@Test
	public void testPush() {
		stack.push("hello");
		assertEquals("hello", stack.peek());
		stack.push("colin");
		assertEquals("colin", stack.peek());
	}

	/**
	 * Test method for {@link colin.base.Stack#pop()}.
	 */
	@Test
	public void testPop() {
		stack.push("hello");
		stack.push("colin");
		stack.push("wang");
		assertEquals("wang", stack.pop());
		assertEquals("colin", stack.pop());
		assertEquals("hello", stack.pop());
	}

	/**
	 * Test method for {@link colin.base.Stack#peek()}.
	 */
	@Test
	public void testPeek() {
		stack.push("hello");
		stack.push("colin");
		stack.push("wang");
		assertEquals("wang", stack.peek());
		stack.pop();
		assertEquals("colin", stack.peek());
	}

	/**
	 * Test method for {@link colin.base.Stack#iterator()}.
	 */
	@Test
	public void testIterator() {
		stack.push("hello");
		stack.push("colin");
		stack.push("wang");
		for (String string : stack) {
			System.out.println(string);
		}
	}

}
