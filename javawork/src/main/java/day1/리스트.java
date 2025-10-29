package day1;

import java.util.ArrayList;

public class 리스트 {
	public static void main(String[] args) {
		ArrayList<String> list = new ArrayList<String>();
		
		list.add("사과");
		list.add("키위");
		list.add("딸기");
		System.out.println(list);
		
		list.add(0,"메론");
		System.out.println(list);
		
		list.remove(1);
		System.out.println(list);
		
		list.set(0, "망고");
		System.out.println(list);
		
		System.out.println("첫번째 과일은 : " + list.get(0));
		
		String temp = null;
		
		for(int i = 0 ; i < list.size(); i ++) {
			temp = list.get(i);
			System.out.println(i + " : " + temp);
		}
		
		System.out.println("확장for================");
		for(String f:list)
		{
			System.out.println(f);
		}
	}
}
