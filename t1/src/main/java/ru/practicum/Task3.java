package ru.practicum;

import java.io.*;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Task3 {
    public static void main(String[] args) {
        try (BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
             BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(System.out))) {
            String line = reader.readLine();
            String[] arr = line.split(" +");
            int n = Integer.parseInt(arr[0]);
            int t = Integer.parseInt(arr[1]);

            if ((n < 1 || n > 100) || (t < 1 || t > 100)) {
                System.err.println("Ошибка: Число должно находиться в диапазоне от 1 до 100.");
                return;
            }

            List<Integer> floors = new ArrayList<>();

            String line2 = reader.readLine();
            String[] arr2 = line2.split(" +");
            for (int i = 0; i < n; i++) {
                floors.add(Integer.parseInt(arr2[i]));
            }

            int leavingEmployeeIndex = Integer.parseInt(reader.readLine()) - 1;
            // Этаж, куда поднимемся сначала
            int startFloor = floors.get(leavingEmployeeIndex);

            // Удаляем этого сотрудника из списка этажей, чтобы искать оптимальный путь среди остальных
            floors.remove(leavingEmployeeIndex);

            // Минимальное количество ступеней вычисляется следующим образом:
            // Нужно найти общую длину пути, проходя через остальные этажи в оптимальном порядке
            long totalSteps = 0L;

            if (!floors.isEmpty()) {
                // Вычисляем оптимальное направление движения: либо сверху вниз, либо снизу вверх
                boolean moveUpward = true;

                if(startFloor > floors.get(floors.size()-1)) {
                    moveUpward = false;
                }

                // Обходим список этажей в выбранном направлении
                Collections.sort(floors);
                if(!moveUpward) {
                    Collections.reverse(floors);
                }

                // Добавляем шаги от стартового этажа до ближайшего следующего этажа
                totalSteps += Math.abs(startFloor - floors.get(0));

                // Суммируем расстояния между соседними этажами
                for(int i = 0; i < floors.size() - 1; ++i) {
                    totalSteps += Math.abs(floors.get(i+1) - floors.get(i));
                }
            }

            writer.write(String.valueOf(totalSteps));

        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}