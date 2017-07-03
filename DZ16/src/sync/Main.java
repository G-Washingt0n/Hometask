package sync;


public class Main {
     public static void main(String[] args) {
        Thread thread = new MyThread();
     thread.setName("AAA");
     Thread thread2 = new MyThread();
     thread2.setName("BBB");
     thread.start();
     thread2.start();
     
     } 
    
    public synchronized void print(String name){
        
        for(int i=0;i<10;i++){
            System.out.println(name + "mythread name " + i);
        }
    }
    
}
