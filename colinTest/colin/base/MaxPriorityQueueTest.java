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
public class MaxPriorityQueueTest {

	private MaxPriorityQueue<Integer> maxPQ;

	/**
	 * @throws java.lang.Exception
	 */
	@Before
	public void setUp() throws Exception {
		maxPQ = new MaxPriorityQueue<>();
	}

	/**
	 * Test method for
	 * {@link colin.base.MaxPriorityQueue#insert(java.lang.Comparable)}.
	 */
	@Test
	public void testInsert() {
		maxPQ.insert(99);
		maxPQ.insert(77);
		maxPQ.insert(88);
		maxPQ.insert(64);
		maxPQ.insert(100);
		maxPQ.insert(64);
		assertTrue(maxPQ.size() == 6);
		int key = maxPQ.delMax();
		assertEquals(100, key);
		int key2 = maxPQ.max();
		assertEquals(99, key2);
	}

	/**
	 * Test method for {@link colin.base.MaxPriorityQueue#max()}.
	 */
	@Test
	public void testMax() {
		maxPQ.insert(99);
		maxPQ.insert(77);
		maxPQ.insert(88);
		maxPQ.insert(64);
		maxPQ.insert(100);
		maxPQ.insert(64);
		assertTrue(maxPQ.size() == 6);
		int key = maxPQ.delMax();
		assertEquals(100, key);
		int key2 = maxPQ.max();
		assertEquals(99, key2);
	}

	/**
	 * Test method for {@link colin.base.MaxPriorityQueue#delMax()}.
	 */
	@Test
	public void testDelMax() {
		maxPQ.insert(99);
		maxPQ.insert(77);
		maxPQ.insert(88);
		maxPQ.insert(64);
		maxPQ.insert(100);
		maxPQ.insert(64);
		assertTrue(maxPQ.size() == 6);
		int key = maxPQ.delMax();
		assertEquals(100, key);
		int key2 = maxPQ.max();
		assertEquals(99, key2);
	}

	/**
	 * Test method for {@link colin.base.MaxPriorityQueue#isEmpty()}.
	 */
	@Test
	public void testIsEmpty() {
		assertTrue(maxPQ.isEmpty());
		maxPQ.insert(99);
		maxPQ.insert(77);
		maxPQ.insert(88);
		maxPQ.insert(64);
		maxPQ.insert(100);
		assertFalse(maxPQ.isEmpty());
	}

	/**
	 * Test method for {@link colin.base.MaxPriorityQueue#size()}.
	 */
	@Test
	public void testSize() {
		assertTrue(maxPQ.size() == 0);
		maxPQ.insert(99);
		assertTrue(maxPQ.size() == 1);
		maxPQ.insert(77);
		assertTrue(maxPQ.size() == 2);
		maxPQ.insert(88);
		assertTrue(maxPQ.size() == 3);
		maxPQ.insert(64);
		assertTrue(maxPQ.size() == 4);
		maxPQ.insert(100);
		assertTrue(maxPQ.size() == 5);
	}

}
