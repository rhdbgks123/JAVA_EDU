package day1;

import java.util.Scanner;

public class 가위바위보 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		System.out.println("게임시작");
		int win = 0;
		int lose = 0;
		int draw = 0;
		int choice = 0;
		int computer = 0;
		String cString = "";
//		확장 미션
//		1. 문자열 입력 버전 ("가위", "바위", "보") ==> 1,2,3 대신에 가위,바위,보를 입력하도록 수정
//		2. 게임 시작 시 이름을 입력받아 출력
//		3. 3판 2선승제 시스템 추가
//		4. 승률 기록 및 랭킹 시스템 저장 (파일 입출력 활용)
		String name = sc.next();
		while (true) {
			System.out.print("사용자입력 가위/바위/보 종료(0): ");
			cString = sc.next();
			
			switch (cString) {
				case "가위":
					choice = 1;
					break;
				case "바위":
					choice = 2;
					break;
				case "보":
					choice = 3;
					break;
				case "0":
					choice = 0;
					break;
				default:
					choice = 4;
			}
			
			if (choice == 0) {
				System.out.println("게임종료");
				break;
			}
			if (choice > 3 || choice < 1) {
				System.out.println("잘못된 입력입니다.");
				continue;
			}
			computer = (int) (Math.random() * 3) + 1;
			System.out.println("사용자 : " + choice + " / 컴퓨터 : " + computer);
			if (choice == computer) {

				System.out.println("무승부!");
				draw++;
			} else if ((choice == 1 && computer == 3) || (choice == 2 && computer == 1)
					|| (choice == 3 && computer == 2)) {
				System.out.println("사용자 승리!");
				win++;
			} else {
				System.out.println("컴퓨터승리");
				lose++;
			}
			if(win >=2 || lose >=2)
			{
				break;
			}
			System.out.println("현재전적 : " + win + "승 / " + draw + "무 / " + lose + "패");
		}
		System.out.println("최종결과(" + name + ") : " + win + "승 / " + draw + "무 / " + lose + "패");
		sc.close();
	}

}
