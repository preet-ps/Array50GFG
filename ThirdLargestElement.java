// Question Link : https://www.geeksforgeeks.org/problems/third-largest-element/1

import java.util.Arrays;

public class ThirdLargestElement {
    public static void main(String[] args) {
        System.out.println(thirdLargest2(new int[]{5, 3}));
    }

    // Brute Force : Sorting the array and then returning the last third element from the array
    // Time Complexity : O(n*log(n)) Space : O(1)

    static int thirdLargest(int arr[]) {
        Arrays.sort(arr);
        if (arr.length <= 2) return arr[arr.length - 1];

        return arr[arr.length - 3];
    }


    // Better : Traversing the array thrice .
    // Time Complexity :  O(3*n) = O(N) Space : O(1)

    static int thirdLargest1(int[] arr) {
        int n = arr.length;

        // Find the first maximum element.
        int first = Integer.MIN_VALUE;
        for (int i = 0; i < n; i++) {
            if (arr[i] > first) first = arr[i];
        }

        // Find the second max element.
        int second = Integer.MIN_VALUE;
        for (int i = 0; i < n; i++) {
            if (arr[i] > second && arr[i] < first) {
                second = arr[i];
            }
        }

        // Find the third-largest element.
        int third = Integer.MIN_VALUE;
        for (int i = 0; i < n; i++) {
            if (arr[i] > third && arr[i] < second) {
                third = arr[i];
            }
        }

        // Return the third-largest element
        return third;
    }

    // Expected : Using 3 variables to find the 1st, 2nd and 3rd largest element in the array in one pass.
    // Time Complexity :  O(n)  Space : O(1)

    static int thirdLargest2(int[] arr) {

        int firstMax = -1, secondMax = -1, thirdMax = -1;

        for (int num : arr) {

            if (num > firstMax) {
                thirdMax = secondMax;
                secondMax = firstMax;
                firstMax = num;

            } else if (num > secondMax && num < firstMax) {
                thirdMax = secondMax;
                secondMax = num;
            } else if (num > thirdMax && num < firstMax && num < secondMax) {
                thirdMax = num;
            }
        }
        return thirdMax;
    }
}
