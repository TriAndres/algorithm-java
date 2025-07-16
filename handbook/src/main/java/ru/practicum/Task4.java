package ru.practicum;

import java.io.*;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class Task4 {
    public static void main(String[] args) {
        try (BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
             BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(System.out))) {

            int n = Integer.parseInt(reader.readLine());

            if ((n < 1 || n > 100)) {
                System.err.println("Ошибка: Число должно находиться в диапазоне от 1 до 100.");
                return;
            }

            List<Pair> intervals = new ArrayList<>();

            for (int i = 0; i < n; i++) {
                String line2 = reader.readLine();
                String[] arr2 = line2.split(" ");
                int l = Integer.parseInt(arr2[0]);
                int r = Integer.parseInt(arr2[1]);
                if ((l < 1 || l > 50) || (r < 1 || r > 50)) {
                    System.err.println("Ошибка: Число должно находиться в диапазоне от 1 до 50.");
                    return;
                }
                intervals.add(new Pair(l, r));
            }

            intervals.sort(Comparator.<Pair>comparingInt(p -> p.right));

            writer.write(String.valueOf(findMaxNonOverlappingIntervals(intervals)));

        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    private static int findMaxNonOverlappingIntervals(List<Pair> intervals) {
        int count = 0;
        int lastEndTime = Integer.MIN_VALUE;

        for (Pair interval : intervals) {
            if (interval.left > lastEndTime) {
                count++;
                lastEndTime = interval.right;
            }
        }

        return count;
    }
}

class Pair {
    int left;
    int right;

    public Pair(int left, int right) {
        this.left = left;
        this.right = right;
    }
}