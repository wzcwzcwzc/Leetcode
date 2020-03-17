import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class SolveNQueens {

    public List<List<String>> solveNQueens(int n){

        List<List<String>> list = new LinkedList<>();
        //queen[] index is the row and the value of queen[row] is the column
        int[] queen = new int[n];
        solve(list, queen, 0, n);
        return list;
    }

    public void solve(List<List<String>> list, int[] queen, int row, int n){
        if(row == n){
            // 找到了一个解决方案，将解决方案保存
            save(list, queen);
        }else{
            for(int i = 0; i < n; i++){
                if(canPlace(row, i, queen)){
                    //queen's position is (row, i)
                    queen[row] = i;
                    solve(list, queen, row + 1, n);
                    // 此处不需要return是因为如果找不到解，i++, 这一层的row并没有变化，只是换个column试
                    // 并将结果存放到queen数组中
                    // 在第一轮循环中，queen[1]从2变成了3， 相当于将原本行1列2的皇后取消，变成行1列3了
                    // 等价于实行了backtrack，只不过此处的backtrack = backtrack + put into new position
                }
            }
        }
    }


    //output the result

    public void save(List<List<String>> list, int[] queen){
        int n = queen.length;
        List<String> temp = new LinkedList<>();
        for(int i = 0; i < n; i++){
            String str = "";
            for(int j = 0; j < n; j++){
                //position is (i, j)
                if(queen[i] == j){
                    str = str + 'Q';
                }else{
                    str = str + '.';
                }
            }
            temp.add(str);
        }
        list.add(new LinkedList<>(temp));
    }

    // <1, 1>
    public boolean canPlace(int row, int col, int[] queen){
        int left = col - 1;
        int right = col + 1;
        int n = queen.length;
        for(int i = row - 1; i >= 0; i--){
            //col is the same
            if(queen[i] == col) {
                return false;
            }

            //col == left
            if(left >= 0 && queen[i] == left) {
                return false;
            }

            //col == right, examine the diagonal
            if(right < n && queen[i] == right) {
                return false;
            }

            left--;
            right++;
        }
        return true;
    }

    public static void main(String[] args) {
        SolveNQueens s = new SolveNQueens();
        List<List<String>> ans = s.solveNQueens(4);

        for(int i = 0; i < ans.size(); i++){
            System.out.println(ans.get(i));
        }
    }

}