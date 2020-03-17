public class splitInteger {

    public static void main(String[] args) {
        int n = 1023;
        //if we want to split n and calculate sum of each bit
        int sum = 0;
        while(n != 0){
            sum = sum + n % 10;
            n = n / 10;
        }

        System.out.println(sum);
    }
}
