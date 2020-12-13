package lesson4;

public class Employee {
    private static final int YEAR = 2020;

    private String name;
    private String surname;
    private String secondName;
    private String position;
    private String phone;
    private float salary;
    private int birthYear;

    boolean isSalaryChange;
    private int personId;

    private static int id = 0;

    Employee(String name,
             String secondName,
             String surname,
             String phone,
             String position,
             float salary,
             int birthYear) {
        this.birthYear = birthYear;
        this.name = name;
        this.surname = surname;
        this.secondName = secondName;
        this.position = position;
        this.phone = phone;
        this.salary = salary;
        this.personId = ++id;
    }

    String getName() {
        return name;
    }

    String getSecondName() {
        return secondName;
    }

    String getSurname() {
        return surname;
    }

    String getPosition() {
        return position;
    }

    String getPhone() { // не используется :((
        return phone;
    }

    int getAge() {
        return YEAR - birthYear;
    }

    int getSalary() {
        return (int) salary;
    }



    void setSalary(float difference) {
        this.salary = this.salary + difference;
    }

    String getFullInfo() {
        return this.personId + " " + this.name + " " +
                this.secondName + " " +
                this.surname + ", " +
                this.getAge() + " years old, " +
                this.position + ". Phone number: " +
                this.phone + ". Salary is " +
                this.getSalary() + " RU";
    }
}
