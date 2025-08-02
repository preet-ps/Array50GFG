// Question link : https://www.geeksforgeeks.org/problems/second-largest3735/1
import java.util.Arrays;

public class SecondLargestElement {

    public static void main(String[] args) {
        System.out.println(secondLargest(new int[]{5,4,2,1,3}));
    }


    // Brute Force : Sorting the array and then returning the last second element from the array
    // Time Complexity : O(n*log(n)) Space : O(1)

    static int secondLargest(int[] arr){
        if(arr.length == 1) return -1 ;
        Arrays.sort(arr);
        return arr[arr.length-2];
    }

    // Better : Traversing the array twice. Once to find the largest and twice to find the second largest
    // Time Complexity : O(2*n) = O(N) Space : O(1)
    static int secondLargest1(int[] arr){
        int n = arr.length;
        int largest = -1 , secondLargest = -1;

        // Finding the largest is pass 1
        for(int num :  arr){
            if(num > largest) largest = num;
        }

        // Finding the second largest in pass 2

        for(int num : arr){
            if(num > secondLargest && num < largest){
                secondLargest = num;
            }
        }

        return secondLargest;
    }

    // Expected : Finding the second largest and first largest in one pass only
    // Time Complexity : O(N) Space : O(1)
    static int secondLargest2(int[] arr){
        int n = arr.length ;
        int largest = -1, secondLargest = -1;

        for(int num : arr){
            if(num > largest){
                largest = num;
            }else if(num > secondLargest && num < largest){
                secondLargest = num;
            }
        }
        return secondLargest;
    }

}
