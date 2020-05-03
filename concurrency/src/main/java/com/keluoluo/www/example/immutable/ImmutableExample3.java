package com.keluoluo.www.example.immutable;

import com.google.common.collect.ImmutableMap;
import com.keluoluo.www.annoations.ThreadSafe;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@ThreadSafe
public class ImmutableExample3 {

	// private final static ImmutableList list = ImmutableList.of(1, 2, 3);

	// private final static ImmutableSet set = ImmutableSet.copyOf(list);

	private final static ImmutableMap<Integer, Integer> map1 = ImmutableMap.of(1, 2, 3, 4);
	private final static ImmutableMap<Integer, Integer> map2 = ImmutableMap.<Integer, Integer>builder().put(1, 2)
			.put(3, 4).put(5, 6).build();

	public static void main(String[] args) {
		System.out.println(map1.get(5));
		System.out.println(map2.get(3));
	}
}
