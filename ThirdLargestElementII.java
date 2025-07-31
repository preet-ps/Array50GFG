//Question Link : https://leetcode.com/problems/third-maximum-number/description/
import java.util.Arrays;
public class ThirdLargestElementII {
    public static void main(String[] args) {
        System.out.println(thirdMax(new int[]{2,3,1,6,7}));
    }

    public static int thirdMax(int[] nums){

        long firstMax = Long.MIN_VALUE;
        long secondMax = Long.MIN_VALUE;
        long thirdMax = Long.MIN_VALUE;

        for(int num :  nums){
            if(num == firstMax || num == secondMax || num == thirdMax) continue;

            if(num >  firstMax){
                thirdMax = secondMax;
                secondMax = firstMax ;
                firstMax = num;
            }else if( num > secondMax){
                thirdMax = secondMax;
                secondMax = num;
            }else if(num > thirdMax){
                thirdMax = num;
            }
        }
        return (thirdMax == Long.MIN_VALUE) ? (int)firstMax : (int)thirdMax;
    }

}
