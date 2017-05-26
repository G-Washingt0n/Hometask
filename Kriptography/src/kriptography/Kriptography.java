package kriptography;

import static java.lang.Math.*;
import java.math.BigInteger;

public class Kriptography {
    public static String hexToBin(String in){ //функция переводит строку из 16 в 2 вид сохраняя все 32 бита
    String out="";
        String test;
        int S;
        for (int i=0; i<in.length(); i++) {
            S=Integer.parseInt(in.substring(i,i+1),16);
            test=Integer.toBinaryString(S);
            if(test.length()<4){
                for(int j=0; j<4-test.length() ; j++){
                         out+="0";           
                }
            }
            out+=test;
        }
    return out; 
    }
    
    public static String decToBin(String in){
        String out="";
        String test;
        long s = new Long(in);
        test = Long.toBinaryString(s);
        if(test.length()<32) {
            for(int j=0; j<32-test.length(); j++){
                         out+="0";           
                } 
        }
        out+=test;
        return out;
    }
    
    public static int blockToHex(String in){
        char[] S = new char[in.length()];
        int summ=0;
        for (int i=0; i<in.length(); i++) {
            S[i]=in.charAt(i);
            if(S[i]=='1')
            summ+=pow(2,3-i);
        }
        System.out.println("Значение блока: " + summ);
        return summ;
    }

    public static void main(String[] args) {
        String start =/*"668F1500"; //my key*/ "03E81B0D";
        int steps = 14;
        String[] Keys = new String[steps];
        Keys[0] = hexToBin(start);
        BigInteger n ;//= BigInteger.valueOf(Integer.parseInt(Keys[0],2)); //выведет значение в 10 виде
        
        BigInteger a = BigInteger.valueOf(2).pow(32);
        for (int i = 1; i < steps; i++) {
            n = BigInteger.valueOf(Long.parseLong(Keys[i-1],2)); //n в 10 видe
            BigInteger result = (((n.pow(3)).add(BigInteger.valueOf(11111))).mod(a));
            Keys[i]=decToBin(result.toString());
        }
        for (int i = 0; i < steps; i++) {
            System.out.println(Keys[i]);
        }
        String text1 =/*"C81523E6";*/     /*my text1*/ "00A4F2A7";
        long xor;
        int num;
        String upper="0123456789ABCDEF";
        /*мой p блок */int[] p = {28, 32, 8, 5, 16, 3, 4, 13, 21, 2, 23, 9, 29, 14, 10, 7, 15, 24, 27, 1, 31, 20 ,19 ,12 ,25 ,30 ,22 ,11, 6, 18, 17, 26};
//int[] p = {30, 3, 26, 27, 31, 16, 1, 32, 19, 11, 21, 4, 20, 12, 15, 14, 18, 10, 13, 25, 23, 8, 28, 9, 2, 17, 6, 29, 5, 7, 24, 22};        
/*мои S блоки */String[] S={"620f1bac59e47d83","c8eb5361d9f7204a","e15d4cf7a892b063","ba6e38d7f14c0529","1829fea06347d5cb","ef5db2684c97103a","d2ae389bf410756c","47f2de698b3a1c05"};
        //String[] S={"927e10b38acfd465","371e2baf80d46c95","0834d7fb2a1c956e","035d7a24e98cb61f","6cf48e32d5710ab9","421ef7d9568ca30b","d2190e8563fac7b4","47a382695f1cebd0"};
        System.out.println(upper.length());
        text1=hexToBin(text1);
        System.out.println("Входной текст: " + text1);
        for(int i=0; i<steps; i++){
            xor=Long.parseLong(text1,2)^Long.parseLong(Keys[i],2); //формат данных long(число)
           // decToBin(Long.toString(xor)); // бинарный вид
            //System.out.println("Результат XOR: "+ decToBin(Long.toString(xor)));
            String newS="";
           for(int j=0;j<8;j++){
           String block = decToBin(Long.toString(xor)).substring(j*4,j*4+4);
           //System.out.println(block);
           num=blockToHex(block);
           String bl=S[j].substring(num, num+1);
           newS+=bl;
           //System.out.println(newS); //получается новый S блок 
           }
           newS=hexToBin(newS);
           System.out.println(newS); //S блок в бинарном виде
           text1="";
           for(int k=0; k<32;k++){ //P подстановка
           text1+=newS.substring(/*33-*/p[k]-1,/*33-*/p[k]);
           System.out.println(text1);
           }
       }
        
      for(int j=0;j<8;j++){ //разбить на 8 блоков по 4 бита и перевести в 16-ную систему, можно вручную
           String block = text1.substring(j*4,j*4+4);
           //System.out.println(block);
           System.out.println(Integer.toHexString(blockToHex(block)));
      }
        System.out.println("Расшифровка:___________________________________________________________ "); //обратная SP подстановка 
        for(int i=0;i<steps;i++){
            char[] P1=new char[32];
            char[] P2 = new char[32];
            for(int k=0; k<32;k++){ //P подстановка начало
           P1[k]=text1.charAt(k);
           //System.out.println(P1[k]);
           }
            for(int k=0; k<32;k++){ 
           P2[/*32-*/p[k]-1]=P1[/*31-*/k] ;
           } //теперь в Р2 лежит мой текст по битам 32,31...1
            text1="";
            for(int j=0;j<32;j++){
            text1+= "" + P2[j];
            }
           // System.out.println("После Р подстановки: " + text1);
            String afterSP="";
            for(int j=0;j<8;j++){ //SP подстановка
           String block = text1.substring(j*4,j*4+4); //выделяю блок
           //char[] Si=new char[16]; 
           char blok = Integer.toHexString(blockToHex(block)).charAt(0); //записываю в чар
           int position=100; //ловит позицию blok в строке Si
           for(int k=0; k<16;k++){ 
           //Si[k]=S[j].charAt(k);
           if(S[j].charAt(k)==blok)
               position=k; //по сути значение в верхней строке S блока
           }
            afterSP+= Integer.toHexString(position);
           //Integer.toHexString(blockToHex(block));
           //тут получаю блок 1...8 в виде обычного числа
           //System.out.println("позиция " + position + " hex= " + Integer.toHexString(position) );
           
      }
            //System.out.println(afterSP); //число в hex формате после SP подстановки
            
      long xor1,xor2;
      afterSP=hexToBin(afterSP);
     // System.out.println("Входной текст: " + afterSP);
      xor1=Long.parseLong(afterSP,2)^Long.parseLong(Keys[steps-i-1],2);
      xor2=xor1^Long.parseLong(Keys[steps-i-1],2);
      //System.out.println(xor2);
      text1="";
      text1+=decToBin(Long.toString(xor2));
      //System.out.println("Binary: " + text1);
      
      
      }
        
        for(int j=0;j<8;j++){ //разбить на 8 блоков по 4 бита и перевести в 16-ную систему, можно вручную
           String block = text1.substring(j*4,j*4+4);
          
           System.out.println(Integer.toHexString(blockToHex(block)));
      }
      
    }

}
