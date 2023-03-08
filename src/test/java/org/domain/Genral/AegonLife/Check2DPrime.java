  package org.domain.Genral.AegonLife;

import java.util.Scanner;

public class Check2DPrime
{
    public static void main(String[] args) {
        int ar[][]={{1,6,7},{12,4,11},{13,4,6}};
        int pr[]=new int[ar.length*ar[0].length];
        char ch[][]=new char[ar.length][ar[0].length];

       int k=0;
       for(int i=0;i<ar.length;i++)
       {
           for (int j = 0; j < ar[i].length; j++) {
               int primeNo = countArray(ar[i][j]);
               pr[k] = primeNo;
               k++;
               if (primeNo == 7 || primeNo==11 ||primeNo==13) {
                   System.out.print(i+","+j+" ");
                   ch=locationOfPrimeNo(ch,i,j);
                   System.out.println("--> "+ch[i][j]);

               }

           }
          // System.out.println();

       }
        for (int i = 0; i <pr.length; i++) {
            if(!(pr[i]==0))
            {
                System.out.print(pr[i]+"  ");
            }
        }


    }

    private static char[][] locationOfPrimeNo(char[][] ch, int i, int j)
    {
        Scanner sc=new Scanner(System.in);

        ch[i][j]='a';

       return ch;
    }

    private static int countArray(int num)
    {

        int count=0;
        for (int i = 1; i <=num; i++) {
            if((num%i==0)) {
                count++;
            }

        }
        if(count==2)
        {
            return num;

        }


       return 0;

    }

}
