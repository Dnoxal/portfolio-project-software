package components.linearregression;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import org.junit.Test;

/**
 * JUnit tests for LinearRegression1L kernel and standard methods.
 */
public final class LinearRegression1LTest {

    /**
     * Returns a LinearRegression with the given points added in order. xs
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
    public void testConstructor() {
        LinearRegression r = new LinearRegression1L();

        assertEquals(0, r.size());
        assertEquals(false, r.canFit());
        assertEquals(0.0, r.sumX(), 0.000001);
        assertEquals(0.0, r.sumY(), 0.000001);
        assertEquals(0.0, r.sumXX(), 0.000001);
        assertEquals(0.0, r.sumYY(), 0.000001);
        assertEquals(0.0, r.sumXY(), 0.000001);
    }

    @Test
    public void testAddDataPointOnePoint() {
        LinearRegression r = new LinearRegression1L();
        r.addDataPoint(2.0, 3.0);

        assertEquals(1, r.size());
        assertEquals(false, r.canFit());
        assertEquals(2.0, r.sumX(), 0.000001);
        assertEquals(3.0, r.sumY(), 0.000001);
        assertEquals(4.0, r.sumXX(), 0.000001);
        assertEquals(9.0, r.sumYY(), 0.000001);
        assertEquals(6.0, r.sumXY(), 0.000001);
    }

    @Test
    public void testAddDataPointSeveralPoints() {
        LinearRegression r = new LinearRegression1L();
        r.addDataPoint(1.0, 2.0);
        r.addDataPoint(2.0, 4.0);
        r.addDataPoint(3.0, 6.0);

        assertEquals(3, r.size());
        assertTrue(r.canFit());
        assertEquals(6.0, r.sumX(), 0.000001);
        assertEquals(12.0, r.sumY(), 0.000001);
        assertEquals(14.0, r.sumXX(), 0.000001);
        assertEquals(56.0, r.sumYY(), 0.000001);
        assertEquals(28.0, r.sumXY(), 0.000001);
    }

    @Test
    public void testCanFitFalseWithZeroPoints() {
        LinearRegression r = new LinearRegression1L();

        assertEquals(false, r.canFit());
    }

    @Test
    public void testCanFitFalseWithOnePoint() {
        LinearRegression r = createRegressionFromPoints(5.0, 7.0);

        assertEquals(false, r.canFit());
    }

    @Test
    public void testCanFitFalseWhenAllXValuesSame() {
        LinearRegression r = createRegressionFromPoints(2.0, 1.0, 2.0, 3.0);

        assertEquals(false, r.canFit());
    }

    @Test
    public void testCanFitTrueWithTwoDistinctXValues() {
        LinearRegression r = createRegressionFromPoints(1.0, 2.0, 3.0, 4.0);

        assertEquals(true, r.canFit());
    }

    @Test
    public void testNewInstance() {
        LinearRegression r = createRegressionFromPoints(1.0, 2.0, 2.0, 4.0);

        LinearRegression fresh = r.newInstance();

        assertEquals(0, fresh.size());
        assertEquals(false, fresh.canFit());
        assertEquals(0.0, fresh.sumX(), 0.000001);
        assertEquals(0.0, fresh.sumY(), 0.000001);
        assertEquals(0.0, fresh.sumXX(), 0.000001);
        assertEquals(0.0, fresh.sumYY(), 0.000001);
        assertEquals(0.0, fresh.sumXY(), 0.000001);

        assertEquals(2, r.size());
        assertEquals(3.0, r.sumX(), 0.000001);
        assertEquals(6.0, r.sumY(), 0.000001);
    }

    @Test
    public void testClearEmpty() {
        LinearRegression r = new LinearRegression1L();
        r.clear();

        assertEquals(0, r.size());
        assertEquals(false, r.canFit());
        assertEquals(0.0, r.sumX(), 0.000001);
        assertEquals(0.0, r.sumY(), 0.000001);
        assertEquals(0.0, r.sumXX(), 0.000001);
        assertEquals(0.0, r.sumYY(), 0.000001);
        assertEquals(0.0, r.sumXY(), 0.000001);
    }

    @Test
    public void testClearNonEmpty() {
        LinearRegression r = createRegressionFromPoints(1.0, 2.0, 2.0, 4.0, 3.0,
                6.0);

        r.clear();

        assertEquals(0, r.size());
        assertEquals(false, r.canFit());
        assertEquals(0.0, r.sumX(), 0.000001);
        assertEquals(0.0, r.sumY(), 0.000001);
        assertEquals(0.0, r.sumXX(), 0.000001);
        assertEquals(0.0, r.sumYY(), 0.000001);
        assertEquals(0.0, r.sumXY(), 0.000001);
    }

    @Test
    public void testTransferFromEmptyToEmpty() {
        LinearRegression receiver = new LinearRegression1L();
        LinearRegression source = new LinearRegression1L();

        receiver.transferFrom(source);

        assertEquals(0, receiver.size());
        assertEquals(false, receiver.canFit());
        assertEquals(0.0, receiver.sumX(), 0.000001);
        assertEquals(0.0, receiver.sumY(), 0.000001);
        assertEquals(0.0, receiver.sumXX(), 0.000001);
        assertEquals(0.0, receiver.sumYY(), 0.000001);
        assertEquals(0.0, receiver.sumXY(), 0.000001);

        assertEquals(0, source.size());
        assertEquals(false, source.canFit());
        assertEquals(0.0, source.sumX(), 0.000001);
        assertEquals(0.0, source.sumY(), 0.000001);
        assertEquals(0.0, source.sumXX(), 0.000001);
        assertEquals(0.0, source.sumYY(), 0.000001);
        assertEquals(0.0, source.sumXY(), 0.000001);
    }

    @Test
    public void testTransferFromNonEmptyToEmpty() {
        LinearRegression receiver = new LinearRegression1L();
        LinearRegression source = createRegressionFromPoints(1.0, 2.0, 2.0, 4.0,
                3.0, 6.0);

        receiver.transferFrom(source);

        assertEquals(3, receiver.size());
        assertEquals(true, receiver.canFit());
        assertEquals(6.0, receiver.sumX(), 0.000001);
        assertEquals(12.0, receiver.sumY(), 0.000001);
        assertEquals(14.0, receiver.sumXX(), 0.000001);
        assertEquals(56.0, receiver.sumYY(), 0.000001);
        assertEquals(28.0, receiver.sumXY(), 0.000001);

        assertEquals(0, source.size());
        assertEquals(false, source.canFit());
        assertEquals(0.0, source.sumX(), 0.000001);
        assertEquals(0.0, source.sumY(), 0.000001);
        assertEquals(0.0, source.sumXX(), 0.000001);
        assertEquals(0.0, source.sumYY(), 0.000001);
        assertEquals(0.0, source.sumXY(), 0.000001);
    }

    @Test
    public void testTransferFromEmptyToNonEmpty() {
        LinearRegression receiver = createRegressionFromPoints(10.0, 20.0, 20.0,
                40.0);
        LinearRegression source = new LinearRegression1L();

        receiver.transferFrom(source);

        assertEquals(0, receiver.size());
        assertEquals(false, receiver.canFit());
        assertEquals(0.0, receiver.sumX(), 0.000001);
        assertEquals(0.0, receiver.sumY(), 0.000001);
        assertEquals(0.0, receiver.sumXX(), 0.000001);
        assertEquals(0.0, receiver.sumYY(), 0.000001);
        assertEquals(0.0, receiver.sumXY(), 0.000001);

        assertEquals(0, source.size());
        assertEquals(false, source.canFit());
    }

    @Test
    public void testTransferFromNonEmptyToNonEmpty() {
        LinearRegression receiver = createRegressionFromPoints(10.0, 20.0, 20.0,
                40.0);
        LinearRegression source = createRegressionFromPoints(-1.0, 5.0, 1.0,
                9.0);

        receiver.transferFrom(source);

        assertEquals(2, receiver.size());
        assertEquals(true, receiver.canFit());
        assertEquals(0.0, receiver.sumX(), 0.000001);
        assertEquals(14.0, receiver.sumY(), 0.000001);
        assertEquals(2.0, receiver.sumXX(), 0.000001);
        assertEquals(106.0, receiver.sumYY(), 0.000001);
        assertEquals(4.0, receiver.sumXY(), 0.000001);

        assertEquals(0, source.size());
        assertEquals(false, source.canFit());
        assertEquals(0.0, source.sumX(), 0.000001);
        assertEquals(0.0, source.sumY(), 0.000001);
        assertEquals(0.0, source.sumXX(), 0.000001);
        assertEquals(0.0, source.sumYY(), 0.000001);
        assertEquals(0.0, source.sumXY(), 0.000001);
    }
}