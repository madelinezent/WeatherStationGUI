/*
 * An interface specifying the base functionality for the
 * weather data point hierarchy.
 */

package WeatherData;

/**
 * Specifies base functionality for classes that represent
 * weather data points.
 * @author Spencer Little
 * @version 0.0.0
 */
public interface WDataPoint {
    /** Add a data point from the sensor to the cumulative total tracked by the object. */
    void addDataPoint(double point);
}
