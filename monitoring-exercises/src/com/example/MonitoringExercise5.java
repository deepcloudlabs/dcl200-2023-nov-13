package com.example;

import java.util.HashSet;
import java.util.Set;

public class MonitoringExercise5 {
    private static Set<String> set = new HashSet<>(); 
	public static void main(String[] args) throws InterruptedException {
		for (int j=0;j<2_000_000;++j) {
			String buffer= "";
		for (int i = 0; i < 10_000; ++i) {
			buffer += Integer.toString(1);
			set.add(buffer);
			// System.gc();
		}
		}
		System.out.println(set.size());
	}

}
