package collectionFrameWorkPractice;

import java.util.HashSet;
import java.util.Iterator;
 

public class HashSetDemo1 {
	
	public static void main(String[] args) {
		
	
	// HashSet hs=new HashSet(); //default capacity 16
	// HashSet hs=new HashSet(100);// initial capacity is 100
	//HashSet hs=new HashSet(100,(float)0.90);
		HashSet  hs=new HashSet();//defaoult capacity is 16
		// add Object /Element into HashSet
		hs.add(100);
		hs.add(16.4);
		hs.add("Welcome");
		hs.add('a');
		hs.add(true);
		hs.add(null);
		
		System.out.println(hs);
		
		//remove
		hs.remove(16.4);
		System.out.println(hs);
		
		System.out.println(hs.contains("Welcome"));
		System.out.println(hs.contains("xyz"));
		System.out.println(hs.isEmpty());
		
		//reading Object From hashSet
		for(Object e:hs) {
			System.out.println(e);
		}
		
		//By using ittrator mathod
		
		Iterator it= hs.iterator();
		while(it.hasNext()) {
			System.out.println(it.next());
		}
		
	
	} 

}
