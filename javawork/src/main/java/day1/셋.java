package day1;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Set;

public class 셋 {
	public static void main(String[] args) {
		Set<String> score = new HashSet<>();
		
		score.add("사과");
		score.add("사과");
		score.add("바나나");
		
		System.out.println(score);
		
		Iterator<String> iter = score.iterator();
		
		while (iter.hasNext()) {
			String item = iter.next();
			System.out.println(item);
		}
		List<String> names = (List<String>) Arrays.asList("사과","사과","바나나");
		
		System.out.println(names);
	}
}
