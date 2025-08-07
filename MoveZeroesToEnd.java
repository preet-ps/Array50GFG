// Question Link : https://leetcode.com/problems/move-zeroes/description/
import java.util.Arrays;
public class MoveZeroesToEnd {
    public static void main(String[] args) {
        int[] nums = {0,1,0,3,12};
        moveZeroes(nums);
        moveZeroes1(new int[]{0,1,0,3,12});
        moveZeroes2(new int[]{1, 2, 0, 4, 3, 0, 5, 0});
    }

    // Naive Approach :  Traversing the array and putting the non-zero elements first in the temp[] and then putting the zero-elements
    // later. Time Complexity : O(N), Space Complexity : O(N)

    public static void moveZeroes(int[] nums) {
        int n = nums.length;
        int[] temp = new int[n];
        int index = 0 ;

        for(int i = 0 ; i < n ; i++){
            if(nums[i] != 0){
                temp[index++] = nums[i];
            }
        }

        while(index < n){
            temp[index++] = 0;
        }

        for(int i = 0 ; i < n ; i++){
            nums[i] = temp[i];
        }
        System.out.println(Arrays.toString(nums));;
    }


    // Better Approach : Two Traversals in the array. Keep a track of the non-zero elements with a count variable. Rearrange
    // the non-zero values at the count index. This way , we will be able to put all the non-zeroes at the first but the values will
    // be overwritten. And then put all the zeroes later.
    // Time Complexity : O(N), Space Complexity : O(1)

    public static void moveZeroes1(int[] nums) {
        int count = 0, n = nums.length;

        for(int i = 0 ; i < n ; i++){
            if(nums[i] != 0){
                nums[count++] = nums[i];
            }
        }

        while(count < n){
            nums[count++] = 0;
        }
        System.out.println(Arrays.toString(nums));
    }

    // Expected : Traversing the array just once and putting all the non-zero elements at the count index (swapping). This way all
    // the non-zero elements at the first and zeroes will eventually move to the end.
    // Time Complexity : O(N), Space Complexity : O(1)

    public static void moveZeroes2(int[] nums) {
        int count = 0, n = nums.length;

        for(int i = 0 ; i < n ; i++){

            if(nums[i] != 0){

                int temp = nums[i];
                nums[i] = nums[count];
                nums[count] = temp;

                count++;
            }
        }

        System.out.println(Arrays.toString(nums));
    }

}
