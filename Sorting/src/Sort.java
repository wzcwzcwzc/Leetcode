public class Sort {

    public static int[] bubbleSort(int[] arr){

        for(int i = 1; i < arr.length; i++){
            boolean flag = true;
            for(int j = 0; j < arr.length - i; j++){
                // 可以设置一个boolean来优化
                if(arr[j] > arr[j + 1]){
                    int temp = arr[j];
                    arr[j] = arr[j + 1];
                    arr[j + 1] = temp;
                    flag = false;
                }
            }
            if(flag){
                break;
            }
        }
        return arr;
    }

    public int[] insertionSort(int[] arr){
        int temp = 0;

        for(int j = 1; j < arr.length; j++){
            temp = arr[j];
            int i = j - 1;
            while(i >= 0 && arr[i] > temp){
                arr[i+1] = arr[i];
                i--;
            }
            arr[i+1] = temp;
        }
        return arr;
    }

    public int[] selectionSort(int[] arr){

        for(int i = 0; i < arr.length - 1; i++){

            int minIndex = i;
            for(int j = i + 1; j < arr.length; j++) {
                if (arr[j] < arr[minIndex]) {
                    minIndex = j;
                }
            }
            //find smallest one in each loop and then exchange
            int temp = arr[minIndex];
            arr[minIndex] = arr[i];
            arr[i] = temp;
        }
        return arr;
    }


        //填坑法与交换法
        //1 24 3 17 8 20
        //填坑法
        public int partition(int[] arr, int left, int right) {
            //将arr[left]的值存储到了temp里，那么arr[left]就相当于一个坑没有值了
            int temp = arr[left];
            int i = left;
            int j = right;

            while(i < j) {
                while(arr[j] >= temp && i < j) {
                    j--;
                }
                arr[i] = arr[j];

                while(arr[i] < temp && i < j) {
                    i++;
                }

                arr[j] = arr[i];
            }

            arr[i] = temp;

            return i;
        }

        public void quickSort(int[] arr, int left, int right) {
            if(left > right) {
                return;
            }

            int mid = partition(arr, left, right);
            quickSort(arr, left, mid - 1);
            quickSort(arr, mid + 1, right);
        }

    public static void main(String[] args) {

        int[] arr = {29, 81, 68, 43, 65, 45, 69, 78, 81, -1, 72, 88, 99, 95, 24, 77, 52};
        Sort qk = new Sort();
        int[] arrr = {1, 4, 5};
        qk.quickSort(arrr, 0, arrr.length - 1);

//        qk.insertionSort(arr);

        for(int i = 0; i < arrr.length; i++) {
            System.out.print(" " + arrr[i]);
        }

    }
}
