package dz3;
import java.util.Random;
import java.util.Scanner;

public class DZ3 {
    
    public static int[] input(int[] Arr){
         System.out.print("Строка ввода данных: ");
        Scanner in = new Scanner(System.in);
        for(int i=0;i<Arr.length;i++ )
            Arr[i]=in.nextInt();
        return Arr;
    }
    
    public static void print(int[] Arr){
    for(int i=0;i<Arr.length;i++){
    System.out.print(Arr[i]);
    if(i<(Arr.length-1))
        System.out.print(", ");
    else
        System.out.print("\n");
    }
    }
    
    
    public static int[] sort1(int[] Arr){
        for(int i=0;i<Arr.length-1;i++){
            int min=i;
            for(int j=i+1;j<Arr.length;j++){
                if(Arr[j]<Arr[min])
                    min=j;
            }
            if(min!=i){
                int buff=Arr[i];
                Arr[i]=Arr[min];
                Arr[min]=buff;
            }
        }
        print(Arr);
        return Arr;
    }
    
    public static int[] sort2(int[] Arr){
        for(int i=0;i<Arr.length-1;i++){
            for(int j=i+1;j<Arr.length;j++){
            if(Arr[i]>Arr[j]){
                int buff=Arr[i];
                Arr[i]=Arr[j];
                Arr[j]=buff;
                }
            }
        }
        print(Arr);
        return Arr;
    }

    public static void main(String[] args) {
        
        int[] M= new int[10];
        input(M);
       /* final Random random = new Random();
        for(int i=0;i<M.length;i++)
            M[i]= random.nextInt(100);
        */print(M);
        int choise=2;
        while(choise>=2){
        Scanner in = new Scanner(System.in);
        System.out.println("Каким методом сортировать? (введите 1 или 2): ");
        choise=in.nextInt()-1;
        if(choise<0)
            choise+=100;
        if(choise==0)
        sort1(M);
        else{
        if(choise==1)
        sort2(M);
        else
            System.out.println("Выбран не существующий метод сортировки, повторите ввод: ");
        }
        }
    }
    
}
