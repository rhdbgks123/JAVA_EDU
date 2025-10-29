package day1;

public class 조건문 {
	public static void main(String[] args) {
		int workTime = 10;
		int sTime = 10;
		int eTime = 17;
		
		if (workTime >= 9 && workTime <= 18)
		{
			System.out.println("Y");
		}
		else
		{
			System.out.println("N");
		}
		if (eTime - 1 - sTime >= 8)
		{
			System.out.println("초과근무");
		}
		else
		{
			System.out.println("정상근무");
		}
	}
}
