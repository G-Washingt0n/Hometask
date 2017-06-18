package Calculator;

public class MyEx extends Exception{
    private int code;

    public int getCode() {
        return code;
    }
    public void getRussianMessage(){
        switch (code){
            case 1: System.err.println("Такой операции не существует. Повторите ввод: ");
            break;
            case 2: System.err.println("Число номер 1 слишком большое! Повторите ввод: ");
            break;
            case 3: System.err.println("Число номер 2 слишком большое! Повторите ввод: ");
            break;
            case 4: System.err.println("На ноль делить нельзя! Повторите ввод: ");
            break;
        }
    }
    public MyEx(int code) {
        this.code = code;
    }
    
    


    
}
