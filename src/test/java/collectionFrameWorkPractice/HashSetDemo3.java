package collectionFrameWorkPractice;

import java.util.HashSet;

public class HashSetDemo3 {

	public static void main(String[] args) {
		//union InterSection Diffrance
		
		HashSet<Integer> set1=new HashSet<>();
		
		set1.add(1);
		set1.add(2);
		set1.add(3);
		set1.add(4);
		set1.add(5);
		
		System.out.println(set1);
		
		HashSet<Integer> set2=new HashSet<>();
		set2.add(3);
		set2.add(4);
		set2.add(5);
		
		System.out.println(set2);
		
		//union
		set1.addAll(set2);
		System.out.println(set1);
		
		//intesection
		set1.retainAll(set2);
		System.out.println(set1);
		
		//diffrance
		set1.removeAll(set2);
		System.out.println(set1);
		
		//containsAll
		System.out.println(set1.containsAll(set2));
		System.out.println(set2);
		
		
	}
}
