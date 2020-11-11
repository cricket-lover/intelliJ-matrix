package com.matrix;

public class Matrix {
  private final int[][] elements;
  private final int numOfRows;
  private final int numOfCols;

  public Matrix(int[][] elements, int numOfRows, int numOfCols) {
    this.elements = elements;
    this.numOfRows = numOfRows;
    this.numOfCols = numOfCols;
  }

  @Override
  public boolean equals(Object other) {
    if (this == other) {
      return true;
    }

    if (!(other instanceof Matrix)) {
      return false;
    }

    Matrix another = (Matrix) other;

    if (areDimensionsNotEqual(another)) {
      return false;
    }

    return areElementsEqual(another);
  }

  private boolean areDimensionsNotEqual(Matrix another) {
    return (this.numOfRows != another.numOfRows) || (this.numOfCols != another.numOfCols);
  }

  private boolean areElementsEqual(Matrix another) {
    for (int row = 0; row < this.numOfRows; row++) {
      for (int column = 0; column < this.numOfCols; column++) {
        if (this.elements[row][column] != another.elements[row][column]) {
          return false;
        }
      }
    }

    return true;
  }

  public Matrix add(Matrix other) {
    int[][] elements = new int[this.numOfRows][this.numOfCols];

    for (int row = 0; row < this.numOfRows; row++) {
      for (int column = 0; column < this.numOfCols; column++) {
        int sum = this.elements[row][column] + other.elements[row][column];
        elements[row][column] = sum;
      }
    }

    return new Matrix(elements, this.numOfRows, this.numOfCols);
  }

  public Matrix subtract(Matrix other) {
    int[][] elements = new int[this.numOfRows][this.numOfCols];

    for (int row = 0; row < this.numOfRows; row++) {
      for (int column = 0; column < this.numOfCols; column++) {
        int diff = this.elements[row][column] - other.elements[row][column];
        elements[row][column] = diff;
      }
    }

    return new Matrix(elements, this.numOfRows, this.numOfCols);
  }
}
