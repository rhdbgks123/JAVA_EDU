package day1;

import java.util.Scanner;

public class Updown {
	public static void main(String[] args) {
		int guess = 0;
		boolean isNumber = true;
		Scanner sc = new Scanner(System.in);
		String uInput = "";
		int uInputNum = 0;
		int cnt = 0;
		String userYn = ""; 
		System.out.println("게임시작");
		guess = (int)(Math.random()*100) + 1;
		
		while(true)
		{
			cnt++;
			isNumber = true;
			System.out.print("숫자입력 : ");
			uInput = sc.next();
			for (char c : uInput.toCharArray()) {
			    if (!Character.isDigit(c)) {
			    	System.out.println("숫자가 아닙니다.");
			    	uInput = "";
			    	isNumber = false;
			        break;
			    }
			}
			if(!isNumber)
				continue;
			uInputNum = Integer.parseInt(uInput);
			if(uInputNum > 100 || uInputNum < 1)
			{
				System.out.println("입력 범위를 벗어났습니다.");
			}
			
			if(guess > uInputNum)
			{
				System.out.println("UP");
			}
			else if(guess < uInputNum)
			{
				System.out.println("DOWN");
			}
			else
			{
				System.out.println("정답입니다!");
				System.out.println("시도횟수 : " + cnt + "회");
				System.out.print("재시작 하시겠습니까? Y/N");
				userYn = sc.next();
				if(userYn.equals("Y") || userYn.equals("y"))
				{
					cnt = 0;
					uInput = "";
					guess = (int)(Math.random()*100) + 1;
					continue;
				}
				else
				{
					System.out.println("게임종료");
					break;
				}
			}
		}
	}
}
