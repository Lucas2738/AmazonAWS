import java.util.ArrayList;
import java.util.List;

public class MergeSort {
    List<Integer> numbers;


    public List<Integer> execute(){
        return step(numbers);
    }


    public List<Integer> step(List<Integer> numbers){

        if(numbers.size() <= 1){
            return numbers;
        }

        List<Integer> merged = new ArrayList<>();

        int middle = Math.abs(numbers.size()/2);
        List<Integer> left = numbers.subList(0, middle);
        List<Integer> right = numbers.subList(middle, numbers.size());

        left = step(left);
        right = step(right);


        int i = 0;
        int j = 0;
        while(i < left.size() && j < right.size()){
            if(left.get(i) < right.get(j)){
                merged.add(left.get(i));
                i++;
                continue;
            }else{
                merged.add(right.get(j));
                j++;
                continue;
            }
        }

        if(i < left.size()){
            merged.addAll(left.subList(i, left.size()));
        }else if(j < right.size()){
            merged.addAll(right.subList(j, right.size()));
        }

        return merged;
    }


    public void init(List<Integer> numbers){
        this.numbers = numbers;
    }
}
