package alogorithm.sorting;

import java.util.*;
import static java.util.Map.*;
import static java.util.AbstractMap.*;

public class BucketSort {
    private static final int BUCKET_NUM = 10;
    List<Integer> numbers;
    List<Integer> result = new ArrayList<>();

    public List<Integer> execute(){
        step(numbers);
        return result;
    }

    private void step(List<Integer> nums){
        List<Entry<Integer, List<Integer>>> buckets;

        int bucketNums = BUCKET_NUM;
        if(nums.size() >= bucketNums) {
            buckets = buildBucket(nums, BUCKET_NUM);
        }else if(nums.size() == 1){
            result.add(nums.get(0));
            return;
        }else{
            buckets = buildBucket(nums, nums.size()/2);
        }

        for (Integer num : nums) {
            Integer key = -1;
            int k = -1;
            int i = buckets.size()-1;
            while(i>=0){
                Map.Entry<Integer, List<Integer>> b = buckets.get(i);
                if(num <= b.getKey()){
                    key = b.getKey();
                    k = i;
                }
                i--;
            }
            if(key != -1){
                buckets.get(k).getValue().add(num);
            }
        }

        for(int i = 0; i<buckets.size(); i++){
            Entry<Integer, List<Integer>> b = buckets.get(i);
            step(b.getValue());
        }

        return;
    }

    private List<Entry<Integer, List<Integer>>> buildBucket(List<Integer> nums, int bucketNums){
        List<Entry<Integer, List<Integer>>> buckets = new ArrayList<>();

        if(nums != null && nums.size() > 0) {
            int max = Integer.MIN_VALUE;
            for (Integer num : nums) {
                if (num > max) {
                    max = num;
                }
            }
            int min = Integer.MAX_VALUE;
            for (Integer num : nums) {
                if (num < min) {
                    min = num;
                }
            }
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
