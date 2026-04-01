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
     * @return true iff this contains enough data to compute a regression line
     * @ensures canFit = [this contains enough data to compute a regression
     *          line]
     */
    boolean canFit();

    /**
     * Reports the sum of all x-values in this model.
     *
     * @return the sum of all x-values
     * @ensures sumX = sum of all x-values in this
     */
    double sumX();

    /**
     * Reports the sum of all y-values in this model.
     *
     * @return the sum of all y-values
     * @ensures sumY = sum of all y-values in this
     */
    double sumY();

    /**
     * Reports the sum of all squared x-values in this model.
     *
     * @return the sum of all squared x-values
     * @ensures sumXX = sum of all squared x-values in this
     */
    double sumXX();

    /**
     * Reports the sum of all squared y-values in this model.
     *
     * @return the sum of all squared y-values
     * @ensures sumYY = sum of all squared y-values in this
     */
    double sumYY();

    /**
     * Reports the sum of all products x*y in this model.
     *
     * @return the sum of all x*y products
     * @ensures sumXY = sum of all x*y products in this
     */
    double sumXY();
}