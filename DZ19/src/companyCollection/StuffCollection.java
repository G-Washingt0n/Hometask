package companyCollection;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class StuffCollection<T> {

    private HashMap<String, List<T>> data = new HashMap<>();

    private T director;

    public void addDirector(T value) {
        director = value;
    }

    public T getDirector() {
        return director;
    }
    
    public void addDepartment(String department){
        if (data.containsKey(department)) {
            System.err.println("This department is already created!");
        } else {
            List<T> list = data.get(department);
            if (list == null) {
                list = new ArrayList<>();
            }
            data.put(department, list);
        }
    }

    public void add(String department, T value) {
        if (data.containsKey(department)) {
            data.get(department).add(value);
        } else {
            List<T> list = data.get(department);
            if (list == null) {
                list = new ArrayList<>();
            }
            list.add(value);
            data.put(department, list);
        }
    }

    public void removePerson(String department, T value) {
        if (data.containsKey(department))
            data.get(department).remove(value);
        else
            System.err.println("No such person found! ");
    }

    public void removeDepartment(String department) {
            if (data.containsKey(department))
            data.remove(department);
            else        
            System.err.println("No such department found! ");
    }

    public void visualise() {
        for (String key : data.keySet()) {
            System.out.println("Department: " + key + "\n People there:  " + data.get(key));
        }
    }

}
