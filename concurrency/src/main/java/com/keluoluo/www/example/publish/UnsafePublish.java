package com.keluoluo.www.example.publish;

import java.util.Arrays;

import com.keluoluo.www.annoations.NotThreadSafe;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@NotThreadSafe
public class UnsafePublish {

	private String[] states = { "a", "b", "c" };

	public String[] getStates() {
		return states;
	}

	public static void main(String[] args) {
		UnsafePublish un = new UnsafePublish();
		log.info("{}", Arrays.toString(un.getStates()));

		un.getStates()[0] = "d";
		log.info("{}", Arrays.toString(un.getStates()));

	}
}
