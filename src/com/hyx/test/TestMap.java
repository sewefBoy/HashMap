
package com.hyx.test;

import com.hyx.map.HashMap;
import com.hyx.map.Map;

public class TestMap {
	public static void main(String[] args) {
		Map<String,Integer> map = new HashMap<String,Integer>();
		map.put("ljy", 28);
		map.put("ljy", 29);
		System.out.println(map.get("ljy"));
		System.out.println(map.size());
	}
}
