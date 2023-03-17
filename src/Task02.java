import java.util.ArrayList;
import java.util.concurrent.ThreadLocalRandom;

// Пусть дан произвольный список целых чисел, удалить из него чётные числа

public class Task02 {
    public static void main(String[] args) {
        ArrayList<Integer> inputArray = generateArrayOfIntegers(20, 1, 30);
        System.out.println("Сгенерированный список: \n" + inputArray);

        inputArray.removeIf(n -> (n % 2 == 0));
        System.out.println("Список после удаления четных чисел: \n" + inputArray);
    }

    public static ArrayList<Integer> generateArrayOfIntegers(int arrayListSize, int min, int max) {
        ArrayList<Integer> outputArrayList = new ArrayList<>();
        for (int i = 0; i < arrayListSize; i++) {
            outputArrayList.add(ThreadLocalRandom.current().nextInt(min, max + 1));
        }
        return outputArrayList;
    }

}