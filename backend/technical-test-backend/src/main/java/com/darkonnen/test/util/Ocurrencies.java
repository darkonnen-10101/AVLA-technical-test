package com.darkonnen.test.util;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;

public class Ocurrencies {

	public static void countFrequencies(ArrayList<String> list) {

		Map<String, Integer> hm = new HashMap<String, Integer>();

		for (String i : list) {
			Integer j = hm.get(i);
			hm.put(i, (j == null) ? 1 : j + 1);
		}
		hm.remove("");

		List<Entry<String, Integer>> valueList = new LinkedList<Entry<String, Integer>>(hm.entrySet());

		Collections.sort(valueList, new Comparator<Entry<String, Integer>>() {
			public int compare(Entry<String, Integer> o1, Entry<String, Integer> o2){
				return o1.getValue().compareTo(o2.getValue());
			}
		});
		
		
		for(Entry<String, Integer> value: valueList) {
			System.out.println(value);
		}

	}
}
