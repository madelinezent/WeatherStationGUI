package Tests4;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

import ISS4.Driver;

class DriverTest extends Driver {
	Driver test = new Driver();

	@Test
	void testDebug() {
		assertEquals(1, test.debug(), "GUI not created successfully");
	}
}
