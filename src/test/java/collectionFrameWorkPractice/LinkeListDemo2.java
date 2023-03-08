package collectionFrameWorkPractice;

import java.util.Collections;
import java.util.LinkedList;

public class LinkeListDemo2 {
	
	public static void main(String[] args) {
		LinkedList l=new LinkedList();
		l.add("x");
		l.add("Y");
		l.add("A");
		l.add("B");
		l.add("c");
		
		LinkedList l2=new LinkedList();
		//addAll
		l2.addAll(l);
		System.out.println(l2);
		
		//RemoveAll
		l2.removeAll(l);
		System.out.println(l2);
		
		//sort
		Collections.sort(l);
		System.out.println(l);
		
		//reverse order
		Collections.sort(l,Collections.reverseOrder());
		System.out.println(l);
		
		//Shuffle
		Collections.shuffle(l);
		System.out.println(l);
		
		LinkedList l3=new LinkedList();
		l3.add("Dog");
		l3.add("dog");
		l3.add("Cat");
		l3.add("Horse");
		
		System.out.println(l3);
		System.out.println(l3.getFirst());
		System.out.println(l3.getLast());
		
		l3.removeFirst();
		l3.removeLast();
		
		System.out.println(l3);
		
		
	}

}
