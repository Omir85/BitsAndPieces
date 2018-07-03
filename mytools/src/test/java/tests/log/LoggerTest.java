/**
 *
 */
package tests.log;

import java.lang.invoke.MethodHandles;

import org.junit.Before;
import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import ch.qos.logback.classic.Level;

public class LoggerTest {

	private static Logger logger = LoggerFactory.getLogger(MethodHandles.lookup().lookupClass());

	@Before
	public void setup() {
		// here we use logback implementation to set the level to ALL in order to see every line when launching the test suite.
		((ch.qos.logback.classic.Logger) logger).setLevel(Level.ALL);
	}

	@Test
	public void testLoggerError() {
		logger.error("test logger.error");
	}

	@Test
	public void testLoggerWarn() {
		logger.warn("test logger.warn");
	}

	@Test
	public void testLoggerInfo() {
		logger.info("test logger.info");
	}

	@Test
	public void testLoggerDebug() {
		logger.debug("test logger.debug");
	}

	@Test
	public void testLoggerTrace() {
		logger.trace("test logger.trace");
	}

	@Test
	public void testLoggerInfoWithFormat() {
		logger.info("test logger.info({})", "with {} format");
	}
}
