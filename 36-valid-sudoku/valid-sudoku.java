class Solution {
    public boolean isValidSudoku(char[][] board) {

        // check every cell
        for(int row = 0; row < 9; row++) {
            for(int col = 0; col < 9; col++) {

                if(board[row][col] == '.') {
                    continue;
                }

                char value = board[row][col];

                // Check same row
                for(int j = 0; j < 9; j++) {
                    if(j != col && board[row][j] == value) {
                        return false;
                    }
                }

                // Check same column
                for(int i = 0; i < 9; i++) {
                    if(i != row && board[i][col] == value) {
                        return false;
                    }
                }

                // Check 3 x 3 box
                int startRow = row - row % 3;
                int startCol = col - col % 3;

                for(int i = startRow; i < startRow + 3; i++) {
                    for(int j = startCol; j < startCol + 3; j++) {

                        if((i != row || j != col) &&
                           board[i][j] == value) {
                            return false;
                        }
                    }
                }
            }
        }

        return true;
    }
}