package com.matrix;

import org.junit.Test;

import static org.junit.Assert.*;

public class MatrixTest {
  @Test
  public void shouldCheckIfTwoReferencesAreSame() {
    int[][] elements1 = {{1, 2}, {3, 4}};
    Matrix matrix1 = new Matrix(elements1, 2, 2);

    assertTrue(matrix1.equals(matrix1));
  }

  @Test
  public void shouldCheckIfTwoMatricesAreOfSameInstance() {
    int[][] elements1 = {{1, 2}, {3, 4}};
    Matrix matrix1 = new Matrix(elements1, 2, 2);

    assertFalse(matrix1.equals(elements1));
  }

  @Test
  public void shouldCheckIfTwoMatricesHaveSameDimensions() {
    int[][] elements1 = {{1, 2}, {3, 4}};
    Matrix matrix1 = new Matrix(elements1, 2, 2);

    int[][] elements2 = {{1, 2, 3}, {4, 5, 6}, {7, 8, 9}};
    Matrix matrix2 = new Matrix(elements2, 3, 3);

    assertFalse(matrix1.equals(matrix2));
  }

  @Test
  public void shouldNotEqualTwoMatricesWhenAtLeastOneElementIsDifferent() {
    int[][] elements1 = {{1, 2}, {3, 4}};
    Matrix matrix1 = new Matrix(elements1, 2, 2);

    int[][] elements2 = {{1, 2}, {3, 5}};
    Matrix matrix2 = new Matrix(elements2, 2, 2);

    assertFalse(matrix1.equals(matrix2));
  }

  @Test
  public void shouldEqualTwoMatricesWhenAllElementsAreSame() {
    int[][] elements1 = {{1, 2}, {3, 4}};
    Matrix matrix1 = new Matrix(elements1, 2, 2);

    int[][] elements2 = {{1, 2}, {3, 4}};
    Matrix matrix2 = new Matrix(elements2, 2, 2);

    assertTrue(matrix1.equals(matrix2));
  }

  @Test
  public void shouldAddTwoMatricesOfSameOrder() {
    int[][] elements1 = {{1, 2}, {3, 4}};
    Matrix matrix1 = new Matrix(elements1, 2, 2);

    int[][] elements2 = {{2, 4}, {6, 8}};
    Matrix matrix2 = new Matrix(elements2, 2, 2);

    int[][] elements3 = {{3, 6}, {9, 12}};
    Matrix expected = new Matrix(elements3, 2, 2);

    Matrix actual = matrix1.add(matrix2);

    assertEquals(expected, actual);
  }

  @Test
  public void shouldSubtractTwoMatricesOfSameOrder() {
    int[][] elements1 = { { 4, 8 }, { 12, 16 } };
    Matrix matrix1 = new Matrix(elements1, 2, 2);

    int[][] elements2 = { { 1, 2 }, { 3, 4 } };
    Matrix matrix2 = new Matrix(elements2, 2, 2);

    int[][] elements3 = { { 3, 6 }, { 9, 12 } };
    Matrix expected = new Matrix(elements3, 2, 2);

    Matrix actual = matrix1.subtract(matrix2);

    assertEquals(expected, actual);
  }

}
