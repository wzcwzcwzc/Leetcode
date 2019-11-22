public class isPrime {

    public static int isPrime(int n){
        int count = 0;
        //建立数组去存储所有的数据
        boolean[] b = new boolean[n + 1];
        for(int k = 0; k < n; k++){
            b[k] = true;
        }

        //从2开始计算，凡事2的倍数均不是素数
        for(int i = 2; i <= Math.sqrt(n); i++){

            if(b[i]){
                for(int k = i*i; k < n; k+=i){
                    b[k] = false;
                }
            }
        }

        for(int j = 2; j < b.length; j++){
            if(b[j]){
                count++;
            }
        }

        return count;

    }
}
