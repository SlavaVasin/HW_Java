// Реализовать алгоритм сортировки слиянием
import java.util.Arrays;
import java.util.ArrayList;

public class Task01 {
    public static void main(String[] args) {
        Integer[] arrayToSort = { 11, 2, 1, 65, 9, 0, 10, 8, 54 };

        ArrayList<Integer> sortedArray = new ArrayList<>(Arrays.asList(arrayToSort));
        sortedArray = mergeSort(sortedArray);
        System.out.println(Arrays.toString(arrayToSort));
        System.out.println(sortedArray);
    }

    public static ArrayList<Integer> mergeSort(ArrayList<Integer> inputArray) {
        if (inputArray.size() == 1)
            return inputArray;
        int halfWayPont = inputArray.size() / 2;
        int elementsAfterHalf = inputArray.size() - halfWayPont;
        ArrayList<Integer> leftArray = takePartOfArrayList(inputArray, 0, halfWayPont);
        ArrayList<Integer> rightArray = takePartOfArrayList(inputArray, halfWayPont, elementsAfterHalf);
        leftArray = mergeSort(leftArray);
        rightArray = mergeSort(rightArray);
        return merge(leftArray, rightArray);
    }

    public static ArrayList<Integer> merge(ArrayList<Integer> arrayOne, ArrayList<Integer> arrayTwo) {
        ArrayList<Integer> mergedArray = new ArrayList<>();
        while (!arrayOne.isEmpty() && !arrayTwo.isEmpty()) {
            if (arrayOne.get(0) > arrayTwo.get(0)) {
                mergedArray.add(arrayTwo.get(0));
                arrayTwo.remove(0);
            } else {
                mergedArray.add(arrayOne.get(0));
                arrayOne.remove(0);
            }
        }
        while (!arrayOne.isEmpty()) {
            mergedArray.add(arrayOne.get(0));
            arrayOne.remove(0);
        }
        while (!arrayTwo.isEmpty()) {
            mergedArray.add(arrayTwo.get(0));
            arrayTwo.remove(0);
        }
        return mergedArray;
    }

    public static ArrayList<Integer> takePartOfArrayList(ArrayList<Integer> donorArList, int indexOfStart,
                                                         int elementsCount) {
        ArrayList<Integer> outputArList = new ArrayList<>();
        for (int i = 0; i < elementsCount; i++)
            outputArList.add(donorArList.get(i + indexOfStart));
        return outputArList;
    }
}