/**
 * linear regression component proof-of-concept.
 *
 * performs simple linear regression by tracking running sums only.
 *
 */
public final class LinearRegression {

    // possible representation: counts + running sums
    private int n;
    private double sumX;
    private double sumY;
    private double sumXX;
    private double sumXY;
    private double sumYY; // optional, used for rSquared

    // kernel methods

    public void clear() {
        this.n = 0;
        this.sumX = 0.0;
        this.sumY = 0.0;
        this.sumXX = 0.0;
        this.sumXY = 0.0;
        this.sumYY = 0.0;
    }

    public void addPoint(double x, double y) {
        this.n++;
        this.sumX += x;
        this.sumY += y;
        this.sumXX += x * x;
        this.sumXY += x * y;
        this.sumYY += y * y;
    }

    public int size() {
        return this.n;
    }

    public double sumX() {
        return this.sumX;
    }

    public double sumY() {
        return this.sumY;
    }

    public double sumXX() {
        return this.sumXX;
    }

    public double sumXY() {
        return this.sumXY;
    }

    // secondary methods

    /**
     * slope a in y = a x + b
     */
    public double slope() {
        //need to implement error catching later cause need 2 points and
        // denom. needs to something thats not 0
        double denom = this.n * this.sumXX - this.sumX * this.sumX;
        return (this.n * this.sumXY - this.sumX * this.sumY) / denom;
    }

    /**
     * intercept b in y = a x + b
     */
    public double intercept() {

        // need two points, error catching needed
        return (this.sumY - this.slope() * this.sumX) / this.n;
    }

    public double predict(double x) {
        return this.slope() * x + this.intercept();
    }

    /**
     * r^2 for simple linear regression.
     */
    public double rSquared() {
        // need 2 points, sxx cant be zero, need error catching
        double sxx = this.sumXX - (this.sumX * this.sumX) / this.n;
        double syy = this.sumYY - (this.sumY * this.sumY) / this.n;
        double sxy = this.sumXY - (this.sumX * this.sumY) / this.n;

        if (syy == 0.0) {
            // all y identical, perfect fit in the sense of no variance
            return 1.0;
        }

        double r = sxy / Math.sqrt(sxx * syy);
        return r * r;
    }

    // demo

    public static void main(String[] args) {
        LinearRegression lr = new LinearRegression();
        lr.clear();

        // example points roughly on y = 2x + 1
        lr.addPoint(1, 3);
        lr.addPoint(2, 5);
        lr.addPoint(3, 7);
        lr.addPoint(4, 9);

        System.out.println("n = " + lr.size());
        System.out.println("sumX = " + lr.sumX());
        System.out.println("sumY = " + lr.sumY());
        System.out.println("sumXX = " + lr.sumXX());
        System.out.println("sumXY = " + lr.sumXY());

        System.out.println("slope a = " + lr.slope());
        System.out.println("intercept b = " + lr.intercept());
        System.out.println("predict(5) = " + lr.predict(5));
        System.out.println("rSquared = " + lr.rSquared());
    }
}