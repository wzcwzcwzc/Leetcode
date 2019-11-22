public class Sort {

    public static int[] bubbleSort(int[] arr){

        for(int i = 0; i < arr.length; i++){
            for(int j = i + 1; j < arr.length; j++){
                if(arr[i] > arr[j]){
                    int temp = arr[i];
                    arr[i] = arr[j];
                    arr[j] = temp;
                }
            }
        }
        return arr;

    }

    public static int[] insertionSort(int[] arr){
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

    public static void main(String[] args) {
        Sort s = new Sort();
        int[] arr = new int[]{1,3,2,4};

        s.insertionSort(arr);

        for(int i = 0; i < arr.length; i++){
            System.out.println(arr[i]);
        }
    }
}
