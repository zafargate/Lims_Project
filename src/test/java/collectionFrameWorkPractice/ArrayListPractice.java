package collectionFrameWorkPractice;

import java.util.*;

public class ArrayListPractice {
	public static void main(String[] args) {
		
	
	ArrayList al=new ArrayList<>();//it is dtore homoginiuos and hatroginious type data
	al.add(100);
	al.add("Welcom");
	al.add(15.5);
	al.add('a');
	al.add(true);
	
	System.out.println(al);
	//size()
	System.out.println(al.size());
	//remove(index)
	al.remove(4);
	//remove(Object);
	al.remove("Welcom");
	System.out.println(al);
	//insurt new Eleemnet
	al.add(2,"Java");
	System.out.println(al);
	// retreave specific value 
	System.out.println(al.get(2));
	
	//Change Element or replace element
	al.set(2, "c#");
	System.out.println(al);
	//search contains return true/false
	System.out.println(al.contains("c#"));
	System.out.println(al.isEmpty());
	
	// for loop
	for (int i = 0; i <al.size(); i++) {
		System.out.println(al.get(i));	
	}
	
	// for each loop
	for (Object e : al) {
		System.out.println(e);
	}
	
	 // iterator method
	Iterator it=al.iterator();
	while(it.hasNext()) {
		System.out.println(it.next());
	}
	
	
	}

}
