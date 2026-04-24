import components.linearregression.LinearRegression;
import components.linearregression.LinearRegression1L;

/**
 * Example application that uses LinearRegression to model the relationship
 * between study hours and exam scores.
 */
public final class StudyHoursPredictor {

    /**
     * Regression model used by this predictor.
     */
    private LinearRegression model;

    /**
     * Creates an empty StudyHoursPredictor.
     */
    public StudyHoursPredictor() {
        this.model = new LinearRegression1L();
    }

    /**
     * Adds a student record to the model.
     *
     * @param hours
     *            number of hours studied
     * @param score
     *            exam score earned
     */
    public void addStudentRecord(double hours, double score) {
        this.model.addDataPoint(hours, score);
    }

    /**
     * Reports whether a prediction can be made.
     *
     * @return true iff enough data exists to fit a regression line
     */
    public boolean canPredict() {
        boolean result = this.model.canFit();
        return result;
    }

    /**
     * Predicts the exam score for a student who studies the given number of
     * hours.
     *
     * @param hours
     *            number of hours studied
     * @return predicted exam score
     * @requires this.canPredict()
     * @ensures predictScore = predicted score for hours
     */
    public double predictScore(double hours) {
        assert this.canPredict() : "Violation of: this can predict";

        double result = this.model.predict(hours);
        return result;
    }

    /**
     * Reports the slope of the fitted regression line.
     *
     * @return slope of the fitted line
     * @requires this.canPredict()
     * @ensures slope = slope of fitted line
     */
    public double slope() {
        assert this.canPredict() : "Violation of: this can predict";

        double result = this.model.slope();
        return result;
    }

    /**
     * Reports the intercept of the fitted regression line.
     *
     * @return intercept of the fitted line
     * @requires this.canPredict()
     * @ensures intercept = intercept of fitted line
     */
    public double intercept() {
        assert this.canPredict() : "Violation of: this can predict";

        double result = this.model.intercept();
        return result;
    }

    /**
     * Reports the correlation of the stored data.
     *
     * @return correlation coefficient
     * @requires this.canPredict()
     * @ensures correlation = correlation of stored data
     */
    public double correlation() {
        assert this.canPredict() : "Violation of: this can predict";

        double result = this.model.correlation();
        return result;
    }

    /**
     * Demonstrates the StudyHoursPredictor.
     *
     * @param args
     *            command-line arguments
     */
    public static void main(String[] args) {
        StudyHoursPredictor predictor = new StudyHoursPredictor();

        predictor.addStudentRecord(2.0, 70.0);
        predictor.addStudentRecord(4.0, 78.0);
        predictor.addStudentRecord(6.0, 86.0);
        predictor.addStudentRecord(8.0, 94.0);

        System.out.println("Study Hours Predictor");
        System.out.println("---------------------");
        System.out.println("Can predict: " + predictor.canPredict());

        if (predictor.canPredict()) {
            System.out.println("Slope: " + predictor.slope());
            System.out.println("Intercept: " + predictor.intercept());
            System.out.println("Correlation: " + predictor.correlation());
            System.out.println("Predicted exam score for 5 study hours: "
                    + predictor.predictScore(5.0));
        }
    }
}