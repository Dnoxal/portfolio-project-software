package components.linearregression;

/**
 * LinearRegression represented by the number of data points and the running
 * sums needed for least-squares regression.
 *
 * @convention count >= 0 and if count = 0, then xSum = 0.0, ySum = 0.0, xxSum =
 *             0.0, yySum = 0.0, and xySum = 0.0
 *
 * @correspondence this represents the regression model containing some multiset
 *                 of {@code count} data points (x, y) such that: - xSum = sum
 *                 of all x-values - ySum = sum of all y-values - xxSum = sum of
 *                 all x^2-values - yySum = sum of all y^2-values - xySum = sum
 *                 of all x*y products
 */
public final class LinearRegression1L extends LinearRegressionSecondary {

    /**
     * Number of data points.
     */
    private int count;

    /**
     * Sum of all x-values.
     */
    private double xSum;

    /**
     * Sum of all y-values.
     */
    private double ySum;

    /**
     * Sum of all squared x-values.
     */
    private double xxSum;

    /**
     * Sum of all squared y-values.
     */
    private double yySum;

    /**
     * Sum of all x*y products.
     */
    private double xySum;

    /**
     * Creates a new representation.
     */
    private void createNewRep() {
        this.count = 0;
        this.xSum = 0.0;
        this.ySum = 0.0;
        this.xxSum = 0.0;
        this.yySum = 0.0;
        this.xySum = 0.0;
    }

    /**
     * No-argument constructor.
     */
    public LinearRegression1L() {
        this.createNewRep();
    }

    @Override
    public LinearRegression newInstance() {
        LinearRegression result = new LinearRegression1L();
        return result;
    }

    @Override
    public void clear() {
        this.createNewRep();
    }

    @Override
    public void transferFrom(LinearRegression source) {
        assert source != null : "Violation of: source is not null";
        assert source != this : "Violation of: source is not this";
        assert source instanceof LinearRegression1L : "Violation of: source is of dynamic type LinearRegression1L";

        LinearRegression1L localSource = (LinearRegression1L) source;

        this.count = localSource.count;
        this.xSum = localSource.xSum;
        this.ySum = localSource.ySum;
        this.xxSum = localSource.xxSum;
        this.yySum = localSource.yySum;
        this.xySum = localSource.xySum;

        localSource.createNewRep();
    }

    @Override
    public void addDataPoint(double x, double y) {
        this.count++;
        this.xSum += x;
        this.ySum += y;
        this.xxSum += x * x;
        this.yySum += y * y;
        this.xySum += x * y;
    }

    @Override
    public int size() {
        int result = this.count;
        return result;
    }

    @Override
    public boolean canFit() {
        boolean result = this.count >= 2
                && this.count * this.xxSum - this.xSum * this.xSum != 0.0;
        return result;
    }

    @Override
    public double sumX() {
        double result = this.xSum;
        return result;
    }

    @Override
    public double sumY() {
        double result = this.ySum;
        return result;
    }

    @Override
    public double sumXX() {
        double result = this.xxSum;
        return result;
    }

    @Override
    public double sumYY() {
        double result = this.yySum;
        return result;
    }

    @Override
    public double sumXY() {
        double result = this.xySum;
        return result;
    }
}