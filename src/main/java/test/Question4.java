package test;

import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Question4 {

    private HashMap<Integer, Integer> sourceMap =  new HashMap<>();
    private List<Integer> source;
    private Integer target;

    public static void main(String[] args){

    }

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
