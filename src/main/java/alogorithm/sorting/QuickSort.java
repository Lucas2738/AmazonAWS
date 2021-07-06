package alogorithm.sorting;

import java.util.ArrayList;
import java.util.List;

public class QuickSort {
    List<Integer> numbers;


    public List<Integer> execute(){
        return step(numbers);
    }


    public List<Integer> step(List<Integer> numbers){

        if(numbers.size() <= 1){
            return numbers;
        }

        int pivot = numbers.get(0);
        List<Integer> left = new ArrayList<>();
        List<Integer> right = new ArrayList<>();
        for(Integer n : numbers){
            if(n != pivot){
                if(n < pivot){
                    left.add(n);
                }else{
                    right.add(n);
                }
            }
        }

        List<Integer> res = step(left);
        res.add(pivot);
        res.addAll(step(right));

        return res;
    }

    public void init(List<Integer> numbers){
        this.numbers = numbers;
    }
}
