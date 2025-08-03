import java.util.Arrays;

// Question Link : https://www.geeksforgeeks.org/problems/three-great-candidates0515/1
// Leetcode : https://leetcode.com/problems/maximum-product-of-three-numbers/description/
//Code

public class ThreeGreatestCandidates {
    public static void main(String[] args) {
        System.out.println(maxProduct(new int[]{-10, -3, 5, 6, -20}));
    }

    // Naive Approach : Using 3 nested loops. Checking every possible triplet
    // Time Complexity : O(n^3) Space Complexity : O(1)

    static int maxProduct(int[] nums){

        int maxPrdt = Integer.MIN_VALUE, n = nums.length;

        for(int i = 0 ; i < n-2 ; i++){
            for(int j = i + 1 ; j < n-1 ; j++){
                for(int k = j+1 ; k < n ; k++){
                    maxPrdt = Math.max(maxPrdt, nums[i]*nums[j]*nums[k]);
                }
            }
        }
        return maxPrdt;
    }

    // Better Approach : Sort the array and then return the maximum of first 3 numbers and the last 3 numbers
    // Time Complexity : O(n*(log(n)) Space Complexity : O(1)

    static int maxProduct1(int[] nums){

        int n = nums.length;
        Arrays.sort(nums);

        return Math.max(nums[0]*nums[1]*nums[n-1], nums[n-1]*nums[n-2]*nums[n-3]);
    }

    // Scan the array and compute the first, second and third maximum and compute the maximum product for positive ones
    // Scan the array for first and second minimum and multiply it by the max to obtain the maximum product
    // Return the maximum out of 2
    // Time Complexity : O(N) Space Complexity : O(1)

    static int maxProduct2(int[] nums){

        int max1 = Integer.MIN_VALUE, max2 = Integer.MIN_VALUE, max3 = Integer.MIN_VALUE;
        int min1 = Integer.MAX_VALUE, min2 = Integer.MAX_VALUE;

        for(int num :  nums){

            if(num > max1){
                max3 = max2 ;
                max2 = max1;
                max1 = num;
            }else if(num > max2){
                max3 = max2 ;
                max2 = num;
            }else if(num > max3){
                max3 = num;
            }

            if(num < min1){
                min2 = min1;
                min1 = num;
            }else if(num < min2){
                min2 = min1;
            }
        }
        return Math.max(max1*max2*max3, min1*min2*max1);
    }
}
