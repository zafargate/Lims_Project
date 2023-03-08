package collectionFrameWorkPractice;

import java.util.Iterator;
import java.util.LinkedList;

public class DemoLinkList {

	
	public static void main(String[] args) {
		//Declear
		LinkedList l=new LinkedList();
		
//		LinkedList<Integer>l=new LinkedList<Integer>();
//		LinkedList<String > l1=new LinkedList<String>();
		
		
		l.add(100);
		l.add("Welcome");
		l.add(15.5);
		l.add('a');
		l.add(true);
		l.add(null);
		System.out.println(l);
		System.out.println(l.size());
		
		//remove
		l.remove(3);
		System.out.println(l);
		
		//insert
		l.add(3,"Java");
		System.out.println(l);
		
		System.out.println(l.get(3));
		//set
		l.set(5, "x");
		System.out.println(l);
		//contains
		System.out.println(l.contains("Java"));
		System.out.println(l.contains("python"));
		//isEmpty
		System.out.println(l.isEmpty());
		
		//Reading Elemenet from LLusing for Loop
		for (int i = 0; i < l.size(); i++) {
			System.out.println(l.get(i));
			
		}
		
		for(Object x:l) {
			System.out.println(x);
		}
		
		//ittrator
		Iterator it=l.iterator();
		while(it.hasNext()) {
			System.out.println(it.next());
		}
		
	}
}
