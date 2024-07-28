package org.example;

import java.util.Arrays;
import java.util.Collections;

public class RabbitAndCarrots {

    public static int getMaxCarrots(int[] carrots, int maxCarry, int maxTrips) {
        int totalCarrots = 0;
        Integer[] carrotArray = Arrays.stream(carrots).boxed().toArray(Integer[]::new);
        Arrays.sort(carrotArray, Collections.reverseOrder()); // Сортируем массив по убыванию

        int trips = 0;
        for (int i = 0; i < carrotArray.length && trips < maxTrips; i++) {
            while (carrotArray[i] > 0 && trips < maxTrips) {
                int take = Math.min(carrotArray[i], maxCarry);
                totalCarrots += take;
                carrotArray[i] -= take;
                trips++;
            }
        }

        return totalCarrots;
    }

    public static void main(String[] args) {
        int[] carrots = {1, 2, 3, 4, 5}; // Количество моркови на полянках
        int maxCarry = 5; // Максимальный вес, который может унести заяц за одну ходку
        int maxTrips = 10; // Максимальное количество ходок за один день
        int totalCarrots = getMaxCarrots(carrots, maxCarry, maxTrips);
        System.out.println("Заяц сможет унести максимум " + totalCarrots + " кг моркови.");
    }
}

