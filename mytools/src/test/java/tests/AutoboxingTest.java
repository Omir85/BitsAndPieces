package tests;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

/**
 * Tests about Autoboxing issues.
 *
 * @author JM Bernard
 *
 */
public class AutoboxingTest {

	private Long a, b;

	@Before
	/**
	 * Reset a and b for every test.
	 */
	public void setup() {
		a = b = null;
	}

	@Test
	public void testAutoboxingNullNullWithoutAutoboxingProblem() {
		Assert.assertNull("Result should be null", sumWithoutAutoboxingProblem(a, b));
	}

	@Test
	public void testAutoboxingNotNullNullWithoutAutoboxingProblem() {
		a = 1L;
		Assert.assertEquals("Result should be equal to " + a, a, sumWithoutAutoboxingProblem(a, b));
	}

	@Test
	public void testAutoboxingNullNotNullWithoutAutoboxingProblem() {
		b = 2L;
		Assert.assertEquals("Result should be equal to " + b, b, sumWithoutAutoboxingProblem(a, b));
	}

	@Test
	public void testAutoboxingNotNullNotNullWithoutAutoboxingProblem() {
		a = 1L;
		b = 2L;
		Assert.assertEquals("Result should be equal to " + (a + b), Long.valueOf(a + b), sumWithoutAutoboxingProblem(a, b));
	}

	@Test
	public void testAutoboxingNullNullWithAutoboxingProblem() {
		try {
			Assert.assertNull("Result should be null", sumWithAutoboxingProblem(a, b));
		}
		catch (Exception e) {
			if (!(e instanceof NullPointerException)) {
				Assert.fail("Unexpected exception");
			}
			return;
		}
		Assert.fail("The autoboxing problem is solved");
	}

	@Test
	public void testAutoboxingNotNullNullWithAutoboxingProblem() {
		a = 1L;
		Assert.assertEquals("Result should be equal to " + a, a, sumWithAutoboxingProblem(a, b));
	}

	@Test
	public void testAutoboxingNullNotNullWithAutoboxingProblem() {
		b = 2L;
		Assert.assertEquals("Result should be equal to " + b, b, sumWithAutoboxingProblem(a, b));
	}

	@Test
	public void testAutoboxingNotNullNotNullWithAutoboxingProblem() {
		a = 1L;
		b = 2L;
		Assert.assertEquals("Result should be equal to " + (a + b), Long.valueOf(a + b), sumWithAutoboxingProblem(a, b));
	}

	/**
	 * This method includes an autoboxing issue if a AND b are null in the one-liner. <br />
	 * It will throw a {@link NullPointerException} in that case.
	 *
	 * @param a
	 *            a {@link Long}
	 * @param b
	 *            a {@link Long}
	 * @return the result of a + b
	 */
	private static Long sumWithAutoboxingProblem(Long a, Long b) {
		return a == null ? b == null ? null : b : b == null ? a : a + b;
	}

	/**
	 * This method solves the autoboxing issue by changing the algorithm and keeps the one-liner syntax. <br />
	 * 1st case: a AND b are null => return null <br />
	 * 2nd case: a AND b are not null => return a+b <br />
	 * 3rd case: either a or b is null => return the not null one
	 *
	 * @param a
	 *            a {@link Long}
	 * @param b
	 *            a {@link Long}
	 * @return the result of a + b
	 */
	private static Long sumWithoutAutoboxingProblem(Long a, Long b) {
		return a == null && b == null ? null : a != null && b != null ? a + b : a == null ? b : a;
	}

}