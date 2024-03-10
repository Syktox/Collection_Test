package Sorting;

import java.util.Random;

public class Sorts {
    public static void bubblesort(int[] array) {
        for (int j = 1; j < array.length; j++) {
            for (int i = 1; i < array.length; i++) {
                if (array[i - 1] > array[i]) {
              
                    int temp = array[i - 1];
                    array[i - 1] = array[i];
                    array[i] = temp;
                }
             }
        }
    }

    public static void inserSort(int[] array) {
        for (int i = 1; i < array.length; i++) {
            int current = array[i];
            int j = i - 1;
            for (; j >= 0 && array[j] > current; j--) {
                array[j + 1] = array[j];
            }
            array[j + 1] = current;
        }
    }
    
    public static void selectSort(int[] array) {
        for (int i = 0; i < array.length - 1; i++) {
            int minIndex = i;
            for (int j = i + 1; j < array.length; j++) {
                if (array[j] < array[minIndex]) {
                    minIndex = j;
                }
            }
            int temp = array[minIndex];
            array[minIndex] = array[i];
            array[i] = temp;
        }
    }


    public static void printArray(int[] arr) {
        for (int i = 0; i < arr.length; i++) {
            System.out.println(arr[i]);
        }
        System.out.println("------------NEW-LINE----------");
    }

    static void shuffleArray(int[] array) {
        Random random = new Random();
        for (int i = array.length - 1; i > 0; i--) {
            int index = random.nextInt(i + 1);
            int temp = array[index];
            array[index] = array[i];
            array[i] = temp;
        }
    }


    public static void main(String[] args) {
        int[] arrayToSort = new int[10];
        for (int i = 0; i < arrayToSort.length; i++) {
            arrayToSort[i] = i;
        }

        shuffleArray(arrayToSort);
        printArray(arrayToSort);
        
        bubblesort(arrayToSort);
        printArray(arrayToSort);
    }   
}
