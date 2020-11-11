package com.matrix;

import org.junit.Test;
import org.junit.Assert;

public class MatrixTest {
    @Test
    public void shouldCheckIfTwoReferencesAreSame() {
        int[][] elements1 = {{ 1, 2 }, { 3, 4 }};
        Matrix matrix1 = new Matrix(elements1, 2,2);

        Assert.assertTrue(matrix1.equals(matrix1));
    }
}
