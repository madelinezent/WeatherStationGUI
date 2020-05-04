package Tests4;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

import Envoy4.TempIn;

class TempInTest {
	TempIn test = new TempIn(1500);
	
	@Test
	void testConstructorDefault() {
		assertEquals(1500, test.getMyTemp(), "inside temperature constructor getter/initialization is incorrect");
	}

}
