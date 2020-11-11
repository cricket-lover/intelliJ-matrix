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
        elements[row][column] = this.elements[row][column] + other.elements[row][column];
      }
    }

    return new Matrix(elements, this.numOfRows, this.numOfCols);
  }

  public Matrix subtract(Matrix other) {
    int[][] elements = new int[this.numOfRows][this.numOfCols];

    for (int row = 0; row < this.numOfRows; row++) {
      for (int column = 0; column < this.numOfCols; column++) {
        elements[row][column] = this.elements[row][column] - other.elements[row][column];
      }
    }

    return new Matrix(elements, this.numOfRows, this.numOfCols);
  }

  public Matrix multiply(Matrix other) {
    int[][] elements = new int[this.numOfRows][other.numOfCols];

    for (int row = 0; row < this.numOfRows; row++) {
      for (int col = 0; col < other.numOfCols; col++) {
        for (int index = 0; index < this.numOfCols; index++) {
          elements[row][col] += this.elements[row][index] * other.elements[index][col];
        }
      }
    }

    return new Matrix(elements, this.numOfRows, other.numOfCols);
  }

  private Matrix createSubMatrix(int mainColId) {
    int[][] subElements = new int[this.numOfRows - 1][this.numOfCols - 1];

    for (int row = 1; row < this.numOfRows; row++) {
      for (int column = 0; column < mainColId; column++) {
        subElements[row - 1][column] = this.elements[row][column];
      }

      for (int column = mainColId + 1; column < this.numOfCols; column++) {
        subElements[row - 1][column - 1] = this.elements[row][column];
      }
    }

    return new Matrix(subElements, this.numOfRows - 1, this.numOfCols - 1);
  }


  public int getDeterminant() {
    if (this.numOfRows == 1) {
      return this.elements[0][0];
    }

    if (this.numOfRows == 2) {
      return (this.elements[0][0] * this.elements[1][1]) - (this.elements[0][1] * this.elements[1][0]);
    }

    int determinant = 0;

    for (int mainColId = 0; mainColId < this.numOfCols; mainColId++) {
      Matrix subMatrix = createSubMatrix(mainColId);

      int sign = (int) Math.pow(-1, mainColId);
      determinant += sign * this.elements[0][mainColId] * subMatrix.getDeterminant();
    }

    return determinant;
  }
}
