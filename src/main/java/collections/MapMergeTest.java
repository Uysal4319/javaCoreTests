package collections;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class MapMergeTest {

    public static void main(String[] args) {


        ArrayList<String > list1 = new ArrayList<>();
        list1.add("12345");
        list1.add("6789");

        Map<String, ArrayList<String>> map = new HashMap<>();

        map.put("list",list1);


        ArrayList<String > list2 = new ArrayList<>();
        list2.add("abcd");
        list2.add("efg");

        map.put("list",list2);

        System.out.println(map.size());
    }
}
