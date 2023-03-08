package collectionFrameWorkPractice;

import java.util.HashSet;
import java.util.Scanner;

public class TyMockQuestion {
	
	  public static void main(String[] args) {
		Scanner sc= new Scanner(System.in);
//	int n=5;
//	for(int i=0;i<n;i++) {
//		for (int j = n; j >=n-i; j--) {
//			 System.out.print(" ");
//			
//		}
//		for (int j = 0; j <=i; j++) {
//			//System.out.print("*");
//			if(i==j) {
//				//System.out.print(sc.next());
//			System.out.print((char)(j+97));
//			}
//		}
//		System.out.println();		
//	}
		HashSet<Character> set=new HashSet<>();	
		String s=sc.nextLine();
		for(int i=0; i<s.length();i++) {
			char ch=s.charAt(i);
			set.add(ch);
		}
		System.out.println(set);
  }

}
