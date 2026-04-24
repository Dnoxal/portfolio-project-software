import components.linearregression.LinearRegression;
import components.linearregression.LinearRegression1L;

/**
 * Simple demo of the LinearRegression component.
 */
public final class LinearRegressionDemo {

    /**
     * Private constructor so this utility class cannot be instantiated.
     */
    private LinearRegressionDemo() {

    }

    /**
     * Demonstrates basic use of the LinearRegression component.
     *
     * @param args
     *            command-line arguments
     */
    public static void main(String[] args) {
        LinearRegression model = new LinearRegression1L();

        model.addDataPoint(1.0, 2.0);
        model.addDataPoint(2.0, 4.0);
        model.addDataPoint(3.0, 6.0);
        model.addDataPoint(4.0, 8.0);

        System.out.println("Linear Regression Demo");
        System.out.println("----------------------");
        System.out.println("Number of points: " + model.size());
        System.out.println("Can fit line: " + model.canFit());
        System.out.println("Sum X: " + model.sumX());
        System.out.println("Sum Y: " + model.sumY());
        System.out.println("Sum XX: " + model.sumXX());
        System.out.println("Sum YY: " + model.sumYY());
        System.out.println("Sum XY: " + model.sumXY());

        if (model.canFit()) {
            System.out.println("Slope: " + model.slope());
            System.out.println("Intercept: " + model.intercept());
            System.out.println("Correlation: " + model.correlation());
            System.out.println("Prediction at x = 5.0: " + model.predict(5.0));
        }
    }
}