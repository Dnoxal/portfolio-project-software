import components.standard.Standard;

/**
 * Kernel interface for a LinearRegression component.
 */
public interface LinearRegressionKernel extends Standard<LinearRegression> {

    /**
     * Adds the point (x, y) to this regression model.
     *
     * @param x
     *            the x-coordinate of the data point
     * @param y
     *            the y-coordinate of the data point
     * @updates this
     * @ensures this contains all entries of #this and the point (x, y)
     */
    void addDataPoint(double x, double y);

    /**
     * Reports the number of data points stored in this regression model.
     *
     * @return the number of stored data points
     * @ensures size = number of data points in this
     */
    int size();

    /**
     * Reports whether this regression model contains enough data to compute a
     * regression line.
     *
     * @return true iff this contains at least two data points
     * @ensures canFit = (size >= 2)
     */
    boolean canFit();
}