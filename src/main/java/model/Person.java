package model;

public class Person {
    private int id_person;
    private String first;
    private String second;
    private String third;
    private String email;
    private String phone;

    public Person() {
    }

    public Person(int id_person) {
        this.id_person = id_person;
    }

    @Override
    public String toString() {
        return "model.Person{" +
                "id_person=" + id_person +
                ", first='" + first + '\'' +
                ", second='" + second + '\'' +
                ", third='" + third + '\'' +
                ", email='" + email + '\'' +
                ", phone='" + phone + '\'' +
                '}';
    }

    public Person(int id_person, String first, String second, String third, String phone, String email) {
        this.id_person = id_person;
        this.first = first;
        this.second = second;
        this.third = third;
        this.email = email;
        this.phone = phone;
    }

    public Person(String first, String second, String third, String email, String phone) {
        this.first = first;
        this.second = second;
        this.third = third;
        this.email = email;
        this.phone = phone;
    }

    public int getId_person() {
        return id_person;
    }

    public void setId_person(int id_person) {
        this.id_person = id_person;
    }

    public String getFirst() {
        return first;
    }

    public void setFirst(String first) {
        this.first = first;
    }

    public String getSecond() {
        return second;
    }

    public void setSecond(String second) {
        this.second = second;
    }

    public String getThird() {
        return third;
    }

    public void setThird(String third) {
        this.third = third;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }
}
