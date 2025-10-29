package day1;

public class 배열과반복문2 {
	public static void main(String[] args) {
		int[] score = { 5, 4, 3, 5, 2 };
		int total = 0;
		for (int i: score) {
//			System.out.println(i);
			System.out.print(i + " ");
			if (i >= 3)
			{
				System.out.println("success");
				total += i;
			}
			else
				System.out.println("fail");
		}
		System.out.println(total);
	}
}
