// Question Link : https://leetcode.com/problems/max-consecutive-ones/description/
public class MaxConsecutiveOnes {
    public static void main(String[] args) {
        System.out.println(maxConsecBits(new int[] {0, 1, 0, 1, 1, 1, 1}));
    }

    // Traversing the array and counting ones till a zero occurs updating the maxCount for the same
    // Time Complexity : O(N) Space Complexity : O(N)
    public static int maxConsecBits(int[] arr) {
        int count = 0, maxOnes = 0;

        for(int i : arr){
            if(i == 1) count++;
            else{
                maxOnes = Math.max(count,maxOnes);
                count = 0;
            }
        }
        return Math.max(count, maxOnes);
    }
}
