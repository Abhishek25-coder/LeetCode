class Solution {
    static boolean isSafetoPlace(int rowIndex,int colIndex,int n, char[][] board){
    //chech left horizontal
    int row = rowIndex;
    int col = colIndex;

    while(col >= 0){
        if(board[row][col] == 'Q'){
            return false;
        }
            col--;
        }
        //check left upper diagonal
        row = rowIndex;
        col = colIndex;

        while(row>=0 && col>=0){
            if(board[row][col] == 'Q'){
                return false;
            }
            row = row-1;
            col = col-1; 
        }
        //check left lower diagonal
        row = rowIndex;
        col = colIndex;

        while(row < n && col>=0){
            if(board[row][col] == 'Q'){
                return false;
            }
            row = row+1;
            col = col-1; 
        }
        //else
        return true;
    }

    static void solve(char[][] board,int n,int colIndex,List<List<String>> ans){
        if(colIndex >= n){
            //ans list me store krdo
            List<String> temp = new ArrayList<>();
            for(int i = 0;i<n;i++){
                temp.add(new String(board[i]));
            }
            ans.add(temp);
            return;
        }
        //recursive case
        for(int rowIndex=0;rowIndex<n;rowIndex++){
            if(isSafetoPlace(rowIndex,colIndex,n,board)){
                //place queen
                board[rowIndex][colIndex] = 'Q';
                //baki recursion kr lega
                solve(board,n,colIndex+1,ans);
                //backtracking
                board[rowIndex][colIndex] = '.';
            }
        }
    }
    public List<List<String>> solveNQueens(int n) {
        char[][] board = new char[n][n];
        for(int i=0;i<n;i++){
            Arrays.fill(board[i],'.');
        }
        List<List<String>> ans = new ArrayList<>();
        int colIndex = 0;
        solve(board,n,colIndex,ans);
        return ans;
    }
}