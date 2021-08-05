package alogorithm.problems;

import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**Given an array of integers nums and an integer target, return indices of the two numbers such that they add up to target.
 *
 * You may assume that each input would have exactly one solution, and you may not use the same element twice.
 *
 * You can return the answer in any order.*/
public class Problem1 {

    private HashMap<Integer, Integer> sourceMap =  new HashMap<>();
    private List<Integer> source;
    private Integer target;

    public Set<Integer> execute(){
        Set<Integer> result = new HashSet<>();
        for(Integer i : source){
            if(i < target){
                sourceMap.putIfAbsent(i, i);
                Integer diff = target - i;

                diff = sourceMap.get(diff);
                if(diff != null){
                    result.add(i);
                    result.add(diff);
                    break;
                }
            }
            if(result.size() > 0){
                break;
            }
        }

        return result;
    }

    public void init(List<Integer> source, Integer target){
        this.source = source;
        this.target = target;
    }

}
