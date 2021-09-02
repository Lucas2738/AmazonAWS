package alogorithm.sorting;

import java.util.*;
import static java.util.Map.*;
import static java.util.AbstractMap.*;

public class BucketSort {
    private static final int BUCKET_NUM = 60;
    List<Integer> numbers;
    List<Integer> result = new ArrayList<>();

    public List<Integer> execute(){
        return step(numbers);
    }

    private List<Integer> step(List<Integer> nums){
        List<Entry<Integer, List<Integer>>> buckets;
        int max = Integer.MIN_VALUE;
        for (Integer n : nums) {
            if (n > max) {
                max = n;
            }
        }
        int min = Integer.MAX_VALUE;
        for (Integer n : nums) {
            if (n < min) {
                min = n;
            }
        }
        int bucketNums = BUCKET_NUM;
        if(nums.size() >= bucketNums) {
            buckets = buildBucket(nums, BUCKET_NUM, min, max);
        }else if(nums.size() == 1){
            result.add(nums.get(0));
            return result;
        }else{
            bucketNums = nums.size()/2;
            buckets = buildBucket(nums, nums.size()/2, min, max);
        }

        for (Integer num : nums) {
            int i = num / (max / bucketNums);
            if(i >= buckets.size()){
                i = buckets.size() - 1;
            }
            buckets.get(i).getValue().add(num);

        }

        for(int i = 0; i < buckets.size(); i++){
            Entry<Integer, List<Integer>> b = buckets.get(i);
            step(b.getValue());
        }

        return result;
    }

    private List<Entry<Integer, List<Integer>>> buildBucket(List<Integer> nums, int bucketNums, int min, int max){
        List<Entry<Integer, List<Integer>>> buckets = new ArrayList<>();

        if(nums != null && nums.size() > 0) {
            for (int i = 0; i < bucketNums; i++) {
                buckets.add(new SimpleEntry<>(min + (max - min) / bucketNums * i, new ArrayList<>()));
            }
            buckets.add(new SimpleEntry<>(max, new ArrayList<>()));
        }
        return buckets;
    }


    public void init(List<Integer> numbers){
        this.numbers = numbers;
    }

}
