package core.model;

public class User {
    String name;
    String password;
    int age;

    public User(String name, String pass, int age) {
        this.name = name;
        this.password = pass;
        this.age = age;
    }

    public String getName() {
        return name;
    }

    public String getPwd() {
        return password;
    }

    public int getAge() {
        return age;
    }
}
