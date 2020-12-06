package lesson2;

import java.util.Arrays;

public class lesson2 {
    public static void main(String[] args) {
        int[] arr = {0, 1, 1, 0, 1, 0, 0, 1, 1, 0};
        int[] arr2 = new int[8];
        int[] arr3 = {1, 5, 3, 2, 11, 4, 5, 2, 4, 8, 9, 1};
        int[] arr4 = {72, 210, 4, 52, 69, 76, 234, 332, 54, 1, 34, 24, 50};
        int[] arr6 = {1, 1};
        int[] arr7 = {1, 2, 3, 4, 5};

        System.out.println(Arrays.toString(zeroOreOne(arr)));
        System.out.println(Arrays.toString(three(arr2)));
        System.out.println(Arrays.toString(multi(arr3)));
        maxOreMin(arr4);
        square(5);
        System.out.println(equality(arr6));
        System.out.println(Arrays.toString(bias(arr7, -2)));
        System.out.println(Arrays.toString(biasExtra(arr7, -2)));

    }

    public static int[] zeroOreOne(int[] arr) {
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] == 0) {
                arr[i] = 1;
            } else {
                arr[i] = 0;
            }
        }
        return arr;
    }

    public static int[] three(int[] arr2) {
        int step = 3;
        arr2[0] = 1;
        for (int i = 1; i < arr2.length; i++) {
            arr2[i] = arr2[i - 1] + step;
        }
        return arr2;
    }

    public static int[] multi(int[] arr3) {
        for (int i = 0; i < arr3.length; i++) {
            if (arr3[i] < 6) {
                arr3[i] *= 2;
            }
        }
        return arr3;
    }

    public static void maxOreMin(int[] arr4) {
        int min = arr4[0];
        int max = arr4[0];
        for (int i = 1; i < arr4.length; i++) {
            if (arr4[i] > max) {
                max = arr4[i];
            }
            if (arr4[i] < min) {
                min = arr4[i];
            }
        }
        System.out.println(max + " " + min);
    }

    public static void square(int a) {
        int[][] arr = new int[a][a];
        for (int i = 0; i < arr.length; i++) {
            for (int j = 0; j < arr.length; j++) {
                if (i == j) {
                    arr[i][j] = 1;
                }
                System.out.print(arr[i][j]);
            }
            System.out.println();
        }
    }

    public static boolean equality(int[] arr6) {
        int sumLeft = arr6[0];
        int sumRight = 0;

        for (int i = 1; i < arr6.length; i++) {
            sumRight += arr6[i];
        }
        for (int j = 1; j < arr6.length; j++) {
            if (sumLeft == sumRight) {
                return true;
            } else {
                sumLeft += arr6[j];
                sumRight -= arr6[j];
            }
        }
        return false;
    }

    public static int[] bias(int[] arr7, int n) {
        int[] help = new int[arr7.length];

        if (n > 0) {
            for (int i = arr7.length - 1; i >= 0; i--) {
                if (i + n >= arr7.length) {
                    help[i + n - arr7.length] = arr7[i];
                } else {
                    help[i + n] = arr7[i];
                }
            }
        }
        if (n < 0) {
            for (int i = arr7.length - 1; i >= 0; i--) {
                if (i + n < 0) {
                    help[arr7.length + n + i] = arr7[i];
                } else {
                    help[i + n] = arr7[i];
                }
            }
        }
        return help;
    }

    public static int[] biasExtra(int[] arr7, int n) {
        if (n < 0) {
            for (int i = 0; i < Math.abs(n); i++) {
                for (int j = 0; j < arr7.length -1; j++) {
                    int k = arr7[j + 1];
                    arr7[j + 1] = arr7[j];
                    arr7[j] = k;
                }
            }
        } else {
            for (int i = 0; i < n; i++) {
                for (int j = arr7.length - 1; j > 0; j--) {
                    int k = arr7[j];
                    arr7[j] = arr7[j - 1];
                    arr7[j - 1] = k;
                }
            }
        }
        return arr7;
    }
}


