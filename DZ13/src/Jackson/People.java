package Jackson;


public class People {
    
private String name;
private String surname;
private int age;
private int id;
private boolean isDegree;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public boolean isIsDegree() {
        return isDegree;
    }

    public void setIsDegree(boolean isDegree) {
        this.isDegree = isDegree;
    }

    @Override
    public String toString() {
        return "People{" + "name=" + name + ", surname=" + surname + ", age=" + age + ", id=" + id + ", isDegree=" + isDegree + '}';
    }


}
