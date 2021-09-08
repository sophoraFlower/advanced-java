package cn.advanced.java.example04;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

public class MapTest {

    public static void main(String[] args) {
        Map<String, String> map1 = new HashMap<String, String>();
        map1.put("key1", "value1");
        map1.put("key2", "value2");
        map1.put("key3", "value3");
        map1.put("key4", "value4");
        map1.put("key5", "value5");
        map1.put("key6", "value6");
        System.out.println(map1.get("key2"));

        // 遍历01
        for (String key : map1.keySet()) {
            System.out.println(key + ":" + map1.get(key));
        }

        // 遍历02
        for (Map.Entry<String, String> entry : map1.entrySet()) {
            System.out.println(entry.getKey() + ":" + entry.getValue());
        }

        // 遍历03
        Iterator<String> iterator = map1.keySet().iterator();
        while (iterator.hasNext()) {
            String key = iterator.next();
            System.out.println(key + ":" + map1.get(key));
        }

        // 遍历04
        Iterator<Map.Entry<String, String>> iterator2 = map1.entrySet().iterator();
        while (iterator2.hasNext()) {
            Map.Entry<String, String> entry = iterator2.next();
            System.out.println(entry.getKey() + "　：" + entry.getValue());
        }

    }

}
