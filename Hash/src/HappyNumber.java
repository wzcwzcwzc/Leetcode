import java.util.HashSet;
import java.util.Set;

public class HappyNumber {

    public boolean isHappy(int n) {

        //use hashset to store all kinds result

        //when we get same value stored in set, if it is not equal to 1, which means it will not be happy number

        if(n == 1) return true;

        Set<Integer> set = new HashSet<>();
        int sum = sumOfPower(n);
        //divide n into sum of power
        while(!set.contains(sum)){
            set.add(sum);
            sum = sumOfPower(sum);
        }
        //if we find there is sum in set, we need to compare it with 1
        if(sum == 1){
            return true;
        }

        return false;
    }
    //calculate sum of power
    public int sumOfPower(int n){
        int sum = 0;
        while(n != 0){
            sum = sum + (n % 10)^2;
            n = n / 10;
        }

        return sum;
    }
}
