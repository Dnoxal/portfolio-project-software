/**
 * Secondary methods for LinearRegression.
 */
public abstract class LinearRegressionSecondary implements LinearRegression {

    @Override
    public final double slope() {
        double n = this.size();
        double numerator = n * this.sumXY() - this.sumX() * this.sumY();
        double denominator = n * this.sumXX() - this.sumX() * this.sumX();

        return numerator / denominator;
    }

    @Override
    public final double intercept() {
        double n = this.size();
        return (this.sumY() - this.slope() * this.sumX()) / n;
    }

    @Override
    public final double predict(double x) {
        return this.slope() * x + this.intercept();
    }

    @Override
    public final double correlation() {
        double n = this.size();
        double numerator = n * this.sumXY() - this.sumX() * this.sumY();
        double left = n * this.sumXX() - this.sumX() * this.sumX();
        double right = n * this.sumYY() - this.sumY() * this.sumY();

        return numerator / Math.sqrt(left * right);
    }

    /*
     * I excluded methods such as equals, hashCode, and toString b/c this
     * assignment focuses on implementing the enhanced methods, and these common
     * methods are not needed to respect the stated kernel or enhanced method
     * contracts.
     */
}