package tests;

import static org.junit.jupiter.api.Assertions.*;
import java.util.ArrayList;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import consoleView.Graph;

/**
 * Tests if all functionalities in the Graph class work. 
 * @author Deline Zent
 */
class GraphTest {

    Graph graph;
    ArrayList<Double> list;
    
    /**
     * Set up a new graph and a list of data before each class.
     */
    @BeforeEach
    void setUp() {
        graph = new Graph();
        list = new ArrayList<Double>();
        list.add(-5.0);
        list.add(0.0);
        list.add(4.0);
        list.add(12.0);
        list.add(28.0);
    }

    /**
     * Test if we can initialize a graph with an empty data set
     */
    @Test
    void testInitialization() {
        ArrayList<Double> data = graph.getWeatherData();
        assertTrue(data.size() == 0);
    }
    
    /**
     * Test if we can initialize a graph with a data set.
     */
    @Test
    void testInitializationWithData() {
        ArrayList<Double> data = new ArrayList<Double>();
        data.add(1.0);
        Graph dataGraph = new Graph(data, "Size");
        assertTrue(dataGraph.getWeatherData().size() == 1);
        assertTrue(dataGraph.getWeatherData().contains(1.0));
        assertEquals("Size", dataGraph.getLabel());
    }
    
    /**
     * Test if we can alter data represented on the graph. 
     */
    @Test
    void testSetData() {
        graph.setData(list);
        assertEquals(list, graph.getWeatherData());
    }
 
    /**
     * Tests if getMaxData() returns the maximum in an array list.
     */
    @Test
    void testGetMax() {
        graph.setData(list);
        assertEquals(28.0, graph.getMaxData());
    }
    
    /**
     * Tests if getMinData() returns the minimum in an array list.
     */
    @Test
    void testGetMin() {
        graph.setData(list);
        assertEquals(-5.0, graph.getMinData());
    }
    
    /**
     * Test if graph only represents the last 15 historical data
     * points in a list.
     */
    @Test
    void testLastValues() {
        ArrayList<Double> data = new ArrayList<Double>();
        for (int i = 0; i < 20; i++) {
            data.add(i, (double) i);
        }
        graph.setData(data);
        ArrayList<Double> reducedData = graph.getWeatherData();
        for (int i = 5; i < 20; i++) {
            assertEquals(data.get(i), reducedData.get(i-5));
        }
        assertEquals(15, reducedData.size());
    }
}
