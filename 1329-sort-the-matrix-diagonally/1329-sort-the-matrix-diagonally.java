class Solution {

    public int[][] diagonalSort(int[][] mat) {

        int m = mat.length;
        int n = mat[0].length;

        // Start from first column
        for (int row = 0; row < m; row++) {
            sortDiagonal(mat, row, 0);
        }

        // Start from first row (except first element)
        for (int col = 1; col < n; col++) {
            sortDiagonal(mat, 0, col);
        }

        return mat;
    }

    private void sortDiagonal(int[][] mat, int row, int col) {

        ArrayList<Integer> list = new ArrayList<>();

        int i = row;
        int j = col;

        // Collect elements
        while (i < mat.length && j < mat[0].length) {
            list.add(mat[i][j]);
            i++;
            j++;
        }

        Collections.sort(list);

        // Put back sorted elements
        i = row;
        j = col;
        int index = 0;

        while (i < mat.length && j < mat[0].length) {
            mat[i][j] = list.get(index++);
            i++;
            j++;
        }
    }
}