package org.example;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        // Ввод данных с консоли
        int[] nums = TaskB.inputArray();

        // Вызов всех методов из TaskB
        TaskB.B01(nums);  // Четные и нечетные числа
        TaskB.B02(nums);  // Наибольшее и наименьшее число
        TaskB.B03(nums);  // Числа, которые делятся на 3 или на 9
        TaskB.B04(nums);  // Числа, которые делятся на 5 и на 7
        TaskB.B05(nums);  // Все трехзначные числа, в десятичной записи которых нет одинаковых цифр
        TaskB.B06(nums);  // Простые числа
        TaskB.B07(nums);  // Отсортированные числа в порядке возрастания и убывания
        TaskB.B08(nums);  // Частота встречаемости чисел
        TaskB.B09(nums);  // Счастливые числа
        TaskB.B10(nums);  // Палиндромы
        TaskB.B11(nums);  // Число, равное среднему арифметическому соседних чисел
    }
}
