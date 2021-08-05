package alogorithm.problems;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Problem2 {

    public static void main(String args[]){
        Problem2 p2 = new Problem2();
        int array[] = {1,0,0,0,0,1,0,0};
        System.out.println(p2.cellCompete(array,1));
    }

    public List<Integer> cellCompete(int[] states, int days) {
        List<Integer> result = new ArrayList<>();
        try {
            for (int i = 0; i < states.length; i++) {
                result.add(states[i]);
            }

            for (int i = 0; i < days; i++) {
                List<Integer> app = new ArrayList<>();
                app.add(update(Arrays.asList(result.get(1)), true, false));
                for (int j = 1; j < result.size() - 1; j++) {
                    app.add(update(Arrays.asList(result.get(j - 1), result.get(j + 1)), false, false));
                }
                app.add(update(Arrays.asList(result.get(result.size() - 2)), true, false));
                result =  new ArrayList<>();
                result.addAll(app);
            }
        }catch(Exception e){
            System.out.println("ERROR");
        }
        return  result;
    }

    public int update(List<Integer> sub, boolean isStart, boolean isEnd) throws Exception {
        int result;

        int left;
        int right;

        if(isStart && isEnd){
            throw new Exception("Cannot be either starto and end");
        }else if(!isStart && !isEnd){
            if(sub.size() != 2){
                throw new Exception("Middle value must has 3 elements");
            }
            left = sub.get(0);
            right = sub.get(1);
        }else if(isStart){
            if(sub.size() != 1){
                throw new Exception("Starting value must has 2 elements");
            }
            left = 0;
            right = sub.get(0);
        }else {
            if(sub.size() != 1){
                throw new Exception("Ending value must has 2 elements");
            }
            left = sub.get(0);
            right = 0;
        }

        if(left == right){
            result = 0;
        }else{
            result = 1;
        }

        return result;
    }
}
