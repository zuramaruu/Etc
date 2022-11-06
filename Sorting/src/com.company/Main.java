package com.company;

import java.util.Scanner;

public class Main {
    public static int[] u_array = new int[0];
    public static Scanner obj = new Scanner(System.in);
    public static int choice = 0;

    public static void main(String[] args) throws InterruptedException {
        do {
            switch (choice) {
                case 0 -> onChoice();
                case 1 -> onDataChanged();
                case 2 -> onQuickSort();
                case 3 -> onBubbleSort();
                case 4 -> onViewDataAndChoice();
                case 5 -> onEnd();
            }
        } while (choice != 6);
    }

    static void onChoice() {
        System.out.println("Masukan Pilihan Anda : ");
        System.out.println("1. Input data ");
        System.out.println("2. Min to Max (QuickSort) ");
        System.out.println("3. Max to Min (BubbleSort) ");
        System.out.println("4. Cetak Data ");
        System.out.println("5. Keluar ");
        System.out.print("Masukan Pilihan Anda : ");
        choice = obj.nextInt();
    }

    static void onDataChanged() {
        System.out.print("-- Masukan Panjang Data : ");
        int dataLength = obj.nextInt();
        u_array = new int[dataLength];
        for (int a = 0; a < dataLength; a++) {
            System.out.print("Data ke " + (a + 1) + " = ");
            u_array[a] = obj.nextInt();
        }
        choice = 0;
    }

    static void onQuickSort() throws InterruptedException {
        Sorting.quickSort(u_array, 0, u_array.length - 1);
        System.out.println("Quick Sort on loading ... ");
        Thread.sleep(1000);
        System.out.println("Selesai ... ");
        Thread.sleep(500);
        choice = 0;
    }

    static void onBubbleSort() throws InterruptedException {
        Sorting.onBubble(u_array);
        System.out.println("Bubble Sort on loading ... ");
        Thread.sleep(1000);
        System.out.println("Selesai ... ");
        Thread.sleep(500);
        choice = 0;
    }

    static void onViewDataAndChoice() {
        if (u_array == null || u_array.length == 0) {
            System.out.println("Data Anda Kosong");
        } else {
            System.out.println("Data Anda : ");
            for (int j : u_array) {
                System.out.print(j + " ");
            }
            System.out.println();
            // System.out.println(Arrays.toString(u_array));
        }
        System.out.println("Ingin Lagi (y/t) : ");
        char u_choice = Character.toUpperCase(obj.next().charAt(0));
        if (u_choice == 'Y') choice = 0;
        else choice = 5;
    }

    static void onEnd() {
        System.out.println("Terima Kasih .. !!");
        choice = 6;
    }
}

class Sorting {
    static int partition(int[] array, int low, int high) {
        int pivot = array[high];
        int i = (low - 1);
        for (int j = low; j < high; j++) {
            if (array[j] <= pivot) {
                i++;
                int temp = array[i];
                array[i] = array[j];
                array[j] = temp;
            }
        }
        int temp = array[i + 1];
        array[i + 1] = array[high];
        array[high] = temp;
        return (i + 1);
    }

    static void quickSort(int[] array, int low, int high) {
        if (low < high) {
            int pi = partition(array, low, high);
            quickSort(array, low, pi - 1);
            quickSort(array, pi + 1, high);
        }
    }

    public static void onBubble(int[] arrInt) {
        int n = arrInt.length;
        int temp;
        for (int i = 0; i < n; i++) {
            for (int v = 1; v < (n - i); v++) {
                if (arrInt[v - 1] < arrInt[v]) {
                    temp = arrInt[v - 1];
                    arrInt[v - 1] = arrInt[v];
                    arrInt[v] = temp;
                }
            }
        }
    }
}
