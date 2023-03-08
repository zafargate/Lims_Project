package collectionFrameWorkPractice;

import java.util.Hashtable;
import java.util.Iterator;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;

public class HashTableDemo {
   
	public static void main(String[] args) {
		//Hashtable t=new Hashtable();//11 capacity and load fectore is 0.75
		//Hashtable t=new(initial capacity); create hashtable object with some capacity
		//Hashtable t=new Hashtable(intial capacity, fill ratio/load fector);
		
		Hashtable<Integer,String> t=new Hashtable<Integer,String>();
		t.put(101, "John");
		t.put(102, "David");
		t.put(103, "Smith");
		t.put(104, "John");
		t.put(105, "John");
		//t.put(106, null);
		
		System.out.println(t);
		System.out.println(t.get(103));
		t.remove(105);
		System.out.println(t);
	    System.out.println(t.contains("David"));
	    System.out.println(t.containsValue("John"));
	    System.out.println(t.keySet());
	    System.out.println(t.values());
	    
//	    for ( int key : t.keySet()) {
//			System.out.println(key);
//		}
//	    
//	    for ( String key : t.values()) {
//			System.out.println(key);
//		}
//	    for(int k:t.keySet()) {
//	    	System.out.println(k+"   "+t.get(k));
//	    }
//	    
	    for(Map.Entry entry:t.entrySet()) {
	    	System.out.println(entry.getKey()+"    "+entry.getValue());
	    }
	     
	    Set s=t.entrySet();
	    for(Object x:s) {
	    	System.out.println(x);
	}
	    Iterator it = s.iterator();

	  while(it.hasNext()) {
		Map.Entry entry=(Entry) it.next();
		System.out.println(entry);
	 }
 
	}

	 
}
