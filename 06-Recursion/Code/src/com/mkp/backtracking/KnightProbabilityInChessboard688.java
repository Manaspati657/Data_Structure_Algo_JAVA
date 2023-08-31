package src.com.mkp.backtracking;

public class KnightProbabilityInChessboard688 {
    public static void main(String[] args) {
        int b = 3 ,k=2;
        boolean[][] board = new boolean[b][b];
        System.out.println(knight(board, 0, 0, k));
    }

    private static int knight(boolean[][] board, int row, int col, int knights) {
        if(knights == 0 ){
            display(board);
            System.out.println();
            return 1;
        }

        if(row == board.length-1 && col == board.length){
            return 1;
        }

        if(col == board.length){
            knight(board,row+1,0,knights);
            return 1;
        }

        int count =0;
        if(isSafe(board,row,col)){
//            System.out.println(row+"-"+col);
            board[row][col]=true;
            count +=knight(board,row,col+1,knights-1);
//            board[row][col]=false;
        }
        count += knight(board,row,col+1,knights);
       return count;
    }

    private static boolean isSafe(boolean[][] board, int row, int col) {
        if( isValid(board,row-1,col-2) && board[row-1][col-2]) return false;
        if( isValid(board,row-1,col+2) && board[row-1][col+2]) return false;
        if( isValid(board,row-2,col+1) && board[row-2][col+1]) return false;
        if( isValid(board,row-2,col-1) && board[row-2][col-1]) return false;

        if( isValid(board,row+1,col-2) && board[row+1][col-2]) return false;
        if( isValid(board,row+1,col+2) && board[row+1][col+2]) return false;
        if( isValid(board,row+2,col+1) && board[row+2][col+1]) return false;
        if( isValid(board,row+2,col-1) && board[row+2][col-1]) return false;
        return true;
    }

    static boolean isValid(boolean[][] board, int row, int col) {
        if (row >= 0 && row < board.length && col >= 0 && col < board.length) {
            return true;
        }
        return false;
    }


    private static void display(boolean[][] board) {
        for(boolean[] row : board) {
            for(boolean element : row) {
                if (element) {
                    System.out.print("K ");
                } else {
                    System.out.print("0 ");
                }
            }
            System.out.println();
        }
    }
}
