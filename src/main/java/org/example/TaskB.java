package org.example;

import java.math.BigInteger;
import java.util.*;

public class TaskB {

    // Метод для ввода массива чисел (например, из консоли)
    public static int[] inputArray() {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Введите числа, разделённые пробелами: ");
        String[] input = scanner.nextLine().split("\\s+");
        int[] nums = new int[input.length];
        for (int i = 0; i < input.length; i++) {
            nums[i] = Integer.parseInt(input[i]);
        }
        return nums;
    }

    // B01: Четные и нечетные числа
    public static void B01(int[] nums) {
        System.out.println("Введенные числа: " + Arrays.toString(nums));
        System.out.print("Четные числа:   ");
        for (int elem : nums) if (elem % 2 == 0) System.out.print(elem + " ");
        System.out.print("\nНечетные числа: ");
        for (int elem : nums) if (elem % 2 != 0) System.out.print(elem + " ");
        System.out.println();
    }

    // B02: Наибольшее и наименьшее число
    public static void B02(int[] nums) {
        int max = nums[0];
        int min = nums[0];
        for (int elem : nums) {
            if (elem < min) min = elem;
            else if (elem > max) max = elem;
        }
        System.out.println("Max: " + max);
        System.out.println("Min: " + min);
    }

    // B03: Числа, которые делятся на 3 или на 9
    public static void B03(int[] nums) {
        System.out.println("Числа, которые делятся на 3 или на 9:");
        for (int el : nums) if (el % 3 == 0 || el % 9 == 0) System.out.print(el + " ");
        System.out.println();
    }

    // B04: Числа, которые делятся на 5 и на 7
    public static void B04(int[] nums) {
        System.out.println("Числа, которые делятся на 5 и на 7:");
        for (int el : nums) if (el % 5 == 0 && el % 7 == 0) System.out.print(el + " ");
        System.out.println();
    }

    // B05: Все трехзначные числа, в десятичной записи которых нет одинаковых цифр
    public static void B05(int[] nums) {
        System.out.println("Трехзначные числа, в десятичной записи которых нет одинаковых цифр:");
        for (int el : nums) {
            if (el >= 100 && el < 1000) {
                int hundreds = el / 100;
                int tens = (el / 10) % 10;
                int units = el % 10;

                if (hundreds != tens && hundreds != units && tens != units) {
                    System.out.print(el + " ");
                }
            }
        }
        System.out.println();
    }

    // B06: Простые числа
    public static void B06(int[] nums) {
        System.out.println("Простые числа:");
        for (int elem : nums) {
            if (BigInteger.valueOf(elem).isProbablePrime((int) Math.log(elem))) {
                System.out.println(elem);
            }
        }
    }

    // B07: Отсортированные числа в порядке возрастания и убывания
    public static void B07(int[] nums) {
        System.out.println("Отсортированные числа в порядке возрастания:");
        int[] arr = nums.clone();
        Arrays.sort(arr);
        for (int i : arr) {
            System.out.println(i);
        }

        System.out.println("Отсортированные числа в порядке убывания:");
        for (int i = arr.length - 1; i >= 0; i--) {
            System.out.println(arr[i]);
        }
    }

    // B08: Частота встречаемости чисел
    public static void B08(int[] nums) {
        Map<Integer, Integer> frequency = new HashMap<>();
        for (int number : nums) {
            frequency.put(number, frequency.getOrDefault(number, 0) + 1);
        }

        List<Map.Entry<Integer, Integer>> sortedNumbers = new ArrayList<>(frequency.entrySet());
        sortedNumbers.sort(Map.Entry.comparingByValue(Comparator.reverseOrder()));

        System.out.println("Частота встречаемости чисел:");
        for (Map.Entry<Integer, Integer> entry : sortedNumbers) {
            System.out.println(entry.getKey() + ": " + entry.getValue());
        }
    }

    // B09: Счастливые числа
    public static void B09(int[] nums) {
        List<Integer> happyNumbers = findHappyNumbers(nums);
        System.out.println("Счастливые числа из списка: " + happyNumbers);
    }

    private static List<Integer> findHappyNumbers(int[] numbers) {
        List<Integer> happyNumbers = new ArrayList<>();
        for (int number : numbers) {
            if (isHappyNumber(number)) {
                happyNumbers.add(number);
            }
        }
        return happyNumbers;
    }

    private static boolean isHappyNumber(int number) {
        Set<Integer> seen = new HashSet<>();
        while (number != 1 && !seen.contains(number)) {
            seen.add(number);
            number = getSumOfSquares(number);
        }
        return number == 1;
    }

    private static int getSumOfSquares(int number) {
        int sum = 0;
        while (number > 0) {
            int digit = number % 10;
            sum += digit * digit;
            number /= 10;
        }
        return sum;
    }

    // B10: Палиндромы
    public static void B10(int[] nums) {
        System.out.println("Палиндромы:");
        for (int el : nums) {
            String str = String.valueOf(el);
            String reverse = new StringBuilder(str).reverse().toString();
            if (str.equals(reverse)) {
                System.out.println(el);
            }
        }
    }

    // B11: Число, равное среднему арифметическому соседних чисел
    public static void B11(int[] nums) {
        if (nums.length > 3) {
            System.out.println("Числа, равные среднему арифметическому соседних чисел:");
            for (int i = 1; i < nums.length - 1; i++) {
                int sum = nums[i - 1] + nums[i + 1];
                if (nums[i] == sum / 2) {
                    System.out.println(nums[i]);
                }
            }
        }
    }
}
