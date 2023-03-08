package collectionFrameWorkPractice;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;

public class HashMaoDemo1 {

	public static void main(String[] args) {
		
	
	HashMap m=new HashMap();
	//HashMap <Integer,String> m=new HashMap<Integer,String>();
	
	m.put(101, "John");
	m.put(102, "David");
	m.put(103, "Scott");
	m.put(104, "Mary");
	m.put(105, "x");
	m.put(106, "y");
	System.out.println(m);
	System.out.println(m.get(105));
	m.remove(101);
	System.out.println(m);
	System.out.println(m.containsKey(101));
	System.out.println(m.containsKey(105));
	System.out.println(m.containsValue("David"));
	System.out.println(m.isEmpty());
	System.out.println(m.keySet());
	System.out.println(m.values());
	
	//System.out.println(m.entrySet());
	
	for(Object i:m.keySet()) {
		System.out.println(i);
	}
	
	System.out.println(m.values());
	
	for(Object i:m.values()) {
		System.out.println(i);
	}
	
	for(Object i:m.keySet()) {
		System.out.println(i+"   "+m.get(i));
	}
	
	Set s = m.entrySet();
	Iterator it = s.iterator();
	
//	for(it.hasNext()) {
//		System.out.println(it.next());
//		 
//		}
	}
}

