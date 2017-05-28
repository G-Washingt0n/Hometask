
package dz2;

import static java.lang.Math.*;
import java.util.Scanner;
import  java.util.Random;

public class DZ2 {
    public static void print(int[] Arr){
    for(int i=0;i<Arr.length;i++){
    System.out.print(Arr[i]);
    if(i<(Arr.length-1))
        System.out.print(", ");
    else
        System.out.print("\n");
    }
    }
    
   public static void ex_1(){
       int[] M1= new int[10];
        final Random random = new Random();
        for(int i=0;i<M1.length;i++)
            M1[i]= random.nextInt(100);
        int min=0,max=1;
        print(M1);
        for(int i=0;i<M1.length;i++){
                if(M1[i]<=M1[min])
                    min=i;
                if(M1[i]>M1[max])
                    max=i;
                if(i==M1.length-1){
                    System.out.println("min value = " + M1[min]);
                    System.out.println("max value = " + M1[max]);
                    M1[min]=0;
                    M1[max]=99;
                    print(M1);
                }
                
        }   
   }
   
   public static void ex_2(){
       float[] M={5.2f,3.1f,2.3f,5.2f,5.2f,4.7f,8.9f,3.1f,5.2f,1.4f};
   //System.out.println(M.length);
   for(int i=0;i<M.length;i++){
       int count=1;
       for(int j=i+1;j<M.length;j++){
           if(M[j]==M[i])
               count++;
       }
       if(count>1){
           if(i==0)
                System.out.println("value " + M[i] +" has " + count + "reps");
           
           if(i!=0){
               int flag=0;
           for(int k=0;k<i;k++){
               if(M[i]==M[k]){
                   flag=1;
                   System.out.println("break because: " + i +" and " + k);
                   k=i-1;
                   }
               if(k==i-1 && flag==0){
                    System.out.println("value " + M[i] + " has " + count + "reps");
               }
               }
           }              
       }
           
       }
   }
   
   public static void ex_3(){
       int[] M= new int[6];
        final Random random = new Random();
        for(int i=0;i<M.length;i++)
            M[i]= random.nextInt(100);
        print(M);
        int[] M1= new int[M.length];
        for(int i=M.length;i>0;i--)
            M1[M.length-i]=M[i-1];
        print(M1);
   }
   

    public static void main(String[] args) {
        
        ex_1();
        ex_2();
        ex_3();
    }
    
}
