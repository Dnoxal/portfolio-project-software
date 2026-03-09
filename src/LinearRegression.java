/**
 * Enhanced interface for a LinearRegression component.
 */
public interface LinearRegression extends LinearRegressionKernel {

    /**
     * Computes the slope of the least-squares regression line for this model.
     *
     * @return the slope of the regression line
     * @requires this.canFit()
     * @ensures slope = slope of the least-squares regression line for this
     */
    double slope();

    /**
     * Computes the y-intercept of the least-squares regression line.
     *
     * @return the y-intercept of the regression line
     * @requires this.canFit()
     * @ensures intercept = y-intercept of the regression line for this
     */
    double intercept();

    /**
     * Predicts the y-value corresponding to the given x-value using the
     * regression line.
     *
     * @param x
     *            the x-value for prediction
     * @return the predicted y-value
     * @requires this.canFit()
     * @ensures predict = predicted y-value for x using this regression model
     */
    double predict(double x);

    /**
     * Computes the correlation coefficient for the stored data.
     *
     * @return the correlation coefficient
     * @requires this.canFit()
     * @ensures correlation = correlation coefficient of the data in this
     */
    double correlation();
}