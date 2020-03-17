public class SolveSudoku {

    private char[] cc = {'1', '2', '3', '4', '5', '6', '7', '8', '9'};
    private char[][] bd;

    public void solveSudoku(char[][] board) {
        this.bd = board;
        //  we need to traverse whole matrix, if there is empty, we can put a
        // value into it by puting (1,2,3...9), if valid
        // recursion to solve it, if cannot solve, we need to backtrack to previous
        // condition board[row][col] need to go back to empty.
        solve();
    }

    // todo there is a bug in return part

    public void solve(){
        for(int i = 0; i < bd.length; i++){
            for(int j = 0; j < bd[0].length; j++){
                if(bd[i][j] == '.'){
                    // try all the solution
                    for(int k = 0; k < 9; k++){
                        if(canPlace(i, j, cc[k])){
                            bd[i][j] = cc[k];
                            solve();
                            // after try all 1-9 and cannot solve
                            // do backtrack and return
                            bd[i][j] = '.';
                        }
                    }
                    return;
                }

            }
        }

    }
    //1. boolean canPlace(int num, int row, int col)
    //2. traverse and put element
    // if cannot solve, go back to last position
    // can place

    public boolean canPlace(int row, int col, char value){
        // 1. the whole row is valid
        for(int j = 0; j < bd[0].length; j++){
            if(bd[row][j] == value){
                return false;
            }
        }

        // 2. the whole column is valid
        for(int i = 0; i < bd.length; i++){
            if(bd[i][col] == value){
                return false;
            }
        }

        // 3. sub-boxes is valid
        int x0 = (col / 3) * 3;
        int y0 = (row / 3) * 3;
        for(int i = 0; i < 3; i++){
            for(int j = 0; j < 3; j++){
                if(bd[x0+i][y0+j] == value){
                    return false;
                }
            }
        }
        return true;
    }

    public static void main(String[] args) {
        char[][] c = {
                {'5','3','.','.','7','.','.','.','.'},
                {'6','.','.','1','9','5','.','.','.'},
                {'.','9','8','.','.','.','.','6','.'},
                {'8','.','.','.','6','.','.','.','3'},
                {'4','.','.','8','.','3','.','.','1'},
                {'7','.','.','.','2','.','.','.','6'},
                {'.','6','.','.','.','.','2','8','.'},
                {'.','.','.','4','1','9','.','.','5'},
                {'7','.','.','.','8','.','.','7','9'}};
        SolveSudoku s = new SolveSudoku();
        s.solveSudoku(c);
    }
}
