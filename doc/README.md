# Linear Regression Component

This repository contains a Java component for building and using a simple least-squares linear regression model. The component stores a collection of data points indirectly through running totals, then uses those totals to compute slope, intercept, predictions, and correlation.

## Component Overview

The component follows the OSU CSE component structure:

- `LinearRegressionKernel.java`: kernel interface containing primary methods such as adding points and reporting running totals
- `LinearRegression.java`: enhanced interface containing secondary regression operations
- `LinearRegressionSecondary.java`: abstract class implementing secondary methods
- `LinearRegression1L.java`: kernel implementation using running sums as the representation

## Main Features

- Add `(x, y)` data points
- Track count and running sums
- Determine whether a regression line can be fit
- Compute slope and y-intercept
- Predict a y-value from an x-value
- Compute correlation coefficient
- Reset or transfer component state using Standard methods

## Directory Structure

```text
src/
  README.md
  LinearRegressionDemo.java
  StudyHoursPredictor.java
  components/linearregression/
    LinearRegression.java
    LinearRegressionKernel.java
    LinearRegressionSecondary.java
    LinearRegression1L.java

test/
  README.md
  components/linearregression/
    LinearRegressionTest.java
    LinearRegression1LTest.java
```

## Use Cases

This component includes two example use cases:

1. `LinearRegressionDemo.java`, which demonstrates direct use of the component by adding points and printing regression results.
2. `StudyHoursPredictor.java`, which wraps the component in a small application that predicts exam scores from study hours.

## Testing

JUnit tests are provided for both the kernel implementation and secondary methods. The test suite covers constructors, kernel methods, Standard methods, secondary methods, edge cases, decimal values, negative values, and state preservation.

## Notes

This project was built as a portfolio component using OSU CSE design principles, including interfaces, an abstract secondary class, a kernel implementation, method contracts, and representation documentation.
