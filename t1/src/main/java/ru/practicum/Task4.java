package ru.practicum;

import java.io.*;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.PriorityQueue;

public class Task4 {
    public static void main(String[] args) {
        try (BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
             BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(System.out))) {
            String line = reader.readLine();
            String[] arr = line.split(" +");
            int n = Integer.parseInt(arr[0]);
            int k = Integer.parseInt(arr[1]);

            if ((n < 1 || n > 1000) || (k < 1 || k > 10000)) {
                System.err.println("Ошибка: n в диапазоне от 1 до 1000, k в диапазоне от 1 до 10000.");
                return;
            }

            List<Long> numbers = new ArrayList<>();

            String line2 = reader.readLine();
            String[] arr2 = line2.split(" +");
            for (int i = 0; i < n; i++) {
                numbers.add(Long.valueOf(arr2[i]));
            }

            PriorityQueue<Long> gainQueue = new PriorityQueue<>(Collections.reverseOrder());  // очередь максимального приоритета

            // Проходим по каждому числу и считаем возможные улучшения
            for (long number : numbers) {
                String strNum = Long.toString(number);

                long maxIncreaseForNumber = 0L;     // Максимальное улучшение для текущего числа

                char[] digits = strNum.toCharArray();
                for (int pos = 0; pos < digits.length; pos++) {      // Проверяем каждую позицию
                    if (digits[pos] != '9') {                       // Менять имеет смысл только если цифра меньше 9
                        char originalDigit = digits[pos];

                        // Подставляем '9' вместо текущей цифры
                        digits[pos] = '9';
                        long modifiedNumber = Long.parseLong(new String(digits));

                        // Вычисляем прирост и обновляем максимум
                        long increase = modifiedNumber - number;
                        maxIncreaseForNumber = Math.max(maxIncreaseForNumber, increase);

                        // Возвращаем оригинальное значение
                        digits[pos] = originalDigit;
                    }
                }

                // Добавляем лучшее возможное изменение для этого числа
                gainQueue.offer(maxIncreaseForNumber);
            }

            // Берём K лучших изменений
            long totalGain = 0L;
            while (!gainQueue.isEmpty() && k > 0) {
                totalGain += gainQueue.poll();
                k--;
            }

            writer.write(String.valueOf(totalGain));

        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}