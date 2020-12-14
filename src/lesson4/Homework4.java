package lesson4;

public class Homework4 {

    public static void main(String[] args) {

        Employee mainEmployee = new Employee("Александр", "Валерьевич",
                "Варкан", "8(999)008-00-08",
                "Java Developer", 180000, 1997);

        System.out.println(  mainEmployee.getSurname() + " " + mainEmployee.getName() +
                " " + mainEmployee.getSecondName() +
                " " + mainEmployee.getPosition() + ".");
        System.out.println("-------------------------------------------");

        Employee[] employees = {
                mainEmployee,
                new Employee("Андрей", "Сергеевич",
                        "Тридчиков", "8(921)005-92-92",
                        "Manager", 40000, 1991),
                new Employee("Валерий", "Владимирович",
                        "Варкан", "8(931)359-97-98",
                        "Team lead", 400000, 1967),
                new Employee("Алла", "Васильевна",
                        "Бишлиу", "8(950)422-28-06",
                        "UX/UI designer", 120000, 1973),
                new Employee("Виктория", "Александровна",
                        "Черноокая", "8(800)555-35-35",
                        "Senior developer", 800000, 1981)
                };

        for (int i = 0; i < employees.length; i++) {
            System.out.println(employees[i].getFullInfo());
        }
        System.out.println("-------------------------------------------"); // вывод информации о всех сотрудниках

        for (int i = 0; i < employees.length; i++) {
            if (employees[i].getAge() > 40) {
                System.out.println(employees[i].getFullInfo());
            }
        }
        System.out.println("-------------------------------------------"); // инфо о сотрудниках старше 40

        increaseSalary(employees, 35, 10000); // кто старше 35 зарплата + 10000 (метод описан ниже)

        /*for (int i = 0; i < employees.length; i++) {
                System.out.println(employees[i].getSalary());
        }
               проверка меняется ли зарплата если возраст больше 35 лет
        */
    }

    private static void increaseSalary(Employee[] arr, int age, float increment) {
        for (int i = 0; i < arr.length; i++) {
            if (arr[i].getAge() > age) {
                arr[i].setSalary(increment);
                arr[i].isSalaryChange = true;
            }
        }
    }
}

