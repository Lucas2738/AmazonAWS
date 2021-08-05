package test;

import java.util.*;

public class Question1 {

    private HashMap<Integer, Integer> sourceMap =  new HashMap<>();
    private List<Integer> source;
    private Integer target;

    public static void main(String[] args){
        List<String> logs =  new ArrayList<>();
        logs.add("1 2 50");
        logs.add("1 7 70");
        logs.add("1 3 20");
        logs.add("2 2 17");
        System.out.println(processLogs(logs, 2));
    }


    public static List<String> processLogs(List<String> logs, int threshold) {
        List<String> result =  new ArrayList<>();

        HashMap<String, Integer> map = new HashMap<>();
        logs.forEach(l ->{
            String sender = l.charAt(0) + "";
            String receiver = l.charAt(2) + "";

            if(sender == receiver){
                if(map.get(sender) != null){
                    map.put(sender, map.get(sender) + 1);
                }else{
                    map.put(sender, 0);
                }
            }else {
                if (map.get(sender) != null) {
                    map.put(sender, map.get(sender) + 1);
                } else {
                    map.put(sender, 0);
                }

                if (map.get(receiver) != null) {
                    map.put(receiver, map.get(receiver) + 1);
                } else {
                    map.put(receiver, 0);
                }
            }
        });

        map.forEach((s, c) -> {
            if(c >= threshold){
                result.add(s);
            }
        });

        return result;
    }


}
