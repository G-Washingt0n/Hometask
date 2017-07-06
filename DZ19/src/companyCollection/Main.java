package companyCollection;

public class Main {
    public static void main(String[] args) {
        
        StuffCollection<String> stuff = new StuffCollection<>();
        
        stuff.addDirector("Big Boss");
        stuff.addDepartment("Test");
        stuff.add("Test","someone");
        stuff.add("A", "Afirst");
        stuff.add("A", "Asecond");
        stuff.add("BBB","Bfirst");
        stuff.add("BBB","Bsecond");
        
        String director = stuff.getDirector();
        System.out.println("Director = " + director);
       stuff.visualise();
        System.out.println("===============================================");
       stuff.removeDepartment("Test");
        stuff.removePerson("A", "Afirst");
        
        stuff.visualise();
        
    }
    
    
}
