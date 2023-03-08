package collectionFrameWorkPractice;

import java.util.HashSet;

public class HashSetDemo2 {

	
	public static void main(String[] args) {
		HashSet<Integer> evenNum=new HashSet();
		
		evenNum.add(2);
		evenNum.add(4);
		evenNum.add(6);
		evenNum.add(8);
		System.out.println(evenNum);
		
		HashSet<Integer> number=new HashSet<Integer>();
		//addAll
		number.addAll(evenNum);
		number.add(10);
		System.out.println(number);
		
		number.removeAll(evenNum);
		System.out.println(number);
		
		
		
}
}
