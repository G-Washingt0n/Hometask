package sync;

public class MyThread extends Thread{

    @Override
    public void run() {
        for(int i =0;i<50;i++){ //To change body of generated methods, choose Tools | Templates.
            Main main = new Main();
            main.print(getName());
            
    }
     
    
}
}
