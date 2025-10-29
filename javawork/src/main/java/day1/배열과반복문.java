package day1;

public class 배열과반복문 {
	public static void main(String[] args) {
		int[] score = { 5, 4, 3, 5, 2 };
		int total = 0;
		for (int i = 0; i < score.length; i++) {
			System.out.print(score[i] + " ");
			if (score[i] >= 3)
			{
				System.out.println("success");
				total += score[i];
			}
			else
				System.out.println("fail");
		}
		System.out.println(total);
	}
}
