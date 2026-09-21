class Solution {
    static boolean findemptycell(char[][]board, int[] emptycell){
         for(int i =0;i<9;i++){
            for(int j=0;j<9;j++){
                 if(board[i][j] == '.'){
                    //store empty cell ki row
                    emptycell[0] = i;
                    //store empty cell ka col
                    emptycell[1] = j;
                    return true;
                 }
            }
         }
         //kahi par bhi empty cell nhi mila
         return false;
    }
    static boolean isSafetoPlace(char[][] board,char charvalue,int rowIndex,int colIndex){
         //check for horizontal or same row
            //rowIndex same rahega
            //colIndex 0 se 9 rahega
        for(int col=0;col<9;col++){
            if(board[rowIndex][col] == charvalue){
                return false;
            }
        }
         //check for vertical or same column
           //colIndex same rahgea
           //rowIndex 0 se 9 rahega
        for(int row=0;row<9;row++){
            if(board[row][colIndex] == charvalue){
                return false;
            }
        }
         //check for 3*3 sub box
        int startrow = rowIndex - rowIndex%3;
        int startcol = colIndex - colIndex%3;

        //travel over 3*3 sub box
        for(int i=0;i<3;i++){
            for(int j=0;j<3;j++){
                int actualrow = startrow + i;
                int actualcol = startcol + j;
                if(board[actualrow][actualcol] == charvalue){
                    return false;
                }
            }
        }
        //iska mtlb safe to place h
        return true; 
    }
    static boolean solveSudokuSolver(char[][] board){
        //base case
        //jab sare empty space fill ho jayenge
        int[] emptycell = new int[2];
        if(!findemptycell(board,emptycell)){
            return true;
        }
        //agar empty cell mil gya
        int rowIndex = emptycell[0];
        int colIndex = emptycell[1];
        
        for(int value=1;value<=9;value++){
            char charvalue = (char)(value + '0');
            if(isSafetoPlace(board,charvalue,rowIndex,colIndex)){
            //place krdo
            board[rowIndex][colIndex] = charvalue;
            //baaki recursion sambhal lega
            if(solveSudokuSolver(board)== true){
            return true;
            }
            //agar recursion solve nhi kr paya or wapas aagya
            //currrent value ko undo kro
            board[rowIndex][colIndex] = '.';
        }
    }
    //agar solve nhi hua
    return false;
    }
    public void solveSudoku(char[][] board) {
        solveSudokuSolver(board);
    }
}