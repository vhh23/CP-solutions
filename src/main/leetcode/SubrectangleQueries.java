package main.leetcode;

class SubrectangleQueries {

    int[][] rectangle;
    int rows;
    int cols;

    public SubrectangleQueries(int[][] rectangle) {
        this.rectangle = rectangle;
        this.rows = rectangle.length;
        this.cols = rectangle[0].length;
    }

    public void updateSubrectangle(int row1, int col1, int row2, int col2, int newValue) {

        for(int i = row1;i<=row2;i++)
            for(int j = col1;j<=col2;j++){

                this.rectangle[i][j] = newValue;
            }

    }

    public int getValue(int row, int col) {
        if(row < rows && col < cols)
            return this.rectangle[row][col];

        return 0;
    }
}

/**
 * Your SubrectangleQueries object will be instantiated and called as such:
 * SubrectangleQueries obj = new SubrectangleQueries(rectangle);
 * obj.updateSubrectangle(row1,col1,row2,col2,newValue);
 * int param_2 = obj.getValue(row,col);
 */