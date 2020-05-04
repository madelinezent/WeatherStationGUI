package Tests4;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

import ISS4.Rain;

class RainTest {
	Rain testRain = new Rain(12.0);

	@Test
	void testConstructor() {
		assertEquals(12.0, testRain.getMyRainRate());
	}

}
