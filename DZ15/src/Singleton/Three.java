package Singleton;

public class Three {
    private static Three instance;

    private Three() {
    }
    
    public static synchronized Three getInstance() {
    if (instance == null) {
      instance = new Three();
    }
    return instance;
  }
}
