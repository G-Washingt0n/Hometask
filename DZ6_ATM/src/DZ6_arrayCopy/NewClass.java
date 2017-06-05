package DZ6_arrayCopy;

public class NewClass {
    public static void main(String args[]){
        int[] array = {1,2,3,4,5,6,7,8,9,10};
        int[] newArray = new int[20];
        System.arraycopy(array, 0, newArray, (newArray.length/4), array.length);
        for(int i=0;i<newArray.length;i++)
            System.out.print(newArray[i]+" ");
        
    }
}
