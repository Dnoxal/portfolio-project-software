package components.linearregression;

/**
 * Secondary methods for LinearRegression.
 */
public abstract class LinearRegressionSecondary implements LinearRegression {

    @Override
    public final double slope() {
        assert this.canFit() : "Violation of: this can fit a regression line";

        double n = this.size();
        double numerator = n * this.sumXY() - this.sumX() * this.sumY();
        double denominator = n * this.sumXX() - this.sumX() * this.sumX();

        double result = numerator / denominator;
        return result;
    }

    @Override
    public final double intercept() {
        assert this.canFit() : "Violation of: this can fit a regression line";

        double n = this.size();
        double result = (this.sumY() - this.slope() * this.sumX()) / n;
        return result;
    }

    @Override
    public final double predict(double x) {
        assert this.canFit() : "Violation of: this can fit a regression line";

        double result = this.slope() * x + this.intercept();
        return result;
    }

    @Override
    public final double correlation() {
        assert this.canFit() : "Violation of: this can fit a regression line";

        double n = this.size();
        double numerator = n * this.sumXY() - this.sumX() * this.sumY();
        double left = n * this.sumXX() - this.sumX() * this.sumX();
        double right = n * this.sumYY() - this.sumY() * this.sumY();

        double result = numerator / Math.sqrt(left * right);
        return result;
    }
}