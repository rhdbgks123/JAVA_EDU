package day1;

import java.util.HashSet;
import java.util.Set;

public class 로또 {
	public static void main(String[] args) {
		Set<Integer> lotto = new HashSet<Integer>();
		
		while(lotto.size() < 6)
		{
			lotto.add((int)(Math.random()*45) +1 );
		}
		System.out.println(lotto);
	}
}
