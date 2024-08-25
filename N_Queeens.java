package BackTracking;
import java.util.*;
public class N_Queens {
    List<List<String>> res = new ArrayList<List<String>>();

    public List<List<String>> solveNQueens(int n) {
        char[][] board = new char[n][n];
      
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                board[i][j] = '.';
            }
        }
      
        backtrack(0, board, n);
        return res;
    }

    public void backtrack(int row, char[][] board, int n) {
      
        if (row == n) {
            List<String> temp = new ArrayList<String>();
            for (int i = 0; i < n; i++) {
                StringBuilder str = new StringBuilder();
                for (int j = 0; j < n; j++) {
                    str.append(board[i][j]);
                }
                temp.add(str.toString());
            }
            res.add(temp);
            //count++;
            return;
        }

      
        for (int j = 0; j < n; j++) {
            if (isSafe(board, row, j)) {
                board[row][j] = 'Q'; 
                backtrack(row + 1, board, n); 
                board[row][j] = '.';
            }
        }
    }

    public boolean isSafe(char[][] board, int row, int col) {
     
        for (int i = row - 1; i >= 0; i--) {
            if (board[i][col] == 'Q') return false;
        }

      
        for (int i = row - 1, j = col - 1; i >= 0 && j >= 0; i--, j--) {
            if (board[i][j] == 'Q') return false;
        }

        for (int i = row - 1, j = col + 1; i >= 0 && j < board.length; i--, j++) {
            if (board[i][j] == 'Q') return false;
        }
      
        return true;
    }
    //static int count=0;
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
      N_Queens solution = new N_Queens();
        System.out.println("enetr n");
        int n=sc.nextInt();
      
        List<List<String>> solutions = solution.solveNQueens(n);
        
        // Print all solutions
        System.out.println("Total solutions for " + n + " Queens: " + solutions.size());
        for (List<String> solutionBoard : solutions) {
            for (String row : solutionBoard) {
                System.out.println(row);
            }
            System.out.println(); // Print an empty line between different solutions
        }
        //syso(count)

    }
}
