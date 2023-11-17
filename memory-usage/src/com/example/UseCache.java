package com.example;

import java.util.List;

public class UseCache {
	@SuppressWarnings({ "unused", "removal" })
	public static void main(String[] args) {
		// https://openjdk.org/projects/valhalla/
		Integer i= new Integer(12);
		// int array: 12B (Object Header) + 4B + 24B = 40B
		int[] numbers = {1,2,3,4,5,6}; // 1 | 2 | 3 | 4 ...
		// 12B + 4B + 4B + ... = 36B
		//       12B + 4B= 16B * 6 = 96B = 132B
		List<Integer> list = List.of(1,2,3,4,5,6); // List<int>
		// ref1 | ref2 | ref3 | ...
		//  |       |
		//  \/     \/
		//  1      2       3
		// record
		List<Circle> circles = List.of(new Circle(1,2,3),new Circle(4,5,6));
		// 1 2 3 4 5 6
		Integer x = Integer.valueOf(42); // auto-boxing
		Integer y = 42;
		Integer u = 542;
		Integer v = 542;
		System.out.println("x==y ? "+(x==y));
		System.out.println("u==v ? "+(u==v));
		String name1 = "jack"; // constant cache
		String name2 = "jack";
		String name3 = new String("jack");
		name3 = name3.intern();
		// http://binkurt.blogspot.com/2014/09/string-deduplication.html
		// -XX:+UseG1GC -XX:+UseStringDeduplication // Full GC
		System.gc(); // triggers full gc
		// -XX:+DisableExplicitGC
		System.out.println("name1==name2 ? "+(name1==name2));
		System.out.println("name2==name3 ? "+(name2==name3));
	}
}

abstract interface X {}

final record Circle(double x,double y,double radius) {}
