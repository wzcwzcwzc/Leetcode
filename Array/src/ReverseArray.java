public class ReverseArray {

    public static void main(String[] args) {
        int[] arr = new int[]{1,2,3 ,4, 5};
        ReverseArray r = new ReverseArray();
        int[] b = r.reverse(arr);
        for(int i  = 0; i < b.length; i++){
            System.out.println(b[i]);
        }

    }

    public int[] reverse(int[] arr){
        for(int i = 0; i < arr.length / 2; i++){
            int temp = arr[arr.length - i - 1];
            arr[arr.length - i - 1] = arr[i];
            arr[i] = temp;
        }

        return arr;
    }
}
