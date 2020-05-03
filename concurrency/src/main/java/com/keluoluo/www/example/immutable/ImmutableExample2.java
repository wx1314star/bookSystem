package com.keluoluo.www.example.immutable;

import java.util.Collections;
import java.util.Map;

import com.google.common.collect.Maps;
import com.keluoluo.www.annoations.ThreadSafe;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@ThreadSafe
public class ImmutableExample2 {

	private static Map<Integer, Integer> map = Maps.newHashMap();

	static {
		map.put(1, 2);
		map.put(3, 4);
		map.put(5, 6);
		map = Collections.unmodifiableMap(map);
	}

	public static void main(String[] args) {
		// map = Maps.newHashMap();
		map.put(1, 3);
		log.info("{}", map.get(1));
	}

}
