import java.util.*;

class Solution {
    public int[][] diagonalSort(int[][] mat) {

        int m = mat.length;
        int n = mat[0].length;

        HashMap<Integer, PriorityQueue<Integer>> map = new HashMap<>();

        // Store diagonal elements
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {

                int key = i - j;

                map.putIfAbsent(key, new PriorityQueue<>());
                map.get(key).offer(mat[i][j]);
            }
        }

        // Fill matrix with sorted values
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {

                int key = i - j;
                mat[i][j] = map.get(key).poll();
            }
        }

        return mat;
    }
}