package homework_2;

public class Human {

    private int id;

    private String first_name;

    private String last_name;

    private int age;

    public Human() {    }

    public Human(int age, String first_name, int id, String last_name) {
        this.age = age;
        this.first_name = first_name;
        this.id = id;
        this.last_name = last_name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getFirst_name() {
        return first_name;
    }

    public void setFirst_name(String first_name) {
        this.first_name = first_name;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getLast_name() {
        return last_name;
    }

    public void setLast_name(String last_name) {
        this.last_name = last_name;
    }
}
