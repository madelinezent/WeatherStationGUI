package tests;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.BeforeEach;
import sensorData.*;
import org.junit.jupiter.api.Test;

/**
 * Tests if Console Sensor 2 generates expected sensor data. 
 * @author Deline Zent
 */
class Sensors2Test {

    ConsoleSensor s2;
    
    /**
     * Set up the test environment for each individual test; create the sensor suite
     * and use the initialize method.
     */
    @BeforeEach
    void setUp() {
        s2 = new Sensors2();
        s2.Initialize();
    }
    
    /**
     * Pressure should always return -1.
     */
    @Test
    void testPressure() {
        double testVal = s2.pressure();
        assertTrue(testVal == -1);
    }
    
    /**
     * Windchill should always return -1.
     */
    @Test
    void testWindChill() {
        double testVal = s2.windchill();
        assertTrue(testVal == -1);
    }
    
    /**
     * Tests if a new pseudo-random rainfall is generated.
     */
    @Test
    void testRainFall() {
        boolean differentValues = false;
        double val1 = s2.rainFall();
        double val2 = s2.rainFall();
        for (int i = 0; i < 5; i++) {
            if (val1 != val2) {
                differentValues = true;
                break;
            }
            val1 = s2.rainFall();
            val2 = s2.rainFall();
        }
        assertTrue(differentValues);
    }
    
    /**
     * Rainrate should always return -1.
     */
    @Test
    void testRainRate() {
        double testVal = s2.rainRate();
        assertTrue(testVal == -1);
    }
    
    /**
     * Tests if a new pseudo-random outside humidity is generated.
     */
    @Test
    void testHumOut() {
        boolean differentValues = false;
        double val1 = s2.humOut();
        double val2 = s2.humOut();
        for (int i = 0; i < 5; i++) {
            if (val1 != val2) {
                differentValues = true;
                break;
            }
            val1 = s2.humOut();
            val2 = s2.humOut();
        }
        assertTrue(differentValues);
    }
    
    /**
     * Tests if a new pseudo-random inside humidity is generated.
     */
    @Test
    void testHumIn() {
        boolean differentValues = false;
        double val1 = s2.humIn();
        double val2 = s2.humIn();
        for (int i = 0; i < 5; i++) {
            if (val1 != val2) {
                differentValues = true;
                break;
            }
            val1 = s2.humIn();
            val2 = s2.humIn();
        }
        assertTrue(differentValues); 
    }
        
    /**
     * Tests if a new pseudo-random inside temp is generated.
     */
    @Test
    void testTempIn() {
        boolean differentValues = false;
        double val1 = s2.tempIn();
        double val2 = s2.tempIn();
        for (int i = 0; i < 5; i++) {
            if (val1 != val2) {
                differentValues = true;
                break;
            }
            val1 = s2.tempIn();
            val2 = s2.tempIn();
        }
        assertTrue(differentValues); 
    }
    
    /**
     * Tests if a new pseudo-random outside temp is generated.
     */
    @Test
    void testTempOut() {
        boolean differentValues = false;
        double val1 = s2.tempOut();
        double val2 = s2.tempOut();
        for (int i = 0; i < 5; i++) {
            if (val1 != val2) {
                differentValues = true;
                break;
            }
            val1 = s2.tempOut();
            val2 = s2.tempOut();
        }
        assertTrue(differentValues); 
    }
    
    /**
     * Tests if a new pseudo-random wind direction is generated and
     * that is must be >=0 and <=360.
     */
    @Test
    void testWindDir() {
        boolean differentValues = false;
        boolean withinRange = true;
        double val1 = s2.windDirection();
        double val2 = s2.windDirection();
        for (int i = 0; i < 5; i++) {
            if (val1 != val2) {
                differentValues = true;
            }
            if (val1 > 360 || val1 < 0 || val2 > 360 || val2 < 0) {
                withinRange = false;
            }
            val1 = s2.windDirection();
            val2 = s2.windDirection();
        }
        assertTrue(differentValues); 
        assertTrue(withinRange); 
    }
    
    /**
     * Tests if a new pseudo-random wind temp is generated.
     */
    @Test
    void testWindSpeed() {
        boolean differentValues = false;
        double val1 = s2.windSpeed();
        double val2 = s2.windSpeed();
        for (int i = 0; i < 5; i++) {
            if (val1 != val2) {
                differentValues = true;
                break;
            }
            val1 = s2.windSpeed();
            val2 = s2.windSpeed();
        }
        assertTrue(differentValues); 
    }
}
