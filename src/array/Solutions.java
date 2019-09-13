import java.util.ArrayList;
import java.util.List;

class Solutions {
    // Spiral Matrix
    // Idea: 4 variables to keep track of corners of matrix
    // Example: [
    //              [1, 2, 3],
    //              [4, 5, 6],
    //              [7, 8, 9]
    //          ]
    //  Output: [1, 2, 3, 6, 9, 8, 7, 4, 1, 5]
    public static List<Integer> spiralOrder(int[][] matrix) {
        if (matrix.length == 0) {
            return new ArrayList<Integer>();
        }
        int uL = 0, uR = matrix[0].length - 1, lR = matrix.length - 1, lL = matrix.length - 1;
        List<Integer> sol = new ArrayList<>();

        while (uL < uR && uL < lR) {
            for (int i = uL; i < uR; i++) {
                sol.add(matrix[uL][i]);
            }
            for (int i = uL; i < lR; i++) {
                sol.add(matrix[i][uR]);
            }
            for (int i = uR; i > uL; i--) {
                sol.add(matrix[lR][i]);
            }
            for (int i = lL; i > uL; i--) {
                sol.add(matrix[i][uL]);
            }
            uL++;
            uR--;
            lR--;
            lL--;
        }
        // Half spiral for vertical matrix
        if (uL == uR) {
            for (int i = uL; i <= lR; i++) {
                sol.add(matrix[i][uL]);
            }
        }
        if (uL == lR && uL != uR) {
            for (int i = uL; i <= uR; i++) {
                sol.add(matrix[uL][i]);
            }
        }
        return sol;
    }

    public static void main(String[] args) {
        int[][] test = {
            {1, 2, 3},
            {4, 5, 6},
            {7, 8, 9}
        };
        System.out.println(spiralOrder(test));
    }
}
