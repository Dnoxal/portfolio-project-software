# Test Files

This folder contains the JUnit test suite for the Linear Regression component.

## Test Organization

The tests are split into two files:

### LinearRegression1LTest.java

This file tests the kernel implementation and Standard methods. It covers:

- Constructor behavior
- Adding one data point
- Adding several data points
- Negative and decimal data values
- `canFit()` with zero points, one point, repeated x-values, and valid data
- `newInstance()`
- `clear()`
- `transferFrom()` in empty and non-empty cases

### LinearRegressionTest.java

This file tests the secondary methods implemented in `LinearRegressionSecondary`. It covers:

- Positive slope
- Negative slope
- Decimal slope
- Positive and negative intercepts
- Prediction with whole, decimal, and negative inputs
- Positive and negative correlation
- Mixed data points that do not form a perfect line
- Verification that secondary methods do not change kernel state

## Running the Tests

Run these files as JUnit 4 tests in Eclipse or VSCode with the project libraries configured.

The expected libraries are:

- `junit-4.13.2.jar`
- `hamcrest-core-1.3.jar`
- `components.jar`

## Purpose

The goal of these tests is to show that all component methods are covered, including Standard methods, kernel methods, and secondary methods.
