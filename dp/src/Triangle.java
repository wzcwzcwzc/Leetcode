import java.util.List;

/**
* @author Barry
* */

public class Triangle {

    public int minimumTotal(List<List<Integer>> triangle) {
        // dp[][] to store each level results

        // each time we get a list out of the triangle,
        // calculate all possible solutions for each level
        // calculate index = previous index-1 , previous index

        // O(num of elements)

        // level i and index j
        // for i and j cannot be 0 or length - 1
        // triangle[i][j] = min(triangle[i-1][j-1], triangle[i-1][j])

        /*
        if(j == 0)
            triangle[i][j] = triangle[i][j] + triangle[i-1][j];
        else if(j == current_list.size() - 1)
            triangle[i][j] = triangle[i][j] + triangle[i][j-1];
        else
            triangle[i][j] = Min(triangle[i-1][j-1] + triangle[i][j], triangle[i-1][j] + triangle[i][j])

        */

        // base case
        if(triangle == null) {
            return -1;
        }
        // only have one node
        if(triangle.size() == 1) {
            // [[]]
            if(triangle.get(0).size() == 0){
                return -1;
            }else{
                return triangle.get(0).get(0);
            }
        }

        for(int i = 1; i < triangle.size(); i++){
            for(int j = 0; j < triangle.get(i).size(); j++){
                if(j == 0){
                    int temp = triangle.get(i).get(j);
                    temp += triangle.get(i-1).get(j);
                    triangle.get(i).set(j, temp);
                }else if(j == triangle.get(i).size() - 1){
                    int temp = triangle.get(i).get(j);
                    temp += triangle.get(i-1).get(j-1);
                    triangle.get(i).set(j, temp);
                }else{
                    int temp = triangle.get(i).get(j) + Math.min(triangle.get(i-1).get(j-1), triangle.get(i-1).get(j));
                    triangle.get(i).set(j, temp);
                }
            }
        }

        int res = Integer.MAX_VALUE;
        List<Integer> result = triangle.get(triangle.size() - 1);
        for(int k = 0; k < result.size(); k++){
            if(result.get(k) <= res){
                res = result.get(k);
            }
        }
        return res;
    }
}
