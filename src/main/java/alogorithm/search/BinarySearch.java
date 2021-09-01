package alogorithm.search;

import java.util.List;
/**
 *  O(log|N|)
 * */
public class BinarySearch {

    public static Integer execute(Integer num, List<Integer> nums){
        int inf = 0;
        int sup = nums.size();
        int i;
        while(true){
            i = (sup+inf)/2;
            int current = nums.get(i);
            if(current < num){
                inf = i;
            }else if (current > num){
                sup = i;
            }else {
                return i;
            }
        }
    }

}
