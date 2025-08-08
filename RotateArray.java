public class RotateArray {
    public static void main(String[] args) {
        int[] arr = { 1, 2, 3, 4, 5, 6 };
        int d = 2;

        rotateArr(arr, d);

        for (int i = 0; i < arr.length; i++)
            System.out.print(arr[i] + " ");
    }

    // Naive Approach : Shifting the elements one position to the left and repeating the process n no of times.
    // Time Complexity : O(n*d) , Space Complexity : O(1)

    static void rotateArr(int[] arr, int d){

        int n = arr.length;

        for(int i = 0 ; i < d ; i++){

            int first = arr[0];
            for(int j = 0 ; j < n-1 ; j++){
                arr[j] = arr[j+1];
            }
            arr[n-1] = first;
        }

    }
}
