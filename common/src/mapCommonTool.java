import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

public class mapCommonTool {

    public static void main(String[] args) {
        Map<String, Integer> map = new HashMap<>();
        map.put("wang", 1);
        map.put("kkk", 10);
        map.put("weq", 8);

        for(Map.Entry<String, Integer> entry : map.entrySet()){
            System.out.println(entry.getKey() + " " + entry.getValue());
        }

        //more efficient
        Iterator<Map.Entry<String, Integer>> iterator = map.entrySet().iterator();
        while(iterator.hasNext()){
            Map.Entry<String, Integer> entry = iterator.next();
            entry.getKey();
            entry.getValue();
        }

        for(String key : map.keySet()){
            map.get(key);
        }

        map.remove("wang");
        System.out.println(map.containsValue(1));
    }


}
