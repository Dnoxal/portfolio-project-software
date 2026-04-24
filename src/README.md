# Source Files

This folder contains the source code for the Linear Regression component and its example use cases.

## Component Files

The main component is stored in `components/linearregression/`.

- `LinearRegressionKernel.java` defines the kernel methods for storing data points and reporting running totals.
- `LinearRegression.java` extends the kernel interface with secondary regression methods.
- `LinearRegressionSecondary.java` implements the secondary methods using the kernel methods.
- `LinearRegression1L.java` provides the concrete representation using running sums.

## Example Use Cases

This folder also includes two sample applications that demonstrate how the component can be used.

### LinearRegressionDemo.java

This file shows direct use of the component. It creates a regression model, adds several points, and prints the stored totals and computed regression values.

### StudyHoursPredictor.java

This file shows a more specific application of the component. It uses linear regression to model the relationship between study hours and exam scores, then predicts a score for a new number of study hours.

## Design Notes

The implementation follows the OSU CSE component pattern:

- Kernel methods store and expose the minimal state needed for the model.
- Secondary methods are implemented once in the abstract class.
- The concrete class maintains the representation and implements Standard methods.
