package com.matrix;

public class Matrix {
    private final int[][] elemets;
    private final int numOfRows;
    private final int numOfCols;

    public Matrix(int[][] elemets, int numOfRows, int numOfCols) {
        this.elemets = elemets;
        this.numOfRows = numOfRows;
        this.numOfCols = numOfCols;
    }

    @Override
    public boolean equals(Object other) {
        if(this == other){
            return  true;
        }

        return  false;
    }
}
