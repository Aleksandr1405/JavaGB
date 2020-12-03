public class Main {
    public static void main(String[] args) {
        System.out.println(form(2, 3, 20, 4));
        System.out.println(sumOfTwo(6, 4));
        positive(123);
        hello("Александр");
        Year(2021);
    }

    public static float form(int a, int b, int c, int d) {
        return a * (b + (c / d));
    }

    public static boolean sumOfTwo(int a, int b) {
        if ((a + b <= 20) && (a + b >= 10)) {
            return true;
        } else {
            return false;
        }
    }

    public static void positive(int a) {
        if (a < 0) {
            System.out.println("Отрицаьельное");
        } else {
            System.out.println("Положительное");
        }
    }

    public static void hello(String str) {
        System.out.println("Привет, " + str + "!");
    }

    public static void Year(int year) {
        if ((year % 4 == 0) && (year % 100 != 0) || (year % 400 == 0)) {
            System.out.println("Yes");
        } else {
            System.out.println("No");
        }
    }
}
