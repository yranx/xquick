package com.ranx.chowder.jees;

import java.util.*;

/**
 * Map遍历
 * @author ranx
 * @create 2019-07-03 19:02
 **/
public class TraMap {
    public static void main(String[] args) {
        Map map  = new HashMap();
        for (int i=0; i<9; i++) {
            map.put(String.valueOf(i), "value"+i);
        }
        tra(map);
        traByKeySet(map);
        traByEntry(map);
        traByentryFor(map);
    }

    public static void tra(Map<String, String> map) {
        Collection<String> c = map.values();
        Iterator it = c.iterator();
        for (; it.hasNext(); ) {
            System.out.println(it.next());
        }
    }

    public static void traByKeySet(Map<String, String> map) {
        Set<String> key = map.keySet();
        for (Iterator it = key.iterator(); it.hasNext(); ) {
            String s= (String) it.next();
            System.out.println(map.get(s));
        }
    }

    public static void traByEntry(Map<String, String> map) {
        Set<Map.Entry<String, String>> set = map.entrySet();
        for (Iterator<Map.Entry<String, String >> it = set.iterator(); it.hasNext(); ) {
            Map.Entry<String, String> entry = (Map.Entry<String, String>) it.next();
            System.out.println(entry.getKey() + "->" + entry.getValue());
        }
}

    public static void traByentryFor(Map<String, String> map) {
        Set<Map.Entry<String, String>> set = map.entrySet();
        for (Map.Entry<String, String> me : set ) {
            System.out.println(me.getKey() + "->" + me.getValue());
        }
    }
}
