package day1;

import java.util.Arrays;
import java.util.List;

public class 배열과반복문3 {
	public static void main(String[] args) {
		List<Integer> score = (List<Integer>) Arrays.asList(5, 3, 4, 2, 5);
		int total = 0;
		for (int i = 0; i < score.size(); i++) {
			System.out.print(score.get(i) + " ");
			if (score.get(i) >= 3) {
				System.out.println("success");
				total += score.get(i);
			} else
				System.out.println("fail");
		}
		System.out.println(total);
	}
}
