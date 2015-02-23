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
public class ArrayBasedStackTest {

	private ArrayBasedStack<String> abs;
	/**
	 * @throws java.lang.Exception
	 */
	@Before
	public void setUp() throws Exception {
		abs = new ArrayBasedStack<>();
	}

	/**
	 * Test method for {@link colin.base.ArrayBasedStack#push(java.lang.Object)}.
	 */
	@Test
	public void testPush() {
		abs.push("hello");
		assertEquals("hello", abs.pop());
	}

	/**
	 * Test method for {@link colin.base.ArrayBasedStack#pop()}.
	 */
	@Test
	public void testPop() {
		abs.push("hello");
		abs.push("colin");
		abs.push("wang");
		assertEquals("wang", abs.pop());
		assertEquals("colin", abs.pop());
		assertEquals("hello", abs.pop());
	}

	/**
	 * Test method for {@link colin.base.ArrayBasedStack#isEmpty()}.
	 */
	@Test
	public void testIsEmpty() {
		assertTrue(abs.isEmpty());
		abs.push("hello");
		abs.push("colin");
		abs.push("wang");
		assertFalse(abs.isEmpty());
	}

	/**
	 * Test method for {@link colin.base.ArrayBasedStack#size()}.
	 */
	@Test
	public void testSize() {
		assertTrue(abs.size() == 0);
		abs.push("hello");
		assertTrue(abs.size() == 1);
		abs.push("colin");
		assertTrue(abs.size() == 2);
		abs.push("wang");
		assertTrue(abs.size() == 3);
	}

	/**
	 * Test method for {@link colin.base.ArrayBasedStack#iterator()}.
	 */
	@Test
	public void testIterator() {
		abs.push("hello");
		abs.push("colin");
		abs.push("wang");
		for (String string : abs) {
			System.out.println(string);
		}
	}

}
