package alogorithm.problems;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Problem3 {

    public static void main(String args[]){
        Problem3 p3 = new Problem3();
        int array[] = {2,3,4,5,6};
        System.out.println(p3.generalizedGCD(5, array));
    }

    public int generalizedGCD(int num, int[] arr)
    {

        int min = -1;
        for(int i = 0; i < num; i++){
            if(arr[i] < min || min == -1){
                min = arr[i];
            }
        }

        int gcd = -1;
        for(int i = min; i >=1 ; i--){
            gcd = i;
            for(int j = 0; j < num; j++){
                if(arr[j]%gcd != 0){
                    gcd = -1;
                    break;
                }
            }
            if(gcd > -1){
                break;
            }
        }

        return gcd;
        // WRITE YOUR CODE HERE
    }
}
