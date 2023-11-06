// Design 8-Queens matrix having first Queen placed. Use backtracking to place remaining Queens to generate the final 8-queens matrix.


public class NQueens {
    public static void printSolution(int[][] board) {
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board.length; j++) {
                System.out.print(board[i][j] + " ");
            }
            System.out.println();
        }
    }

    public static boolean isSafe(int[][] board, int row, int col) {
        int i, j;

        // Check the row on the left side
        for (i = 0; i < col; i++) {
            if (board[row][i] == 1) {
                return false;
            }
        }

        // Check upper diagonal on the left side
        for (i = row, j = col; i >= 0 && j >= 0; i--, j--) {
            if (board[i][j] == 1) {
                return false;
            }
        }

        // Check lower diagonal on the left side
        for (i = row, j = col; i < board.length && j >= 0; i++, j--) {
            if (board[i][j] == 1) {
                return false;
            }
        }

        return true;
    }

    public static boolean solveNQueensUtil(int[][] board, int col) {
        int N = board.length;
        if (col >= N) {
            return true;
        }

        // Try placing this Queen in all rows one by one
        for (int i = 0; i < N; i++) {
            if (isSafe(board, i, col)) {
                board[i][col] = 1;
                if (solveNQueensUtil(board, col + 1)) {
                    return true;
                }
                board[i][col] = 0; // Backtrack
            }
        }

        return false;
    }

    public static boolean solveNQueens(int[][] board, int firstQueenRow) {
        int N = board.length;
        if (N != 8) {
            System.out.println("This solution is for 8-Queens. Please specify N=8.");
            return false;
        }
        board[firstQueenRow][0] = 1;

        if (solveNQueensUtil(board, 1) == false) {
            System.out.println("Solution does not exist.");
            return false;
        }

        printSolution(board);
        return true;
    }

    public static void main(String[] args) {
        int N = 8;
        int[][] board = new int[N][N];

        // Specify the row for the first Queen (0-7)
        int firstQueenRow = 0;

        if (solveNQueens(board, firstQueenRow)) {
            System.out.println("Solution found!");
        } else {
            System.out.println("Solution not found.");
        }
    }
}


// Time Complexity:
// The time complexity is mainly determined by the backtracking algorithm, which explores different possibilities. In the worst case, the backtracking algorithm examines all possible placements of the remaining Queens. The time complexity can be expressed as O(N!), where 'N' is the size of the board, which is 8 in this case. It's important to note that this problem has a factorial time complexity, making it computationally expensive for larger board sizes.

// Space Complexity:
// The space complexity is primarily determined by the 2D board used to represent the chessboard. The space complexity is O(N^2), where 'N' is the size of the board (8 in this case). The additional space used by the recursive call stack during backtracking is also O(N) for the depth of the recursion.
