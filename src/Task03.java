import java.util.ArrayList;
import java.util.Collections;
import java.util.concurrent.ThreadLocalRandom;

// Задан целочисленный список ArrayList. Найти минимальное, максимальное и среднее из этого списка.

public class Task03 {
    public static void main(String[] args) {
        ArrayList<Integer> inputArray = generateArrayOfIntegers(10, 1, 30);
        System.out.println("Сгенерированный список: \n" + inputArray);

        if (!inputArray.isEmpty()) {
            int min = Collections.min(inputArray);
            int max = Collections.max(inputArray);
            double average = inputArray.stream().mapToDouble(n -> n).sum() / inputArray.size();

            System.out.format("Минимальное: %d, Максимальное: %d, Среднее: %.2f", min, max, average);
        } else {
            System.out.println("Список пуст.");
        }
    }

    public static ArrayList<Integer> generateArrayOfIntegers(int arrayListSize, int min, int max) {
        ArrayList<Integer> outputArrayList = new ArrayList<>();
        for (int i = 0; i < arrayListSize; i++) {
            outputArrayList.add(ThreadLocalRandom.current().nextInt(min, max + 1));
        }
        return outputArrayList;
    }
}