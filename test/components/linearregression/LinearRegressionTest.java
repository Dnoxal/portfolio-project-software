package components.linearregression;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

/**
 * JUnit tests for LinearRegression secondary methods.
 */
public final class LinearRegressionTest {

    /**
     * Returns a LinearRegression with the given points added in order.
     *
     * @param points
     *            alternating x, y values
     * @return regression containing the given points
     * @requires points.length is even
     * @ensures createRegressionFromPoints = regression containing the given
     *          points
     */
    private static LinearRegression createRegressionFromPoints(
            double... points) {
        assert points.length % 2 == 0 : "Violation of: points.length is even";

        LinearRegression result = new LinearRegression1L();
        for (int i = 0; i < points.length; i += 2) {
            result.addDataPoint(points[i], points[i + 1]);
        }
        return result;
    }

    @Test
    public void testSlopePerfectPositiveLine() {
        LinearRegression r = createRegressionFromPoints(1.0, 2.0, 2.0, 4.0, 3.0,
                6.0);

        assertEquals(2.0, r.slope(), 0.000001);

        assertEquals(3, r.size());
        assertEquals(6.0, r.sumX(), 0.000001);
        assertEquals(12.0, r.sumY(), 0.000001);
        assertEquals(14.0, r.sumXX(), 0.000001);
        assertEquals(56.0, r.sumYY(), 0.000001);
        assertEquals(28.0, r.sumXY(), 0.000001);
    }

    @Test
    public void testSlopePerfectNegativeLine() {
        LinearRegression r = createRegressionFromPoints(1.0, 5.0, 2.0, 3.0, 3.0,
                1.0);

        assertEquals(-2.0, r.slope(), 0.000001);

        assertEquals(3, r.size());
        assertEquals(6.0, r.sumX(), 0.000001);
        assertEquals(9.0, r.sumY(), 0.000001);
    }

    @Test
    public void testInterceptPerfectPositiveLine() {
        LinearRegression r = createRegressionFromPoints(1.0, 3.0, 2.0, 5.0, 3.0,
                7.0);

        assertEquals(1.0, r.intercept(), 0.000001);

        assertEquals(3, r.size());
        assertEquals(6.0, r.sumX(), 0.000001);
        assertEquals(15.0, r.sumY(), 0.000001);
    }

    @Test
    public void testPredictPerfectLine() {
        LinearRegression r = createRegressionFromPoints(1.0, 3.0, 2.0, 5.0, 3.0,
                7.0);

        assertEquals(9.0, r.predict(4.0), 0.000001);

        assertEquals(3, r.size());
        assertEquals(6.0, r.sumX(), 0.000001);
        assertEquals(15.0, r.sumY(), 0.000001);
    }

    @Test
    public void testPredictDecimalInput() {
        LinearRegression r = createRegressionFromPoints(1.0, 1.0, 2.0, 3.0, 3.0,
                5.0);

        assertEquals(8.0, r.predict(4.5), 0.000001);
    }

    @Test
    public void testCorrelationPerfectPositive() {
        LinearRegression r = createRegressionFromPoints(1.0, 2.0, 2.0, 4.0, 3.0,
                6.0);

        assertEquals(1.0, r.correlation(), 0.000001);

        assertEquals(3, r.size());
        assertEquals(6.0, r.sumX(), 0.000001);
        assertEquals(12.0, r.sumY(), 0.000001);
    }

    @Test
    public void testCorrelationPerfectNegative() {
        LinearRegression r = createRegressionFromPoints(1.0, 5.0, 2.0, 3.0, 3.0,
                1.0);

        assertEquals(-1.0, r.correlation(), 0.000001);

        assertEquals(3, r.size());
        assertEquals(6.0, r.sumX(), 0.000001);
        assertEquals(9.0, r.sumY(), 0.000001);
    }

    @Test
    public void testSecondaryMethodsWithMixedPoints() {
        LinearRegression r = createRegressionFromPoints(1.0, 2.0, 2.0, 5.0, 4.0,
                8.0);

        assertEquals(1.9285714285714286, r.slope(), 0.000001);
        assertEquals(0.5, r.intercept(), 0.000001);
        assertEquals(6.285714285714286, r.predict(3.0), 0.000001);
        assertEquals(0.9819805061, r.correlation(), 0.000001);

        assertEquals(3, r.size());
        assertEquals(7.0, r.sumX(), 0.000001);
        assertEquals(15.0, r.sumY(), 0.000001);
        assertEquals(21.0, r.sumXX(), 0.000001);
        assertEquals(93.0, r.sumYY(), 0.000001);
        assertEquals(44.0, r.sumXY(), 0.000001);
    }
}